package com.wapper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wapper.model.Cliente;
import com.wapper.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository repository;
	
	public List<Cliente> findAll() {
		return repository.findAll();	
	}
	
	public Cliente findById(Long id) {
		return repository.findById(id).orElseThrow(null);
	}
	
	
	public Cliente create(Cliente cliente) {
		return repository.save(cliente);
	}
	
	public Cliente update(Cliente cliente) {
		
		Cliente clienteRepo = repository.findById(cliente.getId()).orElseThrow(null);
		
		clienteRepo.setCpf(cliente.getCpf());
		clienteRepo.setData_nascimento(cliente.getData_nascimento());
		clienteRepo.setEmail(cliente.getEmail());
		clienteRepo.setNome(cliente.getNome());
		clienteRepo.setSenha(cliente.getSenha());
		clienteRepo.setSexo(cliente.getSexo());
		clienteRepo.setStatus_cliente(cliente.getStatus_cliente());
		
		
		return repository.save(clienteRepo);
	}
	
	
	public void delete(Long id) {
		Cliente clienteRepo = repository.findById(id).orElseThrow(null);
		repository.delete(clienteRepo);
	}
}
