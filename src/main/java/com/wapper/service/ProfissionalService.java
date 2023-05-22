package com.wapper.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.wapper.dto.EnderecoDTO;
import com.wapper.dto.ProfissionalDTO;
import com.wapper.exceptions.GenericException;
import com.wapper.model.Endereco;
import com.wapper.model.Profissional;
import com.wapper.repositories.ProfissionalRepository;

@Service
public class ProfissionalService {
	
	@Autowired
	ProfissionalRepository repository;
	
	
	
	
	public List<ProfissionalDTO> findAll() {
		List<Profissional> profissionais = repository.findAll();
		
		
		List<ProfissionalDTO> newList = new ArrayList<>(); 
		
		for(Profissional profissional : profissionais) {
			newList.add(new ProfissionalDTO(profissional));
		}
		
      return newList;
	
	}
	

	
	
	
	public Profissional create(Profissional profissional) throws Exception {
		Profissional result = repository.save(profissional);
		
		if(result != null) {
			return result;
		}else {
			 throw new GenericException("Erro ao cadastrar");
		}
	}
}
