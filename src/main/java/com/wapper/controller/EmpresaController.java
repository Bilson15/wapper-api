package com.wapper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wapper.dto.EmpresaDTO;
import com.wapper.dto.EmpresaHomeDTO;
import com.wapper.model.Empresa;
import com.wapper.service.EmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
	
	@Autowired
	private EmpresaService service;

	@GetMapping(value = "/{id}", produces = "application/json;charset=UTF-8")
	public EmpresaDTO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	 
	
	@GetMapping(produces = "application/json;charset=UTF-8")
	public Page<EmpresaHomeDTO> findAll(@RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "20") int size) throws Exception {
		return service.findAll(PageRequest.of(page, size));
	}
	
	
	@PostMapping
	public Empresa create(@RequestBody Empresa empresa) {
		return service.create(empresa);
	}

	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
	}
}
