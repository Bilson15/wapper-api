package com.wapper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wapper.dto.PedidoDTO;
import com.wapper.model.Pedido;
import com.wapper.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService service;
	
	@PostMapping(produces = "application/json;charset=UTF-8", consumes={"application/json"})
	public ResponseEntity<PedidoDTO> create(@RequestBody Pedido pedido) throws Exception {
		return service.create(pedido);
	}
	
	
	@GetMapping(value = "/cliente/{idCliente}", produces = "application/json;charset=UTF-8")
	public List<PedidoDTO> findAll(
			@PathVariable(value = "idCliente") long idCliente) throws Exception {
		return service.findByClienteByIdCliente(idCliente);
	}
	
	

}
