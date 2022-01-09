/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.ui.console;

import pt.ipp.isep.dei.esoft.pot.controller.EspecificarColaboradorController;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

/**
 *
 * @author gabri
 */
public class EspecificarColaboradorUI {

    private EspecificarColaboradorController m_controller1;

    public EspecificarColaboradorUI() {
        m_controller1 = new EspecificarColaboradorController();
    }

    public void run() {
        System.out.println("\nEspecificar Colaborador:");

        if (introduzDados()) {
            apresentaDados();

            if (Utils.confirma("Confirma os dados do Utilizador? (S/N)")) {
                if (m_controller1.registaColaborador()) {
                    System.out.println("Colaborador registado com sucesso.");
                } else {
                    System.out.println("Não foi possivel concluir o registo do Colaborador.");
                }
            }
        } else {
            System.out.println("Ocorreu um erro. Operação cancelada.");
        }
    }

    private boolean introduzDados() {
        String strNome = Utils.readLineFromConsole("Insira Nome: ");
        String strFuncao = Utils.readLineFromConsole("Insira Funcao: ");
        String strTelefone = Utils.readLineFromConsole("Insira o Telefone: ");
        String strEmail = Utils.readLineFromConsole("Insira o Email: ");

        return m_controller1.novoColaborador(strNome, strFuncao, strTelefone,strEmail);
    }

    private void apresentaDados() {
        System.out.println("\nColaborador:\n" + m_controller1.getColaborador());
        System.out.println("\nOrganização:\n" + m_controller1.getOrganizacao());
    }

}
