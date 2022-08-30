package com.wapper.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private long idCliente;
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
	
	@JsonManagedReference
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	List<TelefoneCliente> telefoneCliente;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	List<Endereco> endereco;
	
	
	public Cliente() {
		this.telefoneCliente = new ArrayList<>();
		this.endereco = new ArrayList<>();
	}



	public long getIdCliente() {
		return idCliente;
	}



	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
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



	public Date getDataNascimento() {
		return dataNascimento;
	}



	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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



	public int getStatusCliente() {
		return statusCliente;
	}



	public void setStatusCliente(int statusCliente) {
		this.statusCliente = statusCliente;
	}



	public List<TelefoneCliente> getTelefoneCliente() {
		return this.telefoneCliente;
	}



	public void setTelefoneCliente(List<TelefoneCliente> telefoneCliente) {
		//telefoneCliente.forEach(child -> child.setCliente(this));
		this.telefoneCliente = telefoneCliente;
	}



	public List<Endereco> getEndereco() {
		return endereco;
	}



	public void setEndereco(List<Endereco> endereco) {
		//endereco.forEach(child -> child.setCliente(this));
		this.endereco = endereco;
	}



	@Override
	public int hashCode() {
		return Objects.hash(cpf, dataNascimento, email, idCliente, nome, senha, sexo, statusCliente);
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
				&& Objects.equals(email, other.email) && idCliente == other.idCliente && Objects.equals(nome, other.nome)
				&& Objects.equals(senha, other.senha) && Objects.equals(sexo, other.sexo)
				&& statusCliente == other.statusCliente;
	}
	
	
	
}
