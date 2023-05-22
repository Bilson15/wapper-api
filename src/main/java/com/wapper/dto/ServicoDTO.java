package com.wapper.dto;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import com.wapper.model.Profissional;
import com.wapper.model.Servico;




public class ServicoDTO {
	

	
	private Long id_servico;
	private String titulo;
	private String resumo;
	private double valor;
	private Time tempo;
	private int status;
	private List<ProfissionalDTO> profissional;
	
	
	
	
	
	public ServicoDTO(Long id_servico, String titulo, String resumo, double valor, Time tempo, int status,
			List<ProfissionalDTO> profissional) {
		this.id_servico = id_servico;
		this.titulo = titulo;
		this.resumo = resumo;
		this.valor = valor;
		this.tempo = tempo;
		this.status = status;
		this.profissional = profissional;
	}



	public ServicoDTO(Servico servico) {
		List<ProfissionalDTO> profissionais = new ArrayList<>();
		
		this.id_servico = servico.getId_servico();
		this.titulo = servico.getTitulo();
		this.resumo = servico.getResumo();
		this.valor = servico.getValor();
		this.tempo = servico.getTempo();
		this.status = servico.getStatus();
		
		for(Profissional profissional : servico.getProfissional()) {
			profissionais.add(new ProfissionalDTO(profissional));
		}
		
		this.profissional =  profissionais;
		
	}
	
	
	
	public Long getId_servico() {
		
		return id_servico;
	}
	public void setId_servico(Long id_servico) {
		this.id_servico = id_servico;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Time getTempo() {
		return tempo;
	}
	public void setTempo(Time tempo) {
		this.tempo = tempo;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<ProfissionalDTO> getProfissional() {
		return profissional;
	}
	public void setProfissional(List<ProfissionalDTO> profissional) {
		this.profissional = profissional;
	}
	
	
	
	
}

