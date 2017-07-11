package br.ufc.sippa.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Turma {
	@Id
	@GeneratedValue
	private Integer id;
	@NotNull
	private String nome;
	@OneToOne
	private Disciplina disciplina;
	@OneToOne
	private Usuario professor;
	@NotNull
	private String periodo;
	@OneToMany
	List<Plano> plano;
	@ManyToMany
	List<Usuario> alunos;
	
	public Turma(){}

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

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
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

	public List<Plano> getPlano() {
		return plano;
	}

	public void setPlano(List<Plano> plano) {
		this.plano = plano;
	}

	public List<Usuario> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Usuario> alunos) {
		this.alunos = alunos;
	}
	
	public void addAlunos(Usuario aluno) {
		this.alunos.add(aluno);
	}
	
}
