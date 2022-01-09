/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.ui.console;

import java.util.ArrayList;
import java.util.List;
import pt.ipp.isep.dei.esoft.pot.ui.console.EspecificarColaboradorUI;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

/**
 *
 * @author gabri
 */
public class MenuGestorOrganizacaoUI {

    public MenuGestorOrganizacaoUI() {
    }

    public void run() {
        List<String> options = new ArrayList<String>();
        options.add("Especificar Colaborador da Organização");

        int opcao = 0;
        do {
            opcao = Utils.apresentaESelecionaIndex(options, "\n\nMenu Gestor de Organização");

            switch (opcao) {
                case 1:
                    EspecificarColaboradorUI ui = new EspecificarColaboradorUI();
                    ui.run();
                    break;

            }

        } while (opcao != -1);
    }
}
