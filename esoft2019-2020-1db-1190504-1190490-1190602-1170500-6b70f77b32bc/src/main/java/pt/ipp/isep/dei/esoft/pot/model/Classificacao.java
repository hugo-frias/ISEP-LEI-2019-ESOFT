/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

/**
 *
 * @author Utilizador
 */
public class Classificacao {
    private int posicao;
    private String txtJustificacao;
    private Candidatura cand;

    public Classificacao(int posicao, String txtJustificacao, Candidatura cand) {
        this.posicao = posicao;
        this.txtJustificacao = txtJustificacao;
        this.cand = cand;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public String getTxtJustificacao() {
        return txtJustificacao;
    }

    public void setTxtJustificacao(String txtJustificacao) {
        this.txtJustificacao = txtJustificacao;
    }

    public Candidatura getCand() {
        return cand;
    }

    public void setCand(Candidatura cand) {
        this.cand = cand;
    }
    
    
}
