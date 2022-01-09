/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.ui.console;

import pt.ipp.isep.dei.esoft.pot.controller.AtualizarCandidaturaController;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

/**
 *
 * @author diogo
 */
public class AtualizarCandidaturaUI {
    
       private AtualizarCandidaturaController m_controller;

    public AtualizarCandidaturaUI() {
        m_controller = new AtualizarCandidaturaController();
    }

    public void run() {
        System.out.println("\nAtualizarCandidatura:");

        if (introduzDados()) {
            apresentaDados();

            if (Utils.confirma("Confirma os dados introduzidos? (S/N)")) {
                if (m_controller.registaCandidaturaAtualizada()) {
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
        String valorPretendido = Utils.readLineFromConsole("valorPretendido: ");
        String numDias = Utils.readLineFromConsole("numDias: ");
        String txtApresentacao = Utils.readLineFromConsole("txtApresentacao: ");
        String txtMotivacao = Utils.readLineFromConsole("txtMotivacao: ");


        return m_controller.atualizarCandidatura(dataCandidatura, valorPretendido, numDias, txtApresentacao, txtMotivacao);

    }

    private void apresentaDados() {
        System.out.println("\nCandidatura:\n" + m_controller.getCandidaturaAtualizadaString());
    }
    
}
