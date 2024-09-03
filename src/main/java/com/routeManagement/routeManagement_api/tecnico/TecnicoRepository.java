package com.routeManagement.routeManagement_api.tecnico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
    Page<Tecnico> findAllByAtivoTrue(Pageable paginacao);
}
