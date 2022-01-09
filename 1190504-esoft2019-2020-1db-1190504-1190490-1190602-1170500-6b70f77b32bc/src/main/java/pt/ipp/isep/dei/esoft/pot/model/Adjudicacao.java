/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.time.LocalDateTime;
import java.time.Period;

/**
 *
 * @author Hugo
 */
public class Adjudicacao {
    
    private String numSequencial;
    private Freelancer free;
    private Organizacao org;
    private double valorPretendido;
    private Period perRealizacao;
    private LocalDateTime dataRealizacao;
    private String descricao;
    private String anunId;

    public Adjudicacao(Freelancer free, Organizacao org, double valorPretendido, Period perRealizacao, String descricao, String anunId, String numSequencial) {
        this.numSequencial = numSequencial;
        this.free = free;
        this.org = org;
        this.valorPretendido = valorPretendido;
        this.perRealizacao = perRealizacao;
        this.dataRealizacao = LocalDateTime.now();
        this.descricao = descricao;
        this.anunId = anunId;
    }

    public Freelancer getFree() {
        return free;
    }

    public void setFree(Freelancer free) {
        this.free = free;
    }

    public Organizacao getOrg() {
        return org;
    }

    public void setOrg(Organizacao org) {
        this.org = org;
    }

    public double getValorPretendido() {
        return valorPretendido;
    }

    public void setValorPretendido(double valorPretendido) {
        this.valorPretendido = valorPretendido;
    }

    public Period getPerRealizacao() {
        return perRealizacao;
    }

    public void setPerRealizacao(Period perRealizacao) {
        this.perRealizacao = perRealizacao;
    }

    public String getNumSequencial() {
        return numSequencial;
    }

    public void setNumSequencial(String numSequencial) {
        this.numSequencial = numSequencial;
    }

    public LocalDateTime getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(LocalDateTime dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAnunId() {
        return anunId;
    }

    public void setAnunId(String anunId) {
        this.anunId = anunId;
    }
    
    
    
    
}
