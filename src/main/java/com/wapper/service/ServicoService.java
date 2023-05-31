package com.wapper.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wapper.dto.ServicoDTO;
import com.wapper.exceptions.GenericException;
import com.wapper.model.Empresa;
import com.wapper.model.Profissional;
import com.wapper.model.Servico;
import com.wapper.repositories.EmpresaRepository;
import com.wapper.repositories.ProfissionalRepository;
import com.wapper.repositories.ServicoRepository;

@Service
public class ServicoService {
	
	@Autowired
	ServicoRepository repository;
	
	@Autowired
	EmpresaRepository empresaRepository;
	
	
	@Autowired
	ProfissionalRepository profissionalRepository;
	
	
	
	public List<ServicoDTO> findAllById(Long idEmpresa) {
		List<Servico> servicos = repository.findAllById(idEmpresa);	
		List<ServicoDTO> servicosDTO = new ArrayList<>();
		
		for(Servico servico : servicos) {
			servicosDTO.add(new ServicoDTO(servico));
		}
		
		return  servicosDTO;	
	}
	
	
	public ServicoDTO create(Servico servico, Long idEmpresa) {

		
		Optional<Empresa> empresa = empresaRepository.findById(idEmpresa);
		
		
		if(empresa.get() == null) {
			throw new GenericException("Obrigatório a passagem de empresa");
		}
		
		servico.setEmpresa(empresa.get());
		
		
		
		Servico servicoSave = repository.save(servico);

		return  new ServicoDTO(servicoSave);	
	}

}
