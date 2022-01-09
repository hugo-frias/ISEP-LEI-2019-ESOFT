/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.ui.console;

import java.util.List;
import pt.ipp.isep.dei.esoft.pot.controller.EspecificarTarefaController;
import pt.ipp.isep.dei.esoft.pot.model.CategoriaTarefa;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

/**
 *
 * @author Mini Mi
 */
public class EspecificarTarefaUI {
    
    private EspecificarTarefaController m_controller;
    
    public EspecificarTarefaUI() {
        m_controller = new EspecificarTarefaController();
    }
    
    public void run() {
        System.out.println("\nEspecificar Tarefa:");
        
        if (introduzDados()) {
            apresentaDados();
            
            if (Utils.confirma("Confirma os dados introduzidos? (S/N)")) {
                if (m_controller.registaTarefa()) {
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
        String refUnica = Utils.readLineFromConsole("Referencia: ");
        String designacao = Utils.readLineFromConsole("Designacao: ");
        String descInf = Utils.readLineFromConsole("Descrição informal: ");
        String descTec = Utils.readLineFromConsole("Descrição técnica: ");
        int duracao = Integer.parseInt(Utils.readLineFromConsole("Designacao: "));
        double custo = Double.parseDouble(Utils.readLineFromConsole("Custo: "));
        
        List<CategoriaTarefa> lc = m_controller.getCategoriaTarefa();
        String catId = "";
        CategoriaTarefa cat = (CategoriaTarefa) Utils.apresentaESeleciona(lc, "Selecione a Categoria de Tarefa a que pertence esta Tarefa: ");
        if (cat != null) {
            catId = cat.getId();
        }
        return m_controller.novaTarefa(refUnica, designacao, descInf, descTec, duracao, catId, custo);
        
    }
    
    private void apresentaDados() {
        System.out.println("\nTarefa:\n" + m_controller.getTarefaString());
    }
    
}
