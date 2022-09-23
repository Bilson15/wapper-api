package com.wapper.dto;

import java.sql.Date;
import java.util.List;

import com.wapper.model.Empresa;
import com.wapper.model.Endereco;
import com.wapper.model.Servico;
import com.wapper.model.TelefoneCliente;

public class EmpresaDTO {

	private long id;
	
	private String razaoSocial;

	private String email;

	private Date dataFundacao;

	private String cnpj;

	private String ramoAtividade;

	private int statusEmpresa;

	private List<TelefoneCliente> telefoneCliente;

	private List<Endereco> endereco;

	private List<Servico> servico;
	
	
	

	public EmpresaDTO(Empresa empresa) {
		this.id = empresa.getId();
		this.razaoSocial = empresa.getRazaoSocial();
		this.email = empresa.getEmail();
		this.dataFundacao = empresa.getDataFundacao();
		this.cnpj = empresa.getCnpj();
		this.ramoAtividade = empresa.getRamoAtividade();
		this.statusEmpresa = empresa.getStatusEmpresa();
		this.telefoneCliente = empresa.getTelefoneCliente();
		this.endereco = empresa.getEndereco();
		this.servico = empresa.getServico();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRamoAtividade() {
		return ramoAtividade;
	}

	public void setRamoAtividade(String ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}

	public int getStatusEmpresa() {
		return statusEmpresa;
	}

	public void setStatusEmpresa(int statusEmpresa) {
		this.statusEmpresa = statusEmpresa;
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

	public List<Servico> getServico() {
		return servico;
	}

	public void setServico(List<Servico> servico) {
		this.servico = servico;
	}
	
	
}
