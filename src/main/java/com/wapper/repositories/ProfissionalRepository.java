package com.wapper.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wapper.model.Profissional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long>{

	@Query(value = "SELECT * FROM profissional  WHERE profissional.id_empresa = :id", nativeQuery = true)
	List<Profissional> findAllById(Long id);

}
