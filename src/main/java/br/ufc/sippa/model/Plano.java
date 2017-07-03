package br.ufc.sippa.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Plano {
	@Id
	@GeneratedValue
	private Integer id;
	@NotNull
	private String plano;
	
	private String diario;
	@OneToMany
	List<Presenca> presentes;
	private Date data;
	public Plano(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

	public String getDiario() {
		return diario;
	}

	public void setDiario(String diario) {
		this.diario = diario;
	}

	public List<Presenca> getPresentes() {
		return presentes;
	}

	public void setPresentes(List<Presenca> presentes) {
		this.presentes = presentes;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
}
