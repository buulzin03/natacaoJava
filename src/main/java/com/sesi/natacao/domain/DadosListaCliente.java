package com.sesi.natacao.domain;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class DadosListaCliente {
    
    Integer id;
    String nome;
    String dataInscricao;
    String dataNascimento;
    Nivel nivel;
    Turno turno;
    String observacao;

    public DadosListaCliente(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.dataInscricao = cliente.getDataInscricao().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        this.dataNascimento = cliente.getDataNascimento().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        this.nivel = cliente.getNivel();
        this.turno = cliente.getTurno();
        this.observacao = cliente.getObservacao();
    }

    
}
