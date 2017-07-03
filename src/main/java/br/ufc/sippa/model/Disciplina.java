package br.ufc.sippa.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


@Entity
public class Disciplina {
	@Id
	@GeneratedValue
	private Integer id;
	@NotNull
	private String codigo;
	@NotNull
	private String nome;
	@ManyToOne
	private Usuario professor;
	@NotNull
	private String periodo;
	@OneToMany
	List<Presenca> aulas;
	
	
	public Disciplina(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Usuario getProfessor() {
		return professor;
	}

	public void setProfessor(Usuario professor) {
		this.professor = professor;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public List<Presenca> getAulas() {
		return aulas;
	}

	public void setAulas(List<Presenca> aulas) {
		this.aulas = aulas;
	}
	
}
