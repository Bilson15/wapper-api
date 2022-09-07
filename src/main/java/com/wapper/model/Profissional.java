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
	private Time horario_disponibilidade;
	
	
	  @ManyToMany
	  @JoinTable(
        name = "servico_profissional",
        joinColumns = @JoinColumn(
                name = "id_profissional"
        		),
        inverseJoinColumns = @JoinColumn(
                name = "id_servico"
        		)
		)
		@JsonIgnore
		  private List<Servico> servico;

	
	

	public Profissional() {
		this.servico = new ArrayList<>();
		
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





	public Time getHorario_disponibilidade() {
		return horario_disponibilidade;
	}





	public void setHorario_disponibilidade(Time horario_disponibilidade) {
		this.horario_disponibilidade = horario_disponibilidade;
	}





	public List<Servico> getServico() {
		return servico;
	}





	public void setServico(List<Servico> servico) {
		this.servico = servico;
	}





	@Override
	public int hashCode() {
		return Objects.hash(horario_disponibilidade, id_profissional, nome, resumo, servico, status_profissional);
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
		return Objects.equals(horario_disponibilidade, other.horario_disponibilidade)
				&& Objects.equals(id_profissional, other.id_profissional) && Objects.equals(nome, other.nome)
				&& Objects.equals(resumo, other.resumo) && Objects.equals(servico, other.servico)
				&& status_profissional == other.status_profissional;
	}














	
	
	

}
