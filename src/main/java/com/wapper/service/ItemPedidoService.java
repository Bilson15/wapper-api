package com.wapper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wapper.model.ItemPedido;

import com.wapper.repositories.ItemPedidoRepository;


@Service
public class ItemPedidoService {
	
	@Autowired
	ItemPedidoRepository repository;
	
	
	public List<ItemPedido> findAll() {
		return repository.findAll();	
	}
	
	public ItemPedido findById(Long id) {
		return repository.findById(id).orElseThrow(null);
	}
	
	
	public ItemPedido create(ItemPedido itemPedido) {
		
		return repository.save(itemPedido);
	}
	
	
	public void delete(Long id) {
		ItemPedido itemPedido = repository.findById(id).orElseThrow(null);
		repository.delete(itemPedido);
	}

}
