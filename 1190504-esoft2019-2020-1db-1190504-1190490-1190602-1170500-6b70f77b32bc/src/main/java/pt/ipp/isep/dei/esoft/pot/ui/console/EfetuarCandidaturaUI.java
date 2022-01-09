/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.ui.console;

import java.util.Date;
import pt.ipp.isep.dei.esoft.pot.controller.EfetuarCandidaturaController;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

/**
 *
 * @author diogo
 */
public class EfetuarCandidaturaUI {
    
        private EfetuarCandidaturaController m_controller;

    public EfetuarCandidaturaUI() {
        m_controller = new EfetuarCandidaturaController();
    }

    public void run() {
        System.out.println("\nEfetuarCandidatura:");

        if (introduzDados()) {
            apresentaDados();

            if (Utils.confirma("Confirma os dados introduzidos? (S/N)")) {
                if (m_controller.registaCandidatura()) {
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
        String dataCandidatura = Utils.readLineFromConsole("Data: ");
        String txtApresentacao = Utils.readLineFromConsole("txtApresentacao: ");
        String valorPretendido = Utils.readLineFromConsole("valorPretendido: ");
        String numDias = Utils.readLineFromConsole("numDias: ");
        String txtMotivacao = Utils.readLineFromConsole("txtMotivacao: ");


        return m_controller.novaCandidatura(dataCandidatura, txtApresentacao, valorPretendido, numDias, txtMotivacao);

    }

    private void apresentaDados() {
        System.out.println("\nCandidatura:\n" + m_controller.getCandidaturaString());
    }
}
