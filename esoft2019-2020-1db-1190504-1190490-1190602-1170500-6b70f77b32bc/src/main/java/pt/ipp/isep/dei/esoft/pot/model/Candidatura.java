/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author diogo
 */
public class Candidatura {

    private final LocalDate m_odataCandidatura;
    private double m_ovalorPretendido;
    private int m_onumDias;
    private String m_strtxtApresentacao;
    private String m_strtxtMotivacao;
    private Freelancer freelancer;

    public Freelancer getFreelancer() {
        return freelancer;
    }

    public Candidatura(Date odataCandidatura, double ovalorPretendido, int onumDias,String strtxtApresentacao,  String strtxtMotivacao) {
        if ((strtxtMotivacao == null) || (onumDias == 0) || (strtxtApresentacao == null) || (odataCandidatura == null) || (ovalorPretendido == 0)) {
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        }
        this.m_odataCandidatura = LocalDate.now();
        this.m_ovalorPretendido = ovalorPretendido;
        this.m_onumDias = onumDias;
        this.m_strtxtApresentacao = strtxtApresentacao;
        this.m_strtxtMotivacao = strtxtMotivacao;
    }
    



    @Override
    public boolean equals(Object o) {
        // Inspirado em https://www.sitepoint.com/implement-javas-equals-method-correctly/

        // self check
        if (this == o) {
            return true;
        }
        // null check
        if (o == null) {
            return false;
        }
        // type check and cast
        if (getClass() != o.getClass()) {
            return false;
        }
        // field comparison
        Candidatura obj = (Candidatura) o;
        return (Objects.equals(obj, o));
    }

    @Override
    public String toString() {
        return String.format("Candidatura: %s", this.m_odataCandidatura, this.m_ovalorPretendido, this.m_onumDias, this.m_strtxtApresentacao, this.m_strtxtMotivacao);
    }

    public LocalDate getM_odataCandidatura() {
        return m_odataCandidatura;
    }

    public double getM_ovalorPretendido() {
        return m_ovalorPretendido;
    }

    public int getM_onumDias() {
        return m_onumDias;
    }

    public String getM_strtxtApresentacao() {
        return m_strtxtApresentacao;
    }

    public String getM_strtxtMotivacao() {
        return m_strtxtMotivacao;
    }

}
