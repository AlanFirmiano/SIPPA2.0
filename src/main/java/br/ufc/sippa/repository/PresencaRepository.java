package br.ufc.sippa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.sippa.model.Presenca;

@Repository
public interface PresencaRepository extends JpaRepository<Presenca, Integer>{
	
}
