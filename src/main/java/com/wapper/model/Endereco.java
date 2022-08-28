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
@Table(name = "endereco")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private long id;
	
	@Column
	@NotNull
	private String logradouro;
	
	@Column
	private String complemento;
	
	@Column
	private String numero;
	
	@Column
	private int cep;
	
	@Column(name = "status_endereco")
	@NotNull
	private int statusEndereco;

	public Endereco() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public int getStatusEndereco() {
		return statusEndereco;
	}

	public void setStatusEndereco(int statusEndereco) {
		this.statusEndereco = statusEndereco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep, complemento, id, logradouro, numero, statusEndereco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return cep == other.cep && Objects.equals(complemento, other.complemento) && id == other.id
				&& Objects.equals(logradouro, other.logradouro) && Objects.equals(numero, other.numero)
				&& statusEndereco == other.statusEndereco;
	}
	
	
	
	
}
