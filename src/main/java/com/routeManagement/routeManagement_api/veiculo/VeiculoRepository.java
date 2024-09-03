package com.routeManagement.routeManagement_api.veiculo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
        Page<Veiculo> findAllByAtivoTrue(Pageable paginacao);
}
