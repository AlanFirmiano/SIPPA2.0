package br.ufc.sippa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.sippa.model.Disciplina;
import br.ufc.sippa.repository.DisciplinaRepository;

@Service
public class DisciplinaService {
	@Autowired
	DisciplinaRepository repoDisc;
	
	public Disciplina save(Disciplina disciplina){
		return repoDisc.save(disciplina);
	}
	
	public Disciplina findOne(Integer id){
		return repoDisc.findOne(id);
	}
	
	public List<Disciplina> findAll(){
		return repoDisc.findAll();
	}
	public Disciplina findByCodigo(String codigo){
		return repoDisc.findByCodigo(codigo);
	}
	
	public void delete(Integer id) {
		repoDisc.delete(repoDisc.findById(id));		
	}


	
}
