package com.wapper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wapper.model.Empresa;
import com.wapper.service.EmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
	
	@Autowired
	private EmpresaService service;

	@GetMapping(value = "/{id}")
	public Empresa findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	 
	
	@GetMapping
	public List<Empresa> findAll() {
		return service.findAll();
	}
	
	
	@PostMapping
	public Empresa create(@RequestBody Empresa empresa) {
		return service.create(empresa);
	}
	
	@PutMapping
	public Empresa update(@RequestBody Empresa empresa) {
		return service.update(empresa);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
	}
}
