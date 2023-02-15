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
@Table(name = "pedido")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private long id;
	
	@Column
	@NotNull
	private String valor_pedido;
	
	@Column
	@NotNull
	private String horario;
	
	@Column
	@NotNull
	private String observacao;
	
	
	@JsonBackReference
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_cliente")
	Cliente cliente;
	
	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getValor_pedido() {
		return valor_pedido;
	}


	public void setValor_pedido(String valor_pedido) {
		this.valor_pedido = valor_pedido;
	}


	public String getHorario() {
		return horario;
	}


	public void setHorario(String horario) {
		this.horario = horario;
	}


	public String getObservacao() {
		return observacao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cliente, horario, id, observacao, valor_pedido);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(horario, other.horario) && id == other.id
				&& Objects.equals(observacao, other.observacao) && Objects.equals(valor_pedido, other.valor_pedido);
	}
	
	

}
