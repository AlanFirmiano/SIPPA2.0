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
	
	public Disciplina salvarDisciplina(String codigo,String nome){
		Disciplina disciplina = new Disciplina();
		disciplina.setCodigo(codigo);
		disciplina.setNome(nome);
		repoDisc.save(disciplina);
		return disciplina;
	}
	
	public List<Disciplina> getTodasDisciplinas(){
		return repoDisc.findAll();
	}
	
	public Disciplina getPorCodigo(String codigo){
		return repoDisc.findByCodigo(codigo);
	}
	
	public void removerDisciplina(Integer id) {
		repoDisc.delete(repoDisc.findById(id));		
	}
	
}
