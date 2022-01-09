/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.ui.console;

import java.util.ArrayList;
import java.util.List;
import pt.ipp.isep.dei.esoft.pot.controller.SeriarAnuncioController;
import pt.ipp.isep.dei.esoft.pot.model.Anuncio;
import pt.ipp.isep.dei.esoft.pot.model.Candidatura;
import pt.ipp.isep.dei.esoft.pot.model.Classificacao;
import pt.ipp.isep.dei.esoft.pot.model.Colaborador;
import pt.ipp.isep.dei.esoft.pot.model.SeriacaoManual;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

/**
 *
 * @author Mini Mi
 */
public class SeriarAnuncioUI {
    
    private SeriarAnuncioController m_controller;
    
    public SeriarAnuncioUI() {
        m_controller = new SeriarAnuncioController();
    }
    
    public void run() throws ClassNotFoundException {
        System.out.println("\n Seriar anuncio:");
        
        if (introduzDados()) {
            apresentaDados();
            
            if (Utils.confirma("Confirma? (S/N)")) {
                if (m_controller.registaSeriacao()) {
                    System.out.println("Seriacao realizada com sucesso.");
                } else {
                    System.out.println("Não foi possivel concluir a seriacao com sucesso.");
                }
            }
        } else {
            System.out.println("Ocorreu um erro. Operação cancelada.");
        }
    }
    
    private boolean introduzDados() throws ClassNotFoundException {
        List<Anuncio> listaAnuncio = m_controller.getAnunciosOfColaboradorUtilizador();
        List<Colaborador> lc = m_controller.getListaColaboradoresMesmaOrganizacao();
        Anuncio anuncio = (Anuncio) Utils.apresentaESeleciona(listaAnuncio, "Selecione o anuncio para qual pretende realizar a seriacao: ");
        int input = -1;
        while (input != 0) {
            input = Utils.apresentaESelecionaIndex(lc, "Selecione colaboradores participantes: ");
            m_controller.addColab(lc.get(input));
            lc.remove(input);
        }
        List<Candidatura> listaCandidatura = new ArrayList<>(anuncio.getListaCandidaturas());
        input = -1;
        int outroInput = -1;
        while (input != 0) {
            input = Utils.apresentaESelecionaIndex(listaCandidatura, "Escolha uma candidatura do anuncio: ");
            Candidatura candidatura = listaCandidatura.get(input);
            outroInput = Utils.readIntegerFromConsole("Atribua uma classificacao");
            String outroInput2 = Utils.readLineFromConsole("Introduza a justificação da classificação");
            m_controller.atribuirClassificacaoCandidatura(new Classificacao(outroInput, outroInput2, candidatura));
            listaCandidatura.remove(candidatura);
        }
        if (anuncio.getRegimento().equals(Class.forName("SeriacaoSubjetivaAtribuicaoObrigatoria"))) {
            m_controller.fazerAdjudicacao(anuncio);
        }
        String outroInput3 = Utils.readLineFromConsole("Introduza um texto de conclusão: ");
        m_controller.setTxtConclusao(outroInput3);
        return m_controller.novaSeriacaoManual(lc);
        
    }
    
    private void apresentaDados() {
        System.out.println("\nSeriacao:\n" + m_controller.getSeriacaoString());
    }
    
}
