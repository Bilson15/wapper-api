package com.wapper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wapper.model.Endereco;
import com.wapper.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	@Autowired
	EnderecoRepository repository;
	
	
	public List<Endereco> findAll() {
		return repository.findAll();	
	}
	
	public Endereco findById(Long id) {
		return repository.findById(id).orElseThrow(null);
	}
	
	
	public Endereco create(Endereco endereco) {
		
		return repository.save(endereco);
	}
	
	
	public void delete(Long id) {
		Endereco enderecoRepo = repository.findById(id).orElseThrow(null);
		repository.delete(enderecoRepo);
	}
}
