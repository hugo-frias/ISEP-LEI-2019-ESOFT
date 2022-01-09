/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Mini Mi
 */
public class SeriacaoManual extends Seriacao {

    // falta o tipo de regimento
    private List<Colaborador> colabParticipantes;
    private List<Classificacao> lstClassificacao;
    private String txtConclusão;

    public void setTxtConclusão(String txtConclusão) {
        this.txtConclusão = txtConclusão;
    }

    public SeriacaoManual() {
        super();
        colabParticipantes = new ArrayList<>();
        lstClassificacao = new ArrayList();
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
        SeriacaoManual obj = (SeriacaoManual) o;
        return (Objects.equals(obj, o));
    }


    

    public void addColab(Colaborador colab) {
        colabParticipantes.add(colab);
    }

    public List<Colaborador> getColabParticipantes() {
        return colabParticipantes;
    }

    public void setColabParticipantes(List<Colaborador> colabParticipantes) {
        this.colabParticipantes = colabParticipantes;
    }

    @Override
    public Candidatura getCandidaturaOfPosicao(int i) {
        for (Classificacao clsf : this.getLstClassificacao()) {
            if (clsf.getPosicao() == 1) {
                return clsf.getCand();
            }
        }
        return null;
    }

    public List<Classificacao> getLstClassificacao() {
        return lstClassificacao;
    }

    public void setLstClassificacao(List<Classificacao> lstClassificacao) {
        this.lstClassificacao = lstClassificacao;
    }

}
