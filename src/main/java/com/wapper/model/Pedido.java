package com.wapper.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;





import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private long id_pedido;
	
	@Column
	@NotNull
	private double valor_pedido;
	
	@Column
	@NotNull
	private Time horario_marcado;
	
	@Column
	@NotNull
	private Date dia_marcado;
	
	@Column
	private String observacao;
	
	@Column
	private int status;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="id_empresa")
	private Empresa empresa;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_pedido", nullable = false, updatable = false, insertable = true)
	private List<ItemPedido> itemPedido = new ArrayList<>();
	

	public long getId() {
		return id_pedido;
	}

	public void setId(long id) {
		this.id_pedido = id;
	}

	public double getValor_pedido() {
		return valor_pedido;
	}

	public void setValor_pedido(double valor_pedido) {
		this.valor_pedido = valor_pedido;
	}

	public Time getHorario_marcado() {
		return horario_marcado;
	}

	public void setHorario_marcado(Time horario_marcado) {
		this.horario_marcado = horario_marcado;
	}

	public Date getDia_marcado() {
		return dia_marcado;
	}

	public void setDia_marcado(Date dia_marcado) {
		this.dia_marcado = dia_marcado;
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
	


	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public long getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(long id_pedido) {
		this.id_pedido = id_pedido;
	}

	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}
	
	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, dia_marcado, empresa, horario_marcado, id_pedido, itemPedido, observacao, status,
				valor_pedido);
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
		return Objects.equals(cliente, other.cliente) && Objects.equals(dia_marcado, other.dia_marcado)
				&& Objects.equals(empresa, other.empresa) && Objects.equals(horario_marcado, other.horario_marcado)
				&& id_pedido == other.id_pedido && Objects.equals(itemPedido, other.itemPedido)
				&& Objects.equals(observacao, other.observacao) && status == other.status
				&& Double.doubleToLongBits(valor_pedido) == Double.doubleToLongBits(other.valor_pedido);
	}


	
	








	

}
