package com.wapper.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "telefone_cliente")
public class TelefoneCliente implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_telefone_cliente")
	private long id;
	
	@Column
	@NotNull
	private int ddd;
	
	@Column
	@NotNull
	private int telefone;
	
	@Column(name = "status_telefone")
	@NotNull
	private int statusTelefone;


	public TelefoneCliente() {
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
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
		return Objects.hash(ddd, id, statusTelefone, telefone);
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
		return ddd == other.ddd && id == other.id && statusTelefone == other.statusTelefone
				&& telefone == other.telefone;
	}
	
	
	

	
	
}
