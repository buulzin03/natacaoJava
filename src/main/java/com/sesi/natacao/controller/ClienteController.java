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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sesi.natacao.domain.Cliente;
import com.sesi.natacao.domain.DadosAtualizaCliente;
import com.sesi.natacao.domain.DadosCadastroCliente;
import com.sesi.natacao.repository.ClienteRepository;

import jakarta.transaction.Transactional;


@RestController
@RequestMapping("clientes")
public class ClienteController {
    


    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public ResponseEntity<Page<Cliente>> listar(@PageableDefault(sort = "dataInscricao") Pageable paginacao) {
        Page<Cliente> clientes = repository.findAllByAtivoTrue(paginacao);

        return ResponseEntity.ok().body(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity pegarUnico(@PathVariable int id) {
        Cliente cliente = repository.findById(id).get();

        return ResponseEntity.ok().body(cliente);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody DadosCadastroCliente dados) {
        Cliente cliente = new Cliente(dados);
        
        repository.save(cliente);

        return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable int id ){
        Cliente cliente = repository.findById(id).get();
        
        cliente.excluir();

        return ResponseEntity.ok().body("Desativado");
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable int id, @RequestBody DadosAtualizaCliente dados) {
        Cliente c1 = repository.findById(id).get();
        c1.atualizar(dados);

        return ResponseEntity.ok().body(c1);
    }
}
