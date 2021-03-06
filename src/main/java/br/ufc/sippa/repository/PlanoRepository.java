package br.ufc.sippa.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.sippa.model.Plano;
import br.ufc.sippa.model.Usuario;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Integer>{
	
	List<Plano> findByData(Date data);
	
	List<Usuario> findByPresentesAluno(Usuario aluno);

}
