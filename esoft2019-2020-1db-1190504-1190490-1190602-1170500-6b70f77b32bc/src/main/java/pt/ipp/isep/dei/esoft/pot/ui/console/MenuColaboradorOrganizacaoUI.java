/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.ui.console;

import java.util.ArrayList;
import java.util.List;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

/**
 *
 * @author Mini Mi
 */
public class MenuColaboradorOrganizacaoUI {

    public MenuColaboradorOrganizacaoUI() {
    }

    public void run() {
        List<String> options = new ArrayList<String>();
        options.add("Especificar Tarefa");

        int opcao = 0;
        do {
            opcao = Utils.apresentaESelecionaIndex(options, "\n\nMenu Colaborador de Organizacao");

            switch (opcao) {
                case 0:
                    EspecificarTarefaUI uiTarefa = new EspecificarTarefaUI();
                    uiTarefa.run();
                    break;
                case 1:
                    break;
            }

            // Incluir as restantes opções aqui
        } while (opcao != -1);
    }

}
