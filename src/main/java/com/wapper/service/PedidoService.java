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
import com.wapper.model.Cliente;
import com.wapper.model.Pedido;
import com.wapper.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	PedidoRepository repository;
	
	public ResponseEntity<PedidoDTO> create(Pedido pedido) throws Exception {

		return  new ResponseEntity<PedidoDTO>(new PedidoDTO(repository.save(pedido)), HttpStatus.OK);
	}
	
	public Page<PedidoDTO> findByClienteByIdCliente(Pageable page, long idCliente) throws Exception {
		
		Page<Pedido> pedidoPage =  repository.findByClienteByIdCliente(page, idCliente);
		
		List<Pedido> result =  pedidoPage.getContent();
		
		List<PedidoDTO> dto = new ArrayList<>();
		for(Pedido pedido : result) {
			dto.add(new PedidoDTO(pedido));
		}	
		
		
        PageRequest pageRequest = PageRequest.of(
        		page.getPageNumber(),
                page.getPageSize(),
                Sort.Direction.ASC,
                "name");
        return new PageImpl<>(
        		dto, 
                pageRequest, page.getPageSize());
		
	}
	
	
	public Page<PedidoDTO> findByEmpresaByIdEmpresa(Pageable page, long idEmpresa) throws Exception {
		
		Page<Pedido> pedidoPage =  repository.findByEmpresaByIdEmpresa(page, idEmpresa);
		
		List<Pedido> result =  pedidoPage.getContent();
		
		List<PedidoDTO> dto = new ArrayList<>();
		for(Pedido pedido : result) {
			dto.add(new PedidoDTO(pedido));
		}	
		
		
        PageRequest pageRequest = PageRequest.of(
        		page.getPageNumber(),
                page.getPageSize(),
                Sort.Direction.ASC,
                "name");
        return new PageImpl<>(
        		dto, 
                pageRequest, page.getPageSize());
		
	}
	
	
	public PedidoDTO cancelarPedido(long idEmpresa) throws Exception {
		
		Pedido pedido =  repository.findById(idEmpresa).get();
		pedido.setStatus(2);

        return new PedidoDTO(repository.save(pedido));
	}
	
	
	public PedidoDTO confirmarPedido(long idEmpresa) throws Exception {
		
		Pedido pedido =  repository.findById(idEmpresa).get();
		pedido.setStatus(1);

        return new PedidoDTO(repository.save(pedido));
	}

}
