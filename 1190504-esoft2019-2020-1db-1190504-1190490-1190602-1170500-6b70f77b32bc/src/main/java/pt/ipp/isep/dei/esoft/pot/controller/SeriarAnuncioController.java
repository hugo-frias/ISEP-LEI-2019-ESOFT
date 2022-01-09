/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.controller;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.ipp.isep.dei.esoft.pot.model.Anuncio;
import pt.ipp.isep.dei.esoft.pot.model.Classificacao;
import pt.ipp.isep.dei.esoft.pot.model.Colaborador;
import pt.ipp.isep.dei.esoft.pot.model.Constantes;
import pt.ipp.isep.dei.esoft.pot.model.Organizacao;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;
import pt.ipp.isep.dei.esoft.pot.model.SeriacaoManual;
import pt.ipp.isep.dei.esoft.pot.ui.console.registos.RegistoOrganizacao;
import pt.ipp.isep.dei.esoft.pot.ui.console.registos.RegistoSeriacao;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

/**
 *
 * @author Mini Mi
 */
public class SeriarAnuncioController {

    private SeriacaoManual m_oSeriacao;

    private Plataforma m_oPlataforma;

    private RegistoSeriacao registoSeriacao;

    public SeriarAnuncioController() {
        if (!AplicacaoPOT.getInstance().getSessaoAtual().isLoggedInComPapel(Constantes.PAPEL_COLABORADOR_ORGANIZACAO)) {
            throw new IllegalStateException("Utilizador não Autorizado");
        }
        this.m_oPlataforma = AplicacaoPOT.getInstance().getPlataforma();
        registoSeriacao = this.m_oPlataforma.getRegistoSeriacao();
    }

    public boolean novaSeriacaoManual(List<Colaborador> colabParticipantes) {
        try {
            this.m_oSeriacao = this.registoSeriacao.novaSeriacao();
            this.m_oSeriacao.setColabParticipantes(colabParticipantes);
            return this.registoSeriacao.validaSeriacao(m_oSeriacao);
        } catch (RuntimeException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.m_oSeriacao = null;
            return false;
        }
    }

    public List<Anuncio> getAnunciosOfColaboradorUtilizador() {
        String email = AplicacaoPOT.getEmailUtilizador();
        return m_oPlataforma.getRegistoColaborador().getColaboradorByEmail(email).getListaAnunciosPublicados();

    }

    public void atribuirClassificacaoCandidatura(Classificacao clsf) {
        this.m_oSeriacao.getLstClassificacao().add(clsf);

    }

    public void validarListaCandidaturas() {

    }

    public boolean registaSeriacao() {
        return this.registoSeriacao.registaSeriacao(m_oSeriacao);
    }

    public List<Colaborador> getListaColaboradoresMesmaOrganizacao() {
        String email = AplicacaoPOT.getEmailUtilizador();
        Organizacao organizacaoDoColaborador = this.m_oPlataforma.getRegistoOrganizacao().getOrganizacaoByEmailUtilizador(email);
        return (ArrayList<Colaborador>) organizacaoDoColaborador.getM_lstColaboradores();
    }

    public Colaborador getColaborador(int i) {
        return this.getListaColaboradoresMesmaOrganizacao().get(i);
    }

    public String getSeriacaoString() {
        return this.m_oSeriacao.toString();
    }

    public void addColab(Colaborador colab) {
        m_oSeriacao.addColab(colab);
    }
    public void fazerAdjudicacao(Anuncio anuncio) {
        this.m_oPlataforma.getRegistoAnuncio().novaAdjudicacao(anuncio);
    }
    public void setTxtConclusao(String txtConclusao) {
        this.m_oSeriacao.setTxtConclusão(txtConclusao);
    }
}
