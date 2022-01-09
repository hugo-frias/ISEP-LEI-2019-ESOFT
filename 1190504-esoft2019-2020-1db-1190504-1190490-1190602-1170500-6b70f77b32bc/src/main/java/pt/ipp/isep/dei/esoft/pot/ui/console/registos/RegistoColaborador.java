/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.ui.console.registos;

import java.util.ArrayList;
import pt.ipp.isep.dei.esoft.pot.model.Colaborador;

/**
 *
 * @author Hugo
 */
public class RegistoColaborador {
    private ArrayList<Colaborador> listaColaborador;

    public RegistoColaborador() {
        listaColaborador = new ArrayList<>();
    }

    
    public Colaborador novoColaborador(String nomeG, String funcao, String tlfG, String emailG){
        Colaborador colaborador = new Colaborador(nomeG, funcao, emailG, emailG);
        return colaborador;
    }
    public ArrayList<Colaborador> getListaColaborador() {
        return listaColaborador;
    }

    public void setListaColaborador(ArrayList<Colaborador> listaColaborador) {
        this.listaColaborador = listaColaborador;
    }
    public Colaborador getColaboradorByEmail(String email) {
        for (Colaborador colaborador: listaColaborador) {
            if (colaborador.getEmail().equals(email)) {
                return colaborador;
            }
        }
        return null;
    }
    
}
