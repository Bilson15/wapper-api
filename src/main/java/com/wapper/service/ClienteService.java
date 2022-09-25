package com.wapper.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wapper.dto.ClienteDTO;
import com.wapper.dto.LoginDTO;
import com.wapper.exceptions.GenericException;
import com.wapper.model.Cliente;
import com.wapper.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository repository;
	
	
	public Page<ClienteDTO> findAll(Pageable page) {
		Page<Cliente> clientePage = repository.findAll(page);
		
		List<Cliente> result = clientePage.getContent();
		List<ClienteDTO> dto = new ArrayList<>();
		for(Cliente cliente : result) {
			dto.add(new ClienteDTO(cliente));
		}	
		
		
	        PageRequest pageRequest = PageRequest.of(
	        		page.getPageNumber(),
	                page.getPageSize(),
	                Sort.Direction.ASC,
	                "name");
	        return new PageImpl<>(
	        		dto, 
	                pageRequest, page.getPageSize());
		
		
	
	}
	
	public ClienteDTO findById(Long id) {
		Cliente cliente = repository.findById(id).orElseThrow(() ->  new GenericException("Cliente " + id + " não encontrado"));
		return new ClienteDTO(repository.save(cliente));
	}
	
	
	public ClienteDTO create(Cliente cliente) throws Exception {
		Cliente result = repository.findByEmail(cliente.getEmail());
		
		if(result == null) {
			throw new GenericException("E-mail já cadastrado");
		}else {
			return  new ClienteDTO(repository.save(cliente));
		}
	}
	
	
	public ResponseEntity<ClienteDTO> login(LoginDTO loginDTO) {
        Cliente cliente = repository.findByEmail(loginDTO.getEmail());
        if(cliente == null) {
            throw new GenericException("E-mail ou senha incorreto");
        }
        if(!cliente.getSenha().equals(loginDTO.getSenha())){
        	 throw new GenericException("E-mail ou senha incorreto");
        }
        
        
        return new ResponseEntity<ClienteDTO>(new ClienteDTO(repository.save(cliente)), HttpStatus.OK);
	}
	
	
	
}
