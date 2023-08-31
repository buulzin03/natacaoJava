package com.sesi.natacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sesi.natacao.domain.usuario.DadosAutenticacao;
import com.sesi.natacao.domain.usuario.DadosToken;
import com.sesi.natacao.domain.usuario.Usuario;
import com.sesi.natacao.infra.security.TokenService;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody DadosAutenticacao dados ) {
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var auth = authenticationManager.authenticate(token);
        DadosToken dadosToken = new DadosToken(tokenService.gerarToken((Usuario) auth.getPrincipal()));

        return ResponseEntity.ok(dadosToken);
    }
}
