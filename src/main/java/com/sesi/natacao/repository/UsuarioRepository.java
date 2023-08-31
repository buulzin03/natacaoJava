package com.sesi.natacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.sesi.natacao.domain.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    UserDetails findByLogin(String login);
    
}
