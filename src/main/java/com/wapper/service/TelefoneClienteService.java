package com.wapper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wapper.model.TelefoneCliente;
import com.wapper.repositories.TelefoneClienteRepository;

@Service
public class TelefoneClienteService {

	@Autowired
	TelefoneClienteRepository repository;
	
	
	public TelefoneCliente create(TelefoneCliente telefoneCliente) {
		return repository.save(telefoneCliente);
	}
}
