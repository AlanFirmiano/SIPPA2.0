package br.ufc.sippa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.sippa.model.Turma;
import br.ufc.sippa.model.Usuario;


@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer>{
	
	Turma findById(Integer id);
		
	List<Turma> findByPeriodo(String periodo);
	
	List<Turma> findByProfessor(Usuario professor);
	
}
