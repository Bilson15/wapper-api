package com.wapper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wapper.model.TelefoneCliente;
import com.wapper.repositories.TelefoneClienteRepository;

@Service
public class TelefoneClienteService {

	@Autowired
	TelefoneClienteRepository repository;
	
	
	public List<TelefoneCliente> findAll() {
		return repository.findAll();	
	}
	
	public TelefoneCliente findById(Long id) {
		return repository.findById(id).orElseThrow(null);
	}
	
	
	public TelefoneCliente create(TelefoneCliente telefoneCliente) {
		
		return repository.save(telefoneCliente);
	}
	
	
	public void delete(Long id) {
		TelefoneCliente telefoneRepo = repository.findById(id).orElseThrow(null);
		repository.delete(telefoneRepo);
	}
}
