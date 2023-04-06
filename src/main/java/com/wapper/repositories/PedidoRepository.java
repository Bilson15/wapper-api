package com.wapper.repositories;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wapper.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	@Query(value = "SELECT * FROM pedido  WHERE pedido.id_cliente = ?1 ORDER BY pedido.id_pedido DESC", nativeQuery = true)
	Page<Pedido> findByClienteByIdCliente(Pageable pageable, long idCliente);

}
