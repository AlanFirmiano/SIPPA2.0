package br.ufc.sippa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.sippa.model.Usuario;
import br.ufc.sippa.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario findByLogin(String login) {
		return repository.findByLogin(login);
	}

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Usuario findOne(Long id) {
		return repository.findOne(id);
	}

	public Usuario update(Usuario usuario) {
		return repository.save(usuario);
	}

	public void delete(Long id) {
		repository.delete(id);
	}

	public Usuario save(Usuario usuario) {
		return repository.save(usuario);
	}
	
	public List<Usuario> getTodosUsuarios(){
		return repository.findAll();
	}
	public List<Usuario> getUsuarioPorPapel(String papel){
		return repository.findByPapelNome(papel);
	}
	
//	public List<Usuario> getAdministradores(){
//		return repository.findByTipo("administrador");
//	}
//	public List<Usuario> getProfessores(){
//		return repository.findByTipo("professor");
//	}
//	public List<Usuario> getAlunos(){
//		return repository.findByTipo("aluno");
//	}

}
