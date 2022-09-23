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

import com.wapper.dto.ClienteDTO;
import com.wapper.dto.EmpresaDTO;
import com.wapper.model.Cliente;
import com.wapper.model.Empresa;
import com.wapper.repositories.EmpresaRepository;

@Service
public class EmpresaService {
	
	
	@Autowired
	EmpresaRepository repository;
	
	public Page<EmpresaDTO> findAll(Pageable page) throws Exception {
		Page<Empresa> result = repository.findAll(page);
		
		List<Empresa> empresas = result.getContent();
		List<EmpresaDTO> dto = new ArrayList<>();
		for(Empresa empresa : empresas) {
			dto.add(new EmpresaDTO(empresa));
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
	
	public Empresa findById(Long id) {
		return repository.findById(id).orElseThrow(null);
	}
	
	
	public Empresa create(Empresa empresa) {
		return repository.save(empresa);
	}
	
	public Empresa update(Empresa empresa) {
		
		Empresa empresaRepo = repository.findById(empresa.getId()).orElseThrow(null);
		
		empresaRepo.setCnpj(empresa.getCnpj());
		empresaRepo.setDataFundacao(empresa.getDataFundacao());
		empresaRepo.setEmail(empresa.getEmail());
		empresaRepo.setRamoAtividade(empresa.getRamoAtividade());
		empresaRepo.setRazaoSocial(empresa.getRazaoSocial());
		empresaRepo.setSenha(empresa.getSenha());
		empresaRepo.setStatusEmpresa(empresa.getStatusEmpresa());
		empresaRepo.setTelefoneCliente(empresa.getTelefoneCliente());
		empresaRepo.setEndereco(empresa.getEndereco());
		
		
		return repository.save(empresa);
	}
	
	
	public void delete(Long id) {
		Empresa empresaRepo = repository.findById(id).orElseThrow(null);
		repository.delete(empresaRepo);
	}

}
