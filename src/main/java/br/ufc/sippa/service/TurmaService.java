package br.ufc.sippa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.sippa.model.Turma;
import br.ufc.sippa.model.Usuario;
import br.ufc.sippa.repository.TurmaRepository;
import br.ufc.sippa.repository.PresencaRepository;
import br.ufc.sippa.repository.UsuarioRepository;

@Service
public class TurmaService {
	@Autowired
	TurmaRepository repoTurma;
	@Autowired
	UsuarioRepository repoUsuario;
	@Autowired
	PresencaRepository repoPresenca;
	
	public Turma salvarTurma(String codigo,String nome){
		Turma turma = new Turma();
		turma.setNome(nome);
		turma.setPeriodo(null);
		turma.setProfessor(null);
		turma.setPlano(null);
		turma.setAlunos(null);
		repoTurma.save(turma);
		return turma;
	}
	
	public void alocarAluno(Integer idTurma,Long idAluno){
		Turma turma = repoTurma.findById(idTurma);
		Usuario aluno = repoUsuario.findOne(idAluno);
		turma.getAlunos().add(aluno);
		
		repoTurma.save(turma);
	}
	
	public List<Turma> getTodasTurmas(){
		return repoTurma.findAll();
	}
	
	public List<Turma> getTurmasPorPeriodo(String periodo){
		return repoTurma.findByPeriodo(periodo);
	}
	
	public List<Turma> getTurmasPorProfessor(Usuario professor){
		return repoTurma.findByProfessor(professor);
	}
	
	public void removerTurma(Integer id) {
		repoTurma.delete(repoTurma.findById(id));		
	}
}
