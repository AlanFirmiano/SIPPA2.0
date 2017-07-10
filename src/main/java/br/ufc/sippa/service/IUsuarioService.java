package br.ufc.sippa.service;

import java.util.List;

import br.ufc.sippa.model.Usuario;

public interface IUsuarioService {
	
	public Usuario save(Usuario usuario);

	public List<Usuario> findAll();

	public Usuario findOne(long id);

	public Usuario update(Usuario usuario);
	
	public Usuario findByLogin(String login);

	public void delete(long id);
}
