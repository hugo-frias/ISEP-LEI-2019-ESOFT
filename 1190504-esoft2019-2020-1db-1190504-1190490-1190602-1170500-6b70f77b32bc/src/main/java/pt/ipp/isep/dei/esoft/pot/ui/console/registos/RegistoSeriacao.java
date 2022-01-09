/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.ui.console.registos;

import java.util.ArrayList;
import pt.ipp.isep.dei.esoft.pot.model.SeriacaoManual;

/**
 *
 * @author Mini Mi
 */
public class RegistoSeriacao {
    private ArrayList<SeriacaoManual> listaSeriacao;

    public RegistoSeriacao(ArrayList<SeriacaoManual> listaSeriacao) {
        this.listaSeriacao = listaSeriacao;
    }

    public RegistoSeriacao() {
        this.listaSeriacao = new ArrayList<>();
    }

    public SeriacaoManual novaSeriacao() {
        return new SeriacaoManual();
    }

    public boolean registaSeriacao(SeriacaoManual oSeriacao) {
        if (this.validaSeriacao(oSeriacao)) {
            return addSeriacao(oSeriacao);
        }
        return false;
    }

    public boolean addSeriacao(SeriacaoManual oSeriacao) {
        return listaSeriacao.add(oSeriacao);
    }

    public boolean validaSeriacao(SeriacaoManual oTarefa) {
        boolean bRet = true;

        // Escrever aqui o código de validação
        //
        return bRet;
    }


    public ArrayList<SeriacaoManual> getListaTarefas() {
        return listaSeriacao;
    }

    public void setListaTarefas(ArrayList<SeriacaoManual> listaTarefas) {
        this.listaSeriacao = listaTarefas;
    }
}
