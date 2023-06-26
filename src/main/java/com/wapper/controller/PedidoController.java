package com.wapper.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wapper.dto.PedidoDTO;
import com.wapper.model.Pedido;
import com.wapper.service.PedidoService;

@RestController
@RequestMapping("/wapperApi/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService service;
	
	@PostMapping(produces = "application/json;charset=UTF-8", consumes={"application/json"})
	public ResponseEntity<PedidoDTO> create(@RequestBody Pedido pedido) throws Exception {
		return service.create(pedido);
	}
	
	
	@GetMapping(value = "/cliente/{idCliente}", produces = "application/json;charset=UTF-8")
	public Page<PedidoDTO> findAll(
			@PathVariable(value = "idCliente") long idCliente,
			@RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "3") int size
			) throws Exception {
		return service.findByClienteByIdCliente(PageRequest.of(page, size), idCliente);
	}
	
	
	
	
	@GetMapping(value = "/empresa/{idEmpresa}", produces = "application/json;charset=UTF-8")
	public Page<PedidoDTO> findOrdersEmpresa(
			@PathVariable(value = "idEmpresa") long idEmpresa,
			@RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "5") int size
			) throws Exception {
		return service.findByEmpresaByIdEmpresa(PageRequest.of(page, size), idEmpresa);
	}
	
	
	
	@PutMapping(value = "/{idPedido}/cancelar", produces = "application/json;charset=UTF-8")
	public PedidoDTO cancelarPedido(
			@PathVariable(value = "idPedido") long idPedido
			) throws Exception {
		return service.cancelarPedido(idPedido);
	}
	
	
	
	@PutMapping(value = "/{idPedido}/aprovar", produces = "application/json;charset=UTF-8")
	public PedidoDTO aprovarPedido(
			@PathVariable(value = "idPedido") long idPedido
			) throws Exception {
		return service.confirmarPedido(idPedido);
	}
	
	

}
