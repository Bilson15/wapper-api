package com.wapper.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wapper.dto.ProfissionalDTO;
import com.wapper.exceptions.GenericException;
import com.wapper.model.Empresa;
import com.wapper.model.Profissional;
import com.wapper.repositories.EmpresaRepository;
import com.wapper.repositories.ProfissionalRepository;

@Service
public class ProfissionalService {
	
	@Autowired
	ProfissionalRepository repository;
	
	@Autowired
	EmpresaRepository empresaRepository;
	
	
	
	
	public List<ProfissionalDTO> findAllById(Long id) {
		List<Profissional> profissionais = repository.findAllById(id);
		
		
		List<ProfissionalDTO> newList = new ArrayList<>(); 
		
		for(Profissional profissional : profissionais) {
			newList.add(new ProfissionalDTO(profissional));
		}
		
      return newList;
	
	}
	

	
	
	
	public ProfissionalDTO create(Long idEmpresa ,Profissional profissional) throws Exception {
		Optional<Empresa> empresa = empresaRepository.findById(idEmpresa);
		
		
		if(empresa.get() == null) {
			throw new GenericException("Obrigatório a passagem de empresa");
		}
		
		profissional.setEmpresa(empresa.get());
		
		
		Profissional result = repository.save(profissional);
		
		if(result != null) {
			return new ProfissionalDTO(result);
		}else {
			 throw new GenericException("Erro ao cadastrar");
		}
	}
}
