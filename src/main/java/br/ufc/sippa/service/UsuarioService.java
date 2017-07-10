package br.ufc.sippa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.sippa.model.Usuario;
import br.ufc.sippa.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository repo;
	
	public Usuario salvarUsuario(String login,String nome,String senha, String tipo){
		Usuario user = new Usuario();
		user.setLogin(login);
		user.setNome(nome);
		user.setSenha(senha);
		user.setTipo(tipo);
		repo.save(user);
		
		return user;
	}
	
	public List<Usuario> getTodosUsuarios(){
		return repo.findAll();
	}
	public List<Usuario> getAdministradores(){
		return repo.findByTipo("administrador");
	}
	public List<Usuario> getProfessores(){
		return repo.findByTipo("professor");
	}
	public List<Usuario> getAlunos(){
		return repo.findByTipo("aluno");
	}

	public void removerConta(Integer id) {
		repo.delete(repo.findById(id));		
	}
}
