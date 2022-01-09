/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.ipp.isep.dei.esoft.pot.model.CategoriaTarefa;
import pt.ipp.isep.dei.esoft.pot.model.Constantes;
import pt.ipp.isep.dei.esoft.pot.model.Organizacao;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;
import pt.ipp.isep.dei.esoft.pot.model.SeriacaoManual;
import pt.ipp.isep.dei.esoft.pot.model.Tarefa;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;
import pt.ipp.isep.dei.esoft.pot.model.Anuncio;
import pt.ipp.isep.dei.esoft.pot.model.SeriacaoSubjetivaAtribuicaoOpcional;

/**
 *
 * @author gabri
 */
public class PublicarTarefaController {

    private Plataforma m_oPlataforma;
    private Tarefa m_oTarefa;
    private Organizacao organizacao;
    private Anuncio m_oAnuncio;
    private Anuncio m_anuncio;

    public PublicarTarefaController() {
        if (!pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT.getInstance().getSessaoAtual().isLoggedInComPapel(Constantes.PAPEL_COLABORADOR_ORGANIZACAO)) {
            throw new IllegalStateException("Utilizador não Autorizado");
        }
        this.m_oPlataforma = pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT.getInstance().getPlataforma();
    }

    public List<Tarefa> getTarefa() {
        return (List<Tarefa>) this.m_oPlataforma.getRegistoTarefas();
    }

    public boolean novoAnuncio(String perPublicitacao, String perApresentacao, String perSeriacao, SeriacaoSubjetivaAtribuicaoOpcional Regimento) {
        try {
            this.m_oAnuncio = this.m_oPlataforma.novoAnuncio(perPublicitacao, perApresentacao, perSeriacao, Regimento);
            return this.organizacao.validaAnuncio(this.m_oAnuncio);
        } catch (RuntimeException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.m_oAnuncio = null;
            return false;
        }
    }

    public boolean registaAnunio() {
        return this.organizacao.registaAnuncio(this.m_anuncio);
    }

    public String getAnuncioString() {
        return this.m_oAnuncio.toString();
    }
}
