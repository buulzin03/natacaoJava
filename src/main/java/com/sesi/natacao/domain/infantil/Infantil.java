package com.sesi.natacao.domain.infantil;

import java.time.LocalDate;

import com.sesi.natacao.domain.Nivel;
import com.sesi.natacao.domain.Turno;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "infantil")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Infantil {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @Column(name= "data_inscricao")
    private LocalDate dataInscricao;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    @Enumerated(EnumType.STRING)
    private Nivel nivel;
    @Enumerated(EnumType.STRING)
    private Turno turno;
    private String observacao;
    private String responsavel;
    private Boolean ativo;


    public Infantil(DadosCadastroInfantil dados) {
        this.nome = dados.nome();
        this.dataInscricao = dados.dataInscricao();
        this.dataNascimento = dados.dataNascimento();
        this.nivel = dados.nivel();
        this.turno = dados.turno();
        this.observacao = dados.observacao();
        this.responsavel = dados.responsavel();
        this.ativo = true;
    }
    

    public void excluir() {
        this.ativo = false;
    }

    public void ativar() {
        this.ativo = true;
    }

    public void atualizar(DadosAtualizaInfantil dados) {
        if(dados.nome()!= null) {
            this.nome = dados.nome();
        }
        if(dados.dataInscricao() != null){
            this.dataInscricao = dados.dataInscricao();
        }
        if(dados.dataNascimento()!= null) {
            this.dataNascimento = dados.dataNascimento();
        }
        if(dados.nivel() != null) {
            this.nivel = dados.nivel();
        }
        if(dados.turno() != null) {
            this.turno = dados.turno();
        }
        if(dados.observacao() != null) {
            this.observacao = dados.observacao();
        }
        if(dados.responsavel() != null) {
            this.responsavel = dados.responsavel();
        }
    }
}
