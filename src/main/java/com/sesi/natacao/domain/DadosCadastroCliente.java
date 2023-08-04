package com.sesi.natacao.domain;


public record DadosCadastroCliente(String nome, String dataInscricao, String dataNascimento, Nivel nivel, Turno turno, String observacao ) {
    
}
