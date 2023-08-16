package com.sesi.natacao.domain.infantil;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import com.sesi.natacao.domain.Nivel;
import com.sesi.natacao.domain.Turno;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class DadosListaInfantil {
    
    private Integer id;
    private String nome;
    private String dataInscricao;
    private String dataNascimento;
    private Nivel nivel;
    private Turno turno;
    private String observacao;
    private String responsavel;

    public DadosListaInfantil(Infantil cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.dataInscricao = cliente.getDataInscricao().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        this.dataNascimento = cliente.getDataNascimento().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        this.nivel = cliente.getNivel();
        this.turno = cliente.getTurno();
        this.observacao = cliente.getObservacao();
        this.responsavel = cliente.getResponsavel();
    }

}
