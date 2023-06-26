package com.wapper.dto;

import java.sql.Time;

import com.wapper.model.Profissional;



public class ProfissionalDTO {
	

	private Long id_profissional;
	private String resumo;
	private String nome;
	private int status_profissional;
	private Time inicio_atendimento;
	private Time fim_atendimento;
	private EmpresaBasicDTO empresa;
	
	
	
	
	
	
	
	public ProfissionalDTO(Long id_profissional, String resumo, String nome, int status_profissional,
			Time inicio_atendimento, Time fim_atendimento, EmpresaBasicDTO empresa) {
		this.id_profissional = id_profissional;
		this.resumo = resumo;
		this.nome = nome;
		this.status_profissional = status_profissional;
		this.inicio_atendimento = inicio_atendimento;
		this.fim_atendimento = fim_atendimento;
		this.empresa = empresa;
	}
	
	
	public ProfissionalDTO(Profissional profissional) {
		this.id_profissional = profissional.getId_profissional();
		this.resumo = profissional.getResumo();
		this.nome = profissional.getNome();
		this.status_profissional = profissional.getStatus_profissional();
		this.inicio_atendimento = profissional.getInicio_atendimento();
		this.fim_atendimento = profissional.getFim_atendimento();
		if(profissional.getEmpresa() != null) {
			this.empresa = new EmpresaBasicDTO(profissional.getEmpresa());
		}
		
	}
	
	
	public Long getId_profissional() {
		return id_profissional;
	}
	public void setId_profissional(Long id_profissional) {
		this.id_profissional = id_profissional;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getStatus_profissional() {
		return status_profissional;
	}
	public void setStatus_profissional(int status_profissional) {
		this.status_profissional = status_profissional;
	}
	public Time getInicio_atendimento() {
		return inicio_atendimento;
	}
	public void setInicio_atendimento(Time inicio_atendimento) {
		this.inicio_atendimento = inicio_atendimento;
	}
	public Time getFim_atendimento() {
		return fim_atendimento;
	}
	public void setFim_atendimento(Time fim_atendimento) {
		this.fim_atendimento = fim_atendimento;
	}
	public EmpresaBasicDTO getEmpresa() {
		return empresa;
	}
	public void setEmpresa(EmpresaBasicDTO empresa) {
		this.empresa = empresa;
	}
	
	
	
	
	
	
	
	

}
