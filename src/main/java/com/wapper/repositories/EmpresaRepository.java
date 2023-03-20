package com.wapper.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wapper.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	@Query(value = "SELECT * FROM empresa  WHERE LOWER(empresa.razao_social) LIKE %:term% OR LOWER(empresa.ramo_atividade) LIKE %:term% ORDER BY empresa.razao_social", nativeQuery = true)
	Page<Empresa> findByEmpresaTerm(Pageable pageable, String term);
}
