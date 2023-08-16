package com.sesi.natacao.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sesi.natacao.domain.infantil.Infantil;

public interface InfantilRepository extends JpaRepository<Infantil, Integer>{

    Page<Infantil> findAllByAtivoTrue(Pageable paginacao);
    
}
