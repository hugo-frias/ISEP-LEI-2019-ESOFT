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
import pt.ipp.isep.dei.esoft.pot.model.Tarefa;
import pt.ipp.isep.dei.esoft.pot.ui.console.registos.RegistoTarefas;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

/**
 *
 * @author Mini Mi
 */
public class EspecificarTarefaController {

    private Plataforma m_oPlataforma;
    private Tarefa m_oTarefa;
    private RegistoTarefas registoTarefas;

    public EspecificarTarefaController() {
        if (!AplicacaoPOT.getInstance().getSessaoAtual().isLoggedInComPapel(Constantes.PAPEL_COLABORADOR_ORGANIZACAO)) {
            throw new IllegalStateException("Utilizador não Autorizado");
        }
        this.m_oPlataforma = AplicacaoPOT.getInstance().getPlataforma();
        this.registoTarefas = this.m_oPlataforma.getRegistoTarefas();
    }

    public List<CategoriaTarefa> getCategoriaTarefa() {
        return this.m_oPlataforma.getRegistoCategoriaTarefa().getListaCategoriaTarefa();
    }

    public boolean novaTarefa(String refUnica, String designacao, String descInf, String descTec, int duracao, String catId, double custo) {
        try {
            CategoriaTarefa catTarefa = this.m_oPlataforma.getRegistoCategoriaTarefa().getCategoriaById(catId);
            this.m_oTarefa = this.registoTarefas.novaTarefa(refUnica, designacao, descInf, descTec, duracao, catTarefa, custo);
            return this.registoTarefas.validaTarefa(this.m_oTarefa);
        } catch (RuntimeException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.m_oTarefa = null;
            return false;
        }
    }

    public boolean registaTarefa() {
        return this.registoTarefas.registaTarefa(this.m_oTarefa);
    }

    public String getTarefaString() {
        return this.m_oTarefa.toString();
    }

}
