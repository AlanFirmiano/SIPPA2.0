package br.ufc.sippa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.sippa.model.Usuario_papel;
import br.ufc.sippa.repository.PapelRepository;

@Transactional
@Service
public class PapelService implements IPapelService{

	@Autowired
	private PapelRepository repository;

	@Override
	public List<Usuario_papel> findAll() {
		return repository.findAll();
	}

	@Override
	public Usuario_papel findOne(long id) {
		return repository.findOne(id);
	}

	@Override
	public Usuario_papel update(Usuario_papel usuario) {
		return repository.save(usuario);
	}

	@Override
	public void delete(long id) {
		repository.delete(id);
	}

	@Override
	public Usuario_papel save(Usuario_papel usuario) {
		return repository.save(usuario);
	}
	
}
