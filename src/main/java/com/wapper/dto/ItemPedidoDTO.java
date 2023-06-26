package com.wapper.dto;

import com.wapper.model.ItemPedido;
import com.wapper.model.Profissional;
import com.wapper.model.Servico;

public class ItemPedidoDTO {
	
	private int id_item_pedido;
	
	private double valor_item;
	
	private ServicoDTO servico;
	
	private ProfissionalDTO profissional;
	
	
	public ItemPedidoDTO() {

	}

	public ItemPedidoDTO(int id_pedido, double valor_item, ServicoDTO servico, ProfissionalDTO profissional) {
		this.id_item_pedido = id_pedido;
		this.valor_item = valor_item;
		this.servico = servico;
		this.profissional = profissional;
	}
	
	public ItemPedidoDTO(ItemPedido itemPedido) {
		this.id_item_pedido = itemPedido.getId_item_pedido();
		this.valor_item = itemPedido.getValor_item();
		this.servico =  new ServicoDTO(itemPedido.getServico());
		this.profissional = new ProfissionalDTO(itemPedido.getProfissional());
	}
	


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

	public ServicoDTO getServico() {
		return servico;
	}

	public void setServico(ServicoDTO servico) {
		this.servico = servico;
	}

	public ProfissionalDTO getProfissional() {
		return profissional;
	}

	public void setProfissional(ProfissionalDTO profissional) {
		this.profissional = profissional;
	}
	
	

}
