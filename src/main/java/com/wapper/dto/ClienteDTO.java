package com.wapper.dto;

import java.sql.Date;
import java.util.List;

import com.wapper.model.Cliente;
import com.wapper.model.Endereco;
import com.wapper.model.TelefoneCliente;

public class ClienteDTO {

	private long idCliente;
	private String nome;
	private String email;
	private Date dataNascimento;
	private String cpf;
	private String sexo;
	private int statusCliente;
	List<TelefoneCliente> telefoneCliente;
	List<Endereco> endereco;
	
	
	
	
	public ClienteDTO() {}
	
	public ClienteDTO(long idCliente, String nome, String email, Date dataNascimento, String cpf, String sexo,
		int statusCliente, 
		List<TelefoneCliente> telefoneCliente, 
		List<Endereco> endereco) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.sexo = sexo;
		this.statusCliente = statusCliente;
		this.telefoneCliente = telefoneCliente;
		this.endereco = endereco;
	}
	
	public ClienteDTO(Cliente cliente) {
		this.idCliente = cliente.getIdCliente();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.dataNascimento = cliente.getDataNascimento();
		this.cpf = cliente.getCpf();
		this.sexo = cliente.getSexo();
		this.statusCliente = cliente.getStatusCliente();
		this.telefoneCliente = cliente.getTelefoneCliente();
		this.endereco = cliente.getEndereco();
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
		return telefoneCliente;
	}
	public void setTelefoneCliente(List<TelefoneCliente> telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}
	public List<Endereco> getEndereco() {
		return endereco;
	}
	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}
	
	
}
