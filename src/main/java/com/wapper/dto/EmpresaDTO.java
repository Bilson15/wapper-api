package com.wapper.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.wapper.model.Empresa;
import com.wapper.model.Endereco;
import com.wapper.model.ItemPedido;
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

	private List<EnderecoDTO> endereco;

	private List<ServicoDTO> servico;
	
	
	

	public EmpresaDTO(Empresa empresa) {

		List<EnderecoDTO> enderecos = new ArrayList<>();
		List<ServicoDTO> servicos = new ArrayList<>();
		
		
		this.id = empresa.getId();
		
		this.razaoSocial = empresa.getRazaoSocial();
		this.email = empresa.getEmail();
		this.dataFundacao = empresa.getDataFundacao();
		this.cnpj = empresa.getCnpj();
		this.ramoAtividade = empresa.getRamoAtividade();
		this.statusEmpresa = empresa.getStatusEmpresa();
		this.telefoneCliente = empresa.getTelefoneCliente();
		
		
		for(Endereco endereco : empresa.getEndereco()) {
			enderecos.add(new EnderecoDTO(endereco));
		}
		this.endereco = enderecos ;
		
	
		
		
		
		for(Servico servico : empresa.getServico()) {
			servicos.add(new ServicoDTO(servico));
		}

		this.servico = servicos;
		

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



	public List<EnderecoDTO> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<EnderecoDTO> endereco) {
		this.endereco = endereco;
	}

	public List<ServicoDTO> getServico() {
		return servico;
	}

	public void setServico(List<ServicoDTO> servico) {
		this.servico = servico;
	}
	
	
}
