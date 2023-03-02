package com.wapper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wapper.dto.PedidoDTO;
import com.wapper.model.Pedido;
import com.wapper.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	PedidoRepository repository;
	
	public ResponseEntity<PedidoDTO> create(Pedido pedido) throws Exception {

		return  new ResponseEntity<PedidoDTO>(new PedidoDTO(repository.save(pedido)), HttpStatus.OK);
	}

}
