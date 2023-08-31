package com.sesi.natacao.domain.adulto;

import java.time.LocalDate;

import com.sesi.natacao.domain.Nivel;
import com.sesi.natacao.domain.Turno;

public record DadosAtualizaCliente( String nome, LocalDate dataInscricao, LocalDate dataNascimento, Nivel nivel, Turno turno, String observacao) {
    
}
