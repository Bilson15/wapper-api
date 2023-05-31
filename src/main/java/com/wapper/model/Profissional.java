package com.wapper.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "profissional")
public class Profissional implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_profissional")
	private Long id_profissional;
	
	@Column
	@NotNull
	private String resumo;
	
	@Column
	@NotNull
	private String nome;
	
	@Column
	@NotNull
	private int status_profissional;
	
	@Column
	@NotNull
	private Time inicio_atendimento;
	
	@Column
	@NotNull
	private Time fim_atendimento;
	
	
	@ManyToOne
	@JoinColumn(name="id_empresa")
	Empresa empresa;
	
	
	@ManyToMany(mappedBy = "profissional")
	private List<Servico> servico;

	
	

	public Profissional() {
		this.servico = new ArrayList<>();
		
	}
	
	
	


	public Empresa getEmpresa() {
		return empresa;
	}








	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}




	public Long getId_profissional() {
		return id_profissional;
	}





	public void setId_profissional(Long id_profissional) {
		this.id_profissional = id_profissional;
	}





	public String getResumo() {
		return resumo;
	}





	public void setResumo(String resumo) {
		this.resumo = resumo;
	}





	public String getNome() {
		return nome;
	}





	public void setNome(String nome) {
		this.nome = nome;
	}





	public int getStatus_profissional() {
		return status_profissional;
	}





	public void setStatus_profissional(int status_profissional) {
		this.status_profissional = status_profissional;
	}





	public Time getInicio_atendimento() {
		return inicio_atendimento;
	}





	public void setInicio_atendimento(Time inicio_atendimento) {
		this.inicio_atendimento = inicio_atendimento;
	}





	public Time getFim_atendimento() {
		return fim_atendimento;
	}





	public void setFim_atendimento(Time fim_atendimento) {
		this.fim_atendimento = fim_atendimento;
	}





	public List<Servico> getServico() {
		return servico;
	}





	public void setServico(List<Servico> servico) {
		this.servico = servico;
	}





	@Override
	public int hashCode() {
		return Objects.hash(fim_atendimento, id_profissional, inicio_atendimento, nome, resumo, servico,
				status_profissional);
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profissional other = (Profissional) obj;
		return Objects.equals(fim_atendimento, other.fim_atendimento)
				&& Objects.equals(id_profissional, other.id_profissional)
				&& Objects.equals(inicio_atendimento, other.inicio_atendimento) && Objects.equals(nome, other.nome)
				&& Objects.equals(resumo, other.resumo) && Objects.equals(servico, other.servico)
				&& status_profissional == other.status_profissional;
	}



















	
	
	

}
