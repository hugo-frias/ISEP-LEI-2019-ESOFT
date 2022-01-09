/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main.java.pt.ipp.isep.dei.esoft.pot.controller;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.ipp.isep.dei.esoft.pot.model.Anuncio;
import pt.ipp.isep.dei.esoft.pot.model.Candidatura;
import pt.ipp.isep.dei.esoft.pot.model.Constantes;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;
import pt.ipp.isep.dei.esoft.pot.ui.console.registos.RegistoCandidatura;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

/**
 *
 * @author gabri
 */
public class RemoverCandidaturaController {

    private Plataforma m_oPlataforma;
    private Candidatura m_oCandidatura;
    private RegistoCandidatura registoCandidatura;

    public RemoverCandidaturaController() {
        if (!pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT.getInstance().getSessaoAtual().isLoggedInComPapel(Constantes.PAPEL_COLABORADOR_ORGANIZACAO)) {
            throw new IllegalStateException("Utilizador não Autorizado");
        }
        this.m_oPlataforma = pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT.getInstance().getPlataforma();
        this.registoCandidatura = this.m_oPlataforma.getRegistoCandidatura();
    }

    public List<Anuncio> getAnuncio() {
        return (List<Anuncio>) this.m_oPlataforma.getRegistoTarefas();
    }

    public boolean removerCandidatura(Candidatura cand) {
        try {
            this.registoCandidatura.getListaCandidatura();
            this.m_oCandidatura = this.registoCandidatura.getListaCandidatura().get(0);
        } catch (RuntimeException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.m_oCandidatura = null;
        }
        return false;
    }

        public boolean removerCandidatura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
            public String getCandidaturaString() {
        return this.m_oCandidatura.toString();
    }

}
