package com.wapper.model;

import java.io.Serializable;
import java.util.Objects;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "item_pedido")
public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item_pedido")
	private int id_item_pedido;
	
	@Column
	@NotNull
	private double valor_item;
	


	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="id_servico")
	private Servico servico;
	

	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="id_profissional")
	private Profissional profissional;
	
	
	public ItemPedido() {}

	public int getId_item_pedido() {
		return id_item_pedido;
	}

	public void setId_item_pedido(int id_item_pedido) {
		this.id_item_pedido = id_item_pedido;
	}

	public double getValor_item() {
		return valor_item;
	}

	public void setValor_item(double valor_item) {
		this.valor_item = valor_item;
	}


	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_item_pedido, profissional, servico, valor_item);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		return id_item_pedido == other.id_item_pedido
				&& Objects.equals(profissional, other.profissional) && Objects.equals(servico, other.servico)
				&& Double.doubleToLongBits(valor_item) == Double.doubleToLongBits(other.valor_item);
	}
	


	
	


	
	
	

}
