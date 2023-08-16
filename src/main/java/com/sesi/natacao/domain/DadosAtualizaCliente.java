package com.sesi.natacao.domain;

import java.time.LocalDate;

public record DadosAtualizaCliente( String nome, LocalDate dataInscricao, LocalDate dataNascimento, Nivel nivel, Turno turno, String observacao) {
    
}
