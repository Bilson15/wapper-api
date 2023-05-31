package com.wapper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wapper.dto.EmpresaDTO;
import com.wapper.dto.EmpresaHomeDTO;
import com.wapper.dto.LoginDTO;
import com.wapper.dto.ProfissionalDTO;
import com.wapper.dto.ServicoDTO;
import com.wapper.model.Empresa;
import com.wapper.model.Profissional;
import com.wapper.model.Servico;
import com.wapper.service.EmpresaService;
import com.wapper.service.ProfissionalService;
import com.wapper.service.ServicoService;

@RestController
@RequestMapping("/wapperApi/empresa")
public class EmpresaController {
	
	@Autowired
	private EmpresaService service;
	
	@Autowired
	private ProfissionalService profissionalService;
	
	@Autowired
	private ServicoService ServicoService;

	@GetMapping(value = "/{id}", produces = "application/json;charset=UTF-8")
	public EmpresaDTO findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}
	 
	
	@GetMapping(produces = "application/json;charset=UTF-8")
	public Page<EmpresaHomeDTO> findAll(@RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "20") int size) throws Exception {
		return service.findAll(PageRequest.of(page, size));
	}
	
	
	@GetMapping(value = "/search", produces = "application/json;charset=UTF-8")
	public Page<EmpresaHomeDTO> findAll(
			@RequestParam String term,
			@RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "20") int size
	        ) throws Exception {
		return service.search(PageRequest.of(page, size), term);
	}
	
	
	@PostMapping
	public Empresa create(@RequestBody Empresa empresa) {
		return service.create(empresa);
	}

	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
	}
	
	@PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
	public ResponseEntity<EmpresaHomeDTO> login(@RequestBody LoginDTO loginDTO) throws Exception {
		return service.login(loginDTO);
	}
	

	
	
	@GetMapping(value = "{idEmpresa}/profissional")
	public List<ProfissionalDTO> findAllProfissional(@PathVariable(value = "idEmpresa") Long id) {
		return profissionalService.findAllById(id);
	}
	
	@PostMapping(value = "{idEmpresa}/profissional")
	public ProfissionalDTO create(@PathVariable(value = "idEmpresa") Long id, @RequestBody Profissional profissional) throws Exception {
		return profissionalService.create(id ,profissional);
	}
	
	
	@GetMapping(value = "{idServico}/servico")
	public List<ServicoDTO> findAllService(@PathVariable(value = "idServico") Long id) {
		return ServicoService.findAllById(id);
	}
	
	@PostMapping(value = "{idEmpresa}/servico")
	public ServicoDTO create(@PathVariable(value = "idEmpresa") Long id, @RequestBody Servico servico) throws Exception {
		return ServicoService.create(servico, id);
	}
	
}
