/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.time.LocalDateTime;

/**
 *
 * @author Mini Mi
 */
public abstract class Seriacao {

    private final LocalDateTime dataRealizacao;

    public Seriacao() {
        this.dataRealizacao = LocalDateTime.now();
    }

    public abstract Candidatura getCandidaturaOfPosicao(int i);
}
