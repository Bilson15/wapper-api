package com.wapper.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private long id;
	@Column
	@NotNull
	private String nome;
	
	@Column
	@NotNull
	private String email;
	
	@Column
	@NotNull
	private String senha;
	
	@Column(name = "data_nascimento")
	@NotNull
	private Date dataNascimento;
	
	@Column
	@NotNull
	private String cpf;
	
	@Column
	@NotNull
	private String sexo;
	
	@Column(name = "status_cliente")
	@NotNull
	private int statusCliente;
	
	
	public Cliente() {

	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Date getData_nascimento() {
		return dataNascimento;
	}


	public void setData_nascimento(Date data_nascimento) {
		this.dataNascimento = data_nascimento;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public int getStatus_cliente() {
		return statusCliente;
	}


	public void setStatus_cliente(int status_cliente) {
		this.statusCliente = status_cliente;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cpf, dataNascimento, email, id, nome, senha, sexo, statusCliente);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(dataNascimento, other.dataNascimento)
				&& Objects.equals(email, other.email) && id == other.id && Objects.equals(nome, other.nome)
				&& Objects.equals(senha, other.senha) && Objects.equals(sexo, other.sexo)
				&& statusCliente == other.statusCliente;
	}
	
	
	
}
