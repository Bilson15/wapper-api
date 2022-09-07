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
@Table(name = "empresa")
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_empresa")
	private long id;
	
	@Column(name = "razao_social")
	@NotNull
	private String razaoSocial;
	
	@Column
	@NotNull
	private String email;
	
	@Column
	@NotNull
	private String senha;
	
	@Column(name = "data_fundacao")
	@NotNull
	private Date dataFundacao;
	
	@Column
	@NotNull
	private String cnpj;
	
	@Column(name = "ramo_atividade")
	@NotNull
	private String ramoAtividade;
	
	@Column(name = "status_empresa")
	@NotNull
	private int statusEmpresa;
	

	@JsonManagedReference
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<TelefoneCliente> telefoneCliente;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Endereco> endereco;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Servico> servico;



	public Empresa() {
		this.telefoneCliente = new ArrayList<>();
		this.endereco = new ArrayList<>();
		this.servico = new ArrayList<>();
	}
	


	public List<Servico> getServico() {
		return servico;
	}



	public void setServico(List<Servico> servico) {
		this.servico = servico;
	}



	public long getId() {
		return id;
	}
	
	


	public List<Endereco> getEndereco() {
		return endereco;
	}


	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
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


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
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



	@Override
	public int hashCode() {
		return Objects.hash(cnpj, dataFundacao, email, endereco, id, servico, ramoAtividade, razaoSocial, senha,
				statusEmpresa, telefoneCliente);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(dataFundacao, other.dataFundacao)
				&& Objects.equals(email, other.email) && Objects.equals(endereco, other.endereco) && id == other.id
				&& Objects.equals(servico, other.servico)
				&& Objects.equals(ramoAtividade, other.ramoAtividade) && Objects.equals(razaoSocial, other.razaoSocial)
				&& Objects.equals(senha, other.senha) && statusEmpresa == other.statusEmpresa
				&& Objects.equals(telefoneCliente, other.telefoneCliente);
	}
	


	

}
