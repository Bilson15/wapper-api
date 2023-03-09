package com.wapper.dto;

import java.util.ArrayList;
import java.util.List;

import com.wapper.model.Endereco;

public class EnderecoDTO {

	private long idEndereco;
	private String logradouro;
	private String complemento;
	private String numero;
	private int cep;
	private int statusEndereco;
	private String bairro;
	
	
	
	
	
	
	public EnderecoDTO(long idEndereco, String logradouro, String complemento, String numero, int cep,
			int statusEndereco, String bairro) {
		this.idEndereco = idEndereco;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.numero = numero;
		this.cep = cep;
		this.statusEndereco = statusEndereco;
		this.bairro = bairro;
	}





	public EnderecoDTO(Endereco endereco) {
		this.idEndereco = endereco.getIdEndereco();
		this.logradouro = endereco.getLogradouro();
		this.complemento = endereco.getComplemento();
		this.numero = endereco.getNumero();
		this.cep = endereco.getCep();
		this.statusEndereco = endereco.getStatusEndereco();
		this.bairro = endereco.getBairro();
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
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	
	
	
}
