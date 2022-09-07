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
@Table(name = "endereco")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private long idEndereco;
	
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
	
	@Column
	@NotNull
	private String bairro;
	
	@JsonBackReference
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_cliente")
	Cliente cliente;
	
	
	@JsonBackReference
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_empresa")
	Empresa empresa;

	public Endereco() {
	}
	

	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public long getIdEndereco() {
		return idEndereco;
	}


	public void setIdEndereco(long idEndereco) {
		this.idEndereco = idEndereco;
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
	
	

	public Empresa getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cep, complemento, idEndereco, logradouro, numero, statusEndereco);
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
		return cep == other.cep && Objects.equals(complemento, other.complemento) && idEndereco == other.idEndereco
				&& Objects.equals(logradouro, other.logradouro) && Objects.equals(numero, other.numero)
				&& statusEndereco == other.statusEndereco;
	}
	
	
	
	
}
