package com.wapper.dto;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.wapper.model.Cliente;
import com.wapper.model.ItemPedido;
import com.wapper.model.Pedido;


public class PedidoDTO {
	

	private long id;
	private double valor_pedido;
	private Time horario_marcado;
	private Date dia_marcado;
	private String observacao;
	private int status;
	private Cliente cliente;
	private List<ItemPedidoDTO> itemPedido;
	
	
	
	public PedidoDTO() {

	}
	
	
	public PedidoDTO(long id, double valor_pedido, Time horario_marcado, Date dia_marcado, String observacao,
			Cliente cliente, List<ItemPedidoDTO> itemPedido, int status) {

		this.id = id;
		this.valor_pedido = valor_pedido;
		this.horario_marcado = horario_marcado;
		this.dia_marcado = dia_marcado;
		this.observacao = observacao;
		this.cliente = cliente;
		this.itemPedido = itemPedido;
		this.status = status;
	}
	
	
	public PedidoDTO(Pedido pedido) {
		List<ItemPedidoDTO> items = new ArrayList<>();
		
		this.id = pedido.getId();
		this.valor_pedido = pedido.getValor_pedido();
		this.horario_marcado = pedido.getHorario_marcado();
		this.dia_marcado = pedido.getDia_marcado();
		this.observacao = pedido.getObservacao();
		this.cliente = pedido.getCliente();
		this.status = pedido.getStatus();
		
		for(ItemPedido item : pedido.getItemPedido()) {
			items.add(new ItemPedidoDTO(item));
		}
		
		this.itemPedido = items;
		
		
	}
	
	
	
	
	
	
	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public List<ItemPedidoDTO> getItemPedido() {
		return itemPedido;
	}
	public void setItemPedido(List<ItemPedidoDTO> itemPedido) {
		this.itemPedido = itemPedido;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cliente, dia_marcado, horario_marcado, id, itemPedido, observacao, valor_pedido);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoDTO other = (PedidoDTO) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(dia_marcado, other.dia_marcado)
				&& Objects.equals(horario_marcado, other.horario_marcado) && id == other.id
				&& Objects.equals(itemPedido, other.itemPedido) && Objects.equals(observacao, other.observacao)
				&& Double.doubleToLongBits(valor_pedido) == Double.doubleToLongBits(other.valor_pedido);
	}
	
	
	
	
	
	
}
