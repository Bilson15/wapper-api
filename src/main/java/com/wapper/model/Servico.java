package com.wapper.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "servico")
public class Servico implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_servico")
	private Long id_servico;
	
	@Column
	@NotNull
	private String titulo;
	
	@Column
	@NotNull
	private String resumo;
	
	@Column
	@NotNull
	private double valor;
	
	@Column
	@NotNull
	private Time tempo;
	
	@Column
	@NotNull
	private int status;
	
	@JsonBackReference
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_empresa")
	private Empresa empresa;
	
	@ManyToMany(mappedBy = "servico")
	private List<Profissional> profissional;
	
	

	public Servico() {

	}
	
	public List<Profissional> getProfissional() {
		return profissional;
	}




	public void setProfissional(List<Profissional> profissional) {
		this.profissional = profissional;
	}
	


	public Long getId_servico() {
		return id_servico;
	}




	public void setId_servico(Long id_servico) {
		this.id_servico = id_servico;
	}




	public String getTitulo() {
		return titulo;
	}




	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}




	public String getResumo() {
		return resumo;
	}




	public void setResumo(String resumo) {
		this.resumo = resumo;
	}




	public double getValor() {
		return valor;
	}




	public void setValor(double valor) {
		this.valor = valor;
	}




	public Time getTempo() {
		return tempo;
	}




	public void setTempo(Time tempo) {
		this.tempo = tempo;
	}




	public int getStatus() {
		return status;
	}




	public void setStatus(int status) {
		this.status = status;
	}




	public Empresa getEmpresa() {
		return empresa;
	}




	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}




	@Override
	public int hashCode() {
		return Objects.hash(empresa, id_servico, profissional, resumo, status, tempo, titulo, valor);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servico other = (Servico) obj;
		return Objects.equals(empresa, other.empresa) && Objects.equals(id_servico, other.id_servico)
				&& Objects.equals(profissional, other.profissional) && Objects.equals(resumo, other.resumo)
				&& status == other.status && Objects.equals(tempo, other.tempo) && Objects.equals(titulo, other.titulo)
				&& Double.doubleToLongBits(valor) == Double.doubleToLongBits(other.valor);
	}



	
	
	
}