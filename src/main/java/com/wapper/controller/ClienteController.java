package com.wapper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wapper.dto.ClienteDTO;
import com.wapper.dto.LoginDTO;
import com.wapper.model.Cliente;
import com.wapper.service.ClienteService;

@RestController
@RequestMapping("/wapperApi/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;

	@GetMapping(value = "/{id}", produces = "application/json;charset=UTF-8")
	public ClienteDTO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	 
	
	@GetMapping
	public Page<ClienteDTO> findAll(@RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "10") int size) {
		return service.findAll(PageRequest.of(page, size));
	}
	
	
	@PostMapping
	public ClienteDTO create(@RequestBody Cliente cliente) throws Exception {
		return service.create(cliente);
	}
	
	
	@PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
	public ResponseEntity<ClienteDTO> login(@RequestBody LoginDTO loginDTO) throws Exception {
		return service.login(loginDTO);
	}
	
	
}
