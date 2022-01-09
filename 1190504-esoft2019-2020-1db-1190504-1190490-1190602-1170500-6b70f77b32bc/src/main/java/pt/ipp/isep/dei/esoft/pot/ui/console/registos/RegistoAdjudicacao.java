/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.ui.console.registos;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import pt.ipp.isep.dei.esoft.pot.model.Adjudicacao;
import pt.ipp.isep.dei.esoft.pot.model.Freelancer;
import pt.ipp.isep.dei.esoft.pot.model.Organizacao;

/**
 *
 * @author Hugo
 */
public class RegistoAdjudicacao {
    private List<Adjudicacao> adjudicacoes;
    private static final int ANO_ATUAL = LocalDate.now().getYear();

    public RegistoAdjudicacao() {
        adjudicacoes = new ArrayList();
    }

    public List<Adjudicacao> getAdjudicacoes() {
        return adjudicacoes;
    }

    public void setAdjudicacoes(List<Adjudicacao> adjudicacoes) {
        this.adjudicacoes = adjudicacoes;
    }

  

    public void createAdjudicacao(Organizacao org, Freelancer fl, double valorAcordado, Period perRealizacao, String anunId, String desc) {
        String numSequencial = geraNumSequencial();
        Adjudicacao adj = new Adjudicacao(fl, org, valorAcordado, perRealizacao, desc, anunId, numSequencial);
        adjudicacoes.add(adj);
    }
    
    public String geraNumSequencial(){
        return Integer.toString(this.ANO_ATUAL+this.adjudicacoes.size());
    }
    
}
