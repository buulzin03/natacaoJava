package com.sesi.natacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sesi.natacao.domain.infantil.DadosCadastroInfantil;
import com.sesi.natacao.domain.infantil.DadosListaInfantil;
import com.sesi.natacao.domain.infantil.Infantil;
import com.sesi.natacao.repository.InfantilRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/infantil")
public class InfantilController {
    
    @Autowired
    private InfantilRepository repository;


    @GetMapping
    public ResponseEntity<Page<DadosListaInfantil>> listar(@PageableDefault(sort = "dataInscricao") Pageable paginacao) {
        Page<DadosListaInfantil> clientes = repository.findAllByAtivoTrue(paginacao).map(DadosListaInfantil::new);

        return ResponseEntity.status(HttpStatus.OK).body(clientes);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Infantil> cadastrar(@RequestBody DadosCadastroInfantil dados ) {
        Infantil cliente = new Infantil(dados);

        repository.save(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity remover(@PathVariable int id) {
        Infantil cliente = repository.findById(id).get();

        cliente.excluir();

        return ResponseEntity.noContent().build();
    }
}
