package com.wapper.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wapper.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	List<Cliente> findByEmail(String email);
}
