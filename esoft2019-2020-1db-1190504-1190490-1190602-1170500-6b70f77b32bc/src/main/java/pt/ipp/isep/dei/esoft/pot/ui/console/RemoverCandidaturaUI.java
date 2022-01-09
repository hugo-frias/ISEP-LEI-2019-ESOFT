/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main.java.pt.ipp.isep.dei.esoft.pot.ui.console;

import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;
import src.main.java.pt.ipp.isep.dei.esoft.pot.controller.RemoverCandidaturaController;

/**
 *
 * @author gabri
 */
public class RemoverCandidaturaUI {

    private RemoverCandidaturaController m_controller;

    public RemoverCandidaturaUI() {
        m_controller = new RemoverCandidaturaController();
    }

    private void apresentaDados() {
        System.out.println("\nCandidatura:\n" + m_controller.getCandidaturaString());
        System.out.println("\nDeseja remover candidatura?:\n" + m_controller.removerCandidatura());
    }

    public void run() {
        System.out.println("\nAtualizarCandidatura:");

        if (Utils.confirma("Confirma os dados introduzidos? (S/N)")) {
            if (m_controller.removerCandidatura()) {
                System.out.println("Registo efetuado com sucesso.");
            } else {
                System.out.println("Não foi possivel concluir o registo com sucesso.");
            }
        }

    }
}
