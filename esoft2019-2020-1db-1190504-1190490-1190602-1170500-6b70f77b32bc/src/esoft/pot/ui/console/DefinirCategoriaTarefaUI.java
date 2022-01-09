/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.ui.console;

import java.util.List;
import pt.ipp.isep.dei.esoft.pot.controller.DefinirCategoriaTarefaController;
import pt.ipp.isep.dei.esoft.pot.model.AreaAtividade;
import pt.ipp.isep.dei.esoft.pot.model.CategoriaTarefa;
import pt.ipp.isep.dei.esoft.pot.model.CompetenciaTecnica;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

/**
 *
 * @author diogo
 */
public class DefinirCategoriaTarefaUI {

    private DefinirCategoriaTarefaController m_controller;

    public DefinirCategoriaTarefaUI() {
        m_controller = new DefinirCategoriaTarefaController();
    }

    public void run() {
        System.out.println("\nDefinirCategoriaTarefa:");

        if (introduzDados()) {
            apresentaDados();

            if (Utils.confirma("Confirma os dados introduzidos? (S/N)")) {
                if (m_controller.registaCategoriaTarefa()) {
                    System.out.println("Registo efetuado com sucesso.");
                } else {
                    System.out.println("Não foi possivel concluir o registo com sucesso.");
                }
            }
        } else {
            System.out.println("Ocorreu um erro. Operação cancelada.");
        }
    }

    private boolean introduzDados() {
        String id = Utils.readLineFromConsole("Identificador: ");
        String descriçao = Utils.readLineFromConsole("Descriçao: ");
        String area = Utils.readLineFromConsole("Area: ");
        String competenciaTecnica = Utils.readLineFromConsole("CompetenciaTecnica: ");

        List<CompetenciaTecnica> lc = m_controller.getCompetenciaTecnica();
        String compTecId = "";
        CompetenciaTecnica compTec = (CompetenciaTecnica) Utils.apresentaESeleciona(lc, "Selecione a Competencia Tecnica a que pertence a Categoria Tarefa: ");
        if (compTec != null) {
            compTecId = compTec.getId();
        }
        
        List<AreaAtividade> la = m_controller.getAreasAtividade();
        String areaId = "";
        AreaAtividade areaAtiv = (AreaAtividade) Utils.apresentaESeleciona(la, "Selecione a area de atividade a que pertence a Categoria Tarefa: ");
        if (areaAtiv != null) {
            areaId = areaAtiv.getCodigo();
        }

        return m_controller.novaCategoria(id, descriçao, areaAtiv, compTec);

    }

    private void apresentaDados() {
        System.out.println("\nCategoriaTarefa:\n" + m_controller.getCategoriaTarefaString());
    }

}
