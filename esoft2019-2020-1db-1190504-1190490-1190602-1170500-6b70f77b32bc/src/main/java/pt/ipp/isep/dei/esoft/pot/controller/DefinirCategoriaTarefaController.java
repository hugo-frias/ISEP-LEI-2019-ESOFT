/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.controller;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.ipp.isep.dei.esoft.pot.model.AreaAtividade;
import pt.ipp.isep.dei.esoft.pot.model.Constantes;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;
import pt.ipp.isep.dei.esoft.pot.model.CategoriaTarefa;
import pt.ipp.isep.dei.esoft.pot.model.CompetenciaTecnica;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

/**
 *
 * @author diogo
 */
public class DefinirCategoriaTarefaController {

    private Plataforma m_oPlataforma;
    private CategoriaTarefa m_oCategoriaTarefa;

    public DefinirCategoriaTarefaController() {
        if (!AplicacaoPOT.getInstance().getSessaoAtual().isLoggedInComPapel(Constantes.PAPEL_ADMINISTRATIVO)) {
            throw new IllegalStateException("Utilizador não Autorizado");
        }
        this.m_oPlataforma = AplicacaoPOT.getInstance().getPlataforma();
    }

    public List<CompetenciaTecnica> getCompetenciaTecnica() {
        return this.m_oPlataforma.getRegistoCompetenciaTecnica().getListaCompetenciasTecnicas();
    }

    public List<AreaAtividade> getAreasAtividade() {
        return this.m_oPlataforma.getRegistoAreasAtividade().getListaAreaAtividade();
    }

    public boolean novaCategoria(String id, String descriçao, AreaAtividade area, CompetenciaTecnica compTec) {
        try {
            AreaAtividade areaAtiv = this.m_oPlataforma.getRegistoAreasAtividade().getAreaByCod(id);
            int opcao;
            do {
                CompetenciaTecnica competenciaTec = this.m_oPlataforma.getRegistoCompetenciaTecnica().getCompTecById();
                System.out.println("Se pretender adicionar mais competencias tecnicas digite 1, senão, digite 0");
                Scanner ler = new Scanner(System.in);
                opcao = ler.nextInt();

            } while (opcao != 0);

            this.m_oCategoriaTarefa = this.m_oPlataforma.getRegistoCategoriaTarefa().novaCategoriaTarefa(id, descriçao, area, compTec);
            return this.m_oPlataforma.getRegistoCategoriaTarefa().registaCategoriaTarefa(this.m_oCategoriaTarefa);
        } catch (RuntimeException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.m_oCategoriaTarefa = null;
            return false;
        }
    }

    public boolean registaCategoriaTarefa() {
        return this.m_oPlataforma.getRegistoCategoriaTarefa().registaCategoriaTarefa(this.m_oCategoriaTarefa);
    }

    public String getCategoriaTarefaString() {
        return this.m_oCategoriaTarefa.toString();
    }

}
