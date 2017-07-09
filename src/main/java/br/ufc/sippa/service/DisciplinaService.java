package br.ufc.sippa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.sippa.model.Disciplina;
import br.ufc.sippa.model.Usuario;
import br.ufc.sippa.repository.DisciplinaRepository;

@Service
public class DisciplinaService {
	@Autowired
	DisciplinaRepository repo;
	
	public Disciplina salvarDisciplina(String codigo,String nome,String periodo/*,Usuario professor*/){
		Disciplina disciplina = new Disciplina();
		disciplina.setCodigo(codigo);
		disciplina.setNome(nome);
		disciplina.setPeriodo(periodo);
		//disciplina.setProfessor(professor);
		disciplina.setAulas(null);
		repo.save(disciplina);
		
		return disciplina;
	}
	
	public List<Disciplina> getTodasDisciplinas(){
		return repo.findAll();
	}
	
	public List<Disciplina> getDisciplinasPorPeriodo(String periodo){
		return repo.findByPeriodo(periodo);
	}
	
	public List<Disciplina> getDisciplinasPorProfessor(Usuario professor){
		return repo.findByProfessor(professor);
	}
	
	public Disciplina getPorCodigo(String codigo){
		return repo.findByCodigo(codigo);
	}
	
	public void removerDisciplina(Integer id) {
		repo.delete(repo.findById(id));		
	}
}
