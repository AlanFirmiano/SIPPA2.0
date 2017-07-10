package br.ufc.sippa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.sippa.model.Disciplina;
import br.ufc.sippa.model.Usuario;
import br.ufc.sippa.repository.DisciplinaRepository;
import br.ufc.sippa.repository.PresencaRepository;
import br.ufc.sippa.repository.UsuarioRepository;

@Service
public class DisciplinaService {
	@Autowired
	DisciplinaRepository repoDisc;
	@Autowired
	UsuarioRepository repoUsuario;
	@Autowired
	PresencaRepository repoPresenca;
	
	public Disciplina salvarDisciplina(String codigo,String nome,String periodo/*,Usuario professor*/){
		Disciplina disciplina = new Disciplina();
		disciplina.setCodigo(codigo);
		disciplina.setNome(nome);
		disciplina.setPeriodo(periodo);
		//disciplina.setProfessor(professor);
		disciplina.setPlano(null);
		disciplina.setAlunos(null);
		repoDisc.save(disciplina);
		
		return disciplina;
	}
	
	public void alocarAluno(Integer idDisciplina,Integer idAluno){
		Disciplina disc = repoDisc.findById(idDisciplina);
		Usuario aluno = repoUsuario.findOne(idAluno);
		disc.getAlunos().add(aluno);
		
		repoDisc.save(disc);
	}
	
	public List<Disciplina> getTodasDisciplinas(){
		return repoDisc.findAll();
	}
	
	public List<Disciplina> getDisciplinasPorPeriodo(String periodo){
		return repoDisc.findByPeriodo(periodo);
	}
	
	public List<Disciplina> getDisciplinasPorProfessor(Usuario professor){
		return repoDisc.findByProfessor(professor);
	}
	
	public Disciplina getPorCodigo(String codigo){
		return repoDisc.findByCodigo(codigo);
	}
	
	public void removerDisciplina(Integer id) {
		repoDisc.delete(repoDisc.findById(id));		
	}
}
