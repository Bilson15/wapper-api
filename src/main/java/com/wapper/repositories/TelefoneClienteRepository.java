package com.wapper.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wapper.model.TelefoneCliente;

@Repository
public interface TelefoneClienteRepository extends JpaRepository<TelefoneCliente, Long>{
	
}
