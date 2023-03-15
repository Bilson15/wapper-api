package com.wapper.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wapper.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	@Query(value = "SELECT * FROM pedido  WHERE pedido.id_cliente = ?1", nativeQuery = true)
	List<Pedido> findByClienteByIdCliente(long idCliente);

}
