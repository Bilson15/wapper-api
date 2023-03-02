package com.wapper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
