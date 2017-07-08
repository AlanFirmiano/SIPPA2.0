package br.ufc.sippa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.sippa.model.Presenca;
import br.ufc.sippa.model.Usuario;
import br.ufc.sippa.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository repo;
	
	public Usuario salvarUsuario(String login,String nome,String senha){
		Usuario user = new Usuario();
		user.setLogin(login);
		user.setNome(nome);
		user.setSenha(senha);
		repo.save(user);
		
		return user;
	}
	
	public List<Usuario> getTodosUsuarios(){
		return repo.findAll();
	}

	public void removerConta(Integer id) {
		repo.delete(repo.findById(id));		
	}
}
