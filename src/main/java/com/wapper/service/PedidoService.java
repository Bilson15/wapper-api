package com.wapper.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	
	public List<PedidoDTO> findByClienteByIdCliente(long idCliente) throws Exception {
		List<Pedido> result = repository.findByClienteByIdCliente(idCliente);
		
		List<PedidoDTO> dto = new ArrayList<>();
		for(Pedido pedido : result) {
			dto.add(new PedidoDTO(pedido));
		}	
		
		
		return dto;

      
		
	}

}
