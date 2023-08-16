package com.sesi.natacao.domain.infantil;

import java.time.LocalDate;

import com.sesi.natacao.domain.Nivel;
import com.sesi.natacao.domain.Turno;

public record DadosAtualizaInfantil(String nome, LocalDate dataInscricao, LocalDate dataNascimento, Nivel nivel, Turno turno, String observacao, String responsavel) {
    
}
