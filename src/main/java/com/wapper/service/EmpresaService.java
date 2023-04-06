package com.wapper.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.wapper.dto.EmpresaDTO;
import com.wapper.dto.EmpresaHomeDTO;
import com.wapper.exceptions.GenericException;
import com.wapper.model.Empresa;
import com.wapper.repositories.EmpresaRepository;

@Service
public class EmpresaService {
	
	
	@Autowired
	EmpresaRepository repository;
	
	public Page<EmpresaHomeDTO> findAll(Pageable page) throws Exception {
		Page<Empresa> result = repository.findAll(page);
		
		List<Empresa> empresas = result.getContent();
		List<EmpresaHomeDTO> dto = new ArrayList<>();
		for(Empresa empresa : empresas) {
			dto.add(new EmpresaHomeDTO(empresa));
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
	
	
	public Page<EmpresaHomeDTO> search(Pageable page, String term) throws Exception {
		Page<Empresa> result = repository.findByEmpresaTerm(page, term.toLowerCase());
		
		List<Empresa> empresas = result.getContent();
		List<EmpresaHomeDTO> dto = new ArrayList<>();
		for(Empresa empresa : empresas) {
			dto.add(new EmpresaHomeDTO(empresa));
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
	
	public EmpresaDTO findById(Long id) {
		
		Empresa empresa = repository.findById(id).orElseThrow(() ->  new GenericException("Empresa " + id + " não encontrado"));
		return new EmpresaDTO(empresa);
	}
	
	
	public Empresa create(Empresa empresa) {
		return repository.save(empresa);
	}
	

	
	public void delete(Long id) {
		Empresa empresaRepo = repository.findById(id).orElseThrow(null);
		repository.delete(empresaRepo);
	}

}
