/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.controller;

import java.util.ArrayList;
import pt.ipp.isep.dei.esoft.pot.model.Adjudicacao;
import pt.ipp.isep.dei.esoft.pot.model.Anuncio;
import pt.ipp.isep.dei.esoft.pot.model.Candidatura;
import pt.ipp.isep.dei.esoft.pot.model.Constantes;
import pt.ipp.isep.dei.esoft.pot.model.ListaAnuncio;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;
import pt.ipp.isep.dei.esoft.pot.ui.console.registos.RegistoAnuncio;
import pt.ipp.isep.dei.esoft.pot.ui.console.registos.RegistoCandidatura;

/**
 *
 * @author Hugo
 */
public class AdjudicarAnuncioController {
    
    private Plataforma m_oPlataforma;
    private ListaAnuncio listaAnuncio;
    private RegistoAnuncio registoAnuncio;
    private Adjudicacao adjudicacao;

    public AdjudicarAnuncioController() {
        if (!AplicacaoPOT.getInstance().getSessaoAtual().isLoggedInComPapel(Constantes.PAPEL_COLABORADOR_ORGANIZACAO)) {
            throw new IllegalStateException("Utilizador não Autorizado");
        }
        this.m_oPlataforma = AplicacaoPOT.getInstance().getPlataforma();
        this.registoAnuncio = this.m_oPlataforma.getRegistoAnuncio();
    }
    
    
    public ArrayList<Anuncio> getListaDeAnuncios(){
        return registoAnuncio.getListaAnuncios();
    }
    
    public void novaAdjudicacao(String idAnuncio){
        Anuncio anuncio = registoAnuncio.getAnuncioById(idAnuncio);
        registoAnuncio.novaAdjudicacao(anuncio);
    }
    
    public void registaAdjudicacao(){
        
    }
    
}
