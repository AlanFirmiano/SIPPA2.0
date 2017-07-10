package br.ufc.sippa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.sippa.model.Usuario_papel;

@Repository
public interface PapelRepository extends JpaRepository<Usuario_papel, Long>{
	
}
