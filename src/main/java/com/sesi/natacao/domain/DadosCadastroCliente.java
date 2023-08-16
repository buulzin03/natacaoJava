package com.sesi.natacao.domain;

import java.time.LocalDate;

public record DadosCadastroCliente(String nome, LocalDate dataInscricao, LocalDate dataNascimento, Nivel nivel, Turno turno, String observacao ) {
    
}
