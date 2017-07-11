package br.ufc.sippa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.ufc.sippa.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Query("SELECT us FROM Usuario us WHERE us.login =:login")
	public Usuario findByLogin(@Param("login") String login);
	
	Usuario findOne(Long id);
	
	List<Usuario> findByPapelNome(String papel);
	
	List<Usuario> findByNome(String nome);

}
