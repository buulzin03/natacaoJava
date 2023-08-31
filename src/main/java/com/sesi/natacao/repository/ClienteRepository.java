package com.sesi.natacao.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sesi.natacao.domain.adulto.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

    Page<Cliente> findAllByAtivoTrue(Pageable paginacao);
    
}
