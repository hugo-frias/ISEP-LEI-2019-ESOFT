/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;
import java.util.List;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;

/**
 *
 * @author gabri
 */
public class Anuncio {

    private String perPublicitacao;
    private String perApresentacao;
    private String perSeriacao;
    private RegimentoAplicavel Regimento;
    private List<Candidatura> listaCandidaturas;
    private ArrayList<Anuncio> listaAnuncio;
    private Seriacao seriacao;
    private Tarefa tarefa;
    private String anunID;

    public Anuncio(String perPublicitacao, String perApresentacao, String perSeriacao, SeriacaoSubjetivaAtribuicaoOpcional Regimento) {
        if ((perPublicitacao == null) || (perApresentacao == null) || (perSeriacao == null) || (Regimento == null)
                || (perPublicitacao.isEmpty()) || (perApresentacao.isEmpty()) || (perSeriacao.isEmpty())) {
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        }
        this.perPublicitacao = perPublicitacao;
        this.perApresentacao = perApresentacao;
        this.perSeriacao = perSeriacao;
        this.Regimento = Regimento;
        this.listaCandidaturas = new ArrayList<>();
        this.seriacao = new SeriacaoManual();

    }

    @Override
    public String toString() {
        return "Anuncio{" + "perPublicitacao=" + perPublicitacao + ", perApresentacao=" + perApresentacao + ", perSeriacao=" + perSeriacao + ", Regimento=" + Regimento + '}';
    }

    public String getPerPublicitacao() {
        return perPublicitacao;
    }

    public void setPerPublicitacao(String perPublicitacao) {
        this.perPublicitacao = perPublicitacao;
    }

    public String getPerApresentacao() {
        return perApresentacao;
    }

    public void setPerApresentacao(String perApresentacao) {
        this.perApresentacao = perApresentacao;
    }

    public String getPerSeriacao() {
        return perSeriacao;
    }

    public void setPerSeriacao(String perSeriacao) {
        this.perSeriacao = perSeriacao;
    }

    public RegimentoAplicavel getRegimento() {
        return Regimento;
    }

    public void setRegimento(SeriacaoSubjetivaAtribuicaoOpcional Regimento) {
        this.Regimento = Regimento;
    }

    public List<Candidatura> getListaCandidaturas() {
        return listaCandidaturas;
    }

    public void setListaCandidaturas(List<Candidatura> listaCandidaturas) {
        this.listaCandidaturas = listaCandidaturas;
    }

    ArrayList<Anuncio> addAnuncio(Anuncio m_anuncio) {
        return listaAnuncio;
    }

    /*
    public boolean validarPosicoesListaCandidaturas() {
        for (Classificacao clsf : this.seriacao.getLstClassificacao()) {
            if (clsf.getPosicao() > listaCandidaturas.size() || clsf.getPosicao() <= 0) {
                return false;
            }
        }
        return true;
    }
     */

    public Seriacao getSeriacao() {
        return seriacao;
    }

    public void setSeriacao(Seriacao seriacao) {
        this.seriacao = seriacao;
    }

    public ArrayList<Anuncio> getListaAnuncio() {
        return listaAnuncio;
    }

    public void setListaAnuncio(ArrayList<Anuncio> listaAnuncio) {
        this.listaAnuncio = listaAnuncio;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public String getAnunID() {
        return anunID;
    }

    public void setAnunID(String anunID) {
        this.anunID = anunID;
    }

}
