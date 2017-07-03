package br.ufc.sippa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.sippa.model.Presenca;
import br.ufc.sippa.model.Usuario;
import br.ufc.sippa.repository.PresencaRepository;

@Service
public class PresencaService {
	@Autowired
	PresencaRepository repo;
	
	public Presenca salvarPresenca(Usuario aluno,boolean status){
		Presenca presenca = new Presenca();
		presenca.setAluno(aluno);
		presenca.setStatus(status);
		repo.save(presenca);
		
		return presenca;
	}
	
	public List<Presenca> getTodasPresencas(){
		return repo.findAll();
	}
	
}
