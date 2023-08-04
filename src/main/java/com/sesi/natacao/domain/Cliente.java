package com.sesi.natacao.domain;


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

@Table(name = "clientes")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = "id")
public class Cliente {
    
    public Cliente(DadosCadastroCliente dados) {
        this.nome = dados.nome();
        this.dataInscricao = dados.dataInscricao();
        this.dataNascimento = dados.dataNascimento();
        this.nivel = dados.nivel();
        this.turno = dados.turno();
        this.observacao = dados.observacao();
        this.ativo = true;
    }
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    @Column(name = "data_inscricao")
    private String dataInscricao;
    @Column(name = "data_nascimento")
    private String dataNascimento;
    @Enumerated(EnumType.STRING)
    private Nivel nivel;
    @Enumerated(EnumType.STRING)
    private Turno turno;
    private String observacao;
    private boolean ativo;

    public void excluir() {
        this.ativo = false;
    }

    public void ativar() {
        this.ativo = true;
    }

    public void atualizar(DadosAtualizaCliente dados) {
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
    }
}
