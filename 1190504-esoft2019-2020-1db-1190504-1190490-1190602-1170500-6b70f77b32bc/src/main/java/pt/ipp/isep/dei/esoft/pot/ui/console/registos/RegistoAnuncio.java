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
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.model.CategoriaTarefa;
import pt.ipp.isep.dei.esoft.pot.model.Tarefa;
import pt.ipp.isep.dei.esoft.pot.model.Anuncio;
import pt.ipp.isep.dei.esoft.pot.model.Candidatura;
import pt.ipp.isep.dei.esoft.pot.model.Freelancer;
import pt.ipp.isep.dei.esoft.pot.model.Organizacao;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;
import pt.ipp.isep.dei.esoft.pot.model.SeriacaoSubjetivaAtribuicaoOpcional;

/**
 *
 * @author gabri
 */
public class RegistoAnuncio {

    private ArrayList<Anuncio> lstAnuncio;
    private final Plataforma m_oPlataforma;

    public RegistoAnuncio(ArrayList<Anuncio> listaAnuncios) {
        this.lstAnuncio = lstAnuncio;
        this.m_oPlataforma = AplicacaoPOT.getInstance().getPlataforma();
    }

    public RegistoAnuncio() {
        this.lstAnuncio = new ArrayList<>();
        this.m_oPlataforma = AplicacaoPOT.getInstance().getPlataforma();
    }

    public Anuncio novaAnuncio(String perPublicitacao, String perApresentacao, String perSeriacao, SeriacaoSubjetivaAtribuicaoOpcional Regimento) {
        return new Anuncio(perPublicitacao, perApresentacao, perSeriacao, Regimento);
    }

    public boolean registaAnuncio(Anuncio oAnuncio) {
        if (this.validaAnuncio(oAnuncio)) {
            return addAnuncio(oAnuncio);
        }
        return false;
    }

    public boolean addAnuncio(Anuncio oAnuncio) {
        return lstAnuncio.add(oAnuncio);
    }

    public boolean validaAnuncio(Anuncio oAnuncio) {
        boolean bRet = true;

        // Escrever aqui o código de validação
        //
        return bRet;
    }

    public ArrayList<Anuncio> getListaAnuncios() {
        return lstAnuncio;
    }

    public void setListaTarefas(ArrayList<Anuncio> listaTarefas) {
        this.lstAnuncio = lstAnuncio;
    }

    public Anuncio getAnuncioById(String idAnuncio) {
        for ( Anuncio anun : this.lstAnuncio) {
            if (anun.getAnunID().equals(idAnuncio)) {
                return anun;
            }
        }
        return null;
    }
    
    public void novaAdjudicacao(Anuncio anuncio) {
        RegistoAdjudicacao registoAnuncio = m_oPlataforma.getRegistoAdjudicacao();
        Candidatura candidatura = anuncio.getSeriacao().getCandidaturaOfPosicao(1);
        String anunId = anuncio.getAnunID();
        Tarefa tarefa = anuncio.getTarefa();
        Freelancer fl = candidatura.getFreelancer();
        double valorAcordado = candidatura.getM_ovalorPretendido();
        Period perRealizacao = Period.between(LocalDate.now(),candidatura.getM_odataCandidatura());
        String desc = tarefa.getM_strDescInf();
        String refUnica = tarefa.getRefUnica();
        Organizacao org =  m_oPlataforma.getRegistoOrganizacao().getOrganizacaoByTarefa(refUnica);
        m_oPlataforma.getRegistoAdjudicacao().createAdjudicacao(org, fl, valorAcordado, perRealizacao, anunId, desc);
    }
    public List<Anuncio> getListaAnunciosSeriacaoAutomatica() {
        List<Anuncio> lstAnun = new ArrayList<>();
        for (Anuncio anun : this.lstAnuncio) { // é necessario rever isto
            if (anun.getRegimento().getDesignacao().equals("SeriacaoAutomatica2PrecoMaisBaixo")) {
                lstAnun.add(anun);
            }
        }
        return lstAnun;
    }
}
