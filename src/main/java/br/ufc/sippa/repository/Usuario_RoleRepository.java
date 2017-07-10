package br.ufc.sippa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.sippa.model.Usuario_papel;

public interface Usuario_RoleRepository extends JpaRepository<Usuario_papel, Long> {
	
}
