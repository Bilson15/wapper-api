package com.wapper.model;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "telefone_cliente")
public class TelefoneCliente implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_telefone_cliente")
	private long idTelefoneCliente;
	
	@Column
	@NotNull
	private int ddd;
	
	@Column
	@NotNull
	private int telefone;
	
	@Column(name = "status_telefone")
	@NotNull
	private int statusTelefone;
	
	@JsonBackReference
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_cliente")
	Cliente cliente;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_empresa")
	Empresa empresa;


	public TelefoneCliente() {
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	



	public Empresa getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	public long getIdTelefoneCliente() {
		return idTelefoneCliente;
	}


	public void setIdTelefoneCliente(long idTelefoneCliente) {
		this.idTelefoneCliente = idTelefoneCliente;
	}


	public int getDdd() {
		return ddd;
	}


	public void setDdd(int ddd) {
		this.ddd = ddd;
	}


	public int getTelefone() {
		return telefone;
	}


	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}


	public int getStatusTelefone() {
		return statusTelefone;
	}


	public void setStatusTelefone(int statusTelefone) {
		this.statusTelefone = statusTelefone;
	}


	@Override
	public int hashCode() {
		return Objects.hash(ddd, idTelefoneCliente, statusTelefone, telefone);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TelefoneCliente other = (TelefoneCliente) obj;
		return ddd == other.ddd && idTelefoneCliente == other.idTelefoneCliente && statusTelefone == other.statusTelefone
				&& telefone == other.telefone;
	}
	
	
	

	
	
}
