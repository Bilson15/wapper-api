package com.wapper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wapper.model.Empresa;
import com.wapper.repositories.EmpresaRepository;

@Service
public class EmpresaService {
	
	
	@Autowired
	EmpresaRepository repository;
	
	
	public List<Empresa> findAll() {
		return repository.findAll();	
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
