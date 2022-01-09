/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.ui.console.registos;

import java.util.ArrayList;
import pt.ipp.isep.dei.esoft.pot.model.CategoriaTarefa;
import pt.ipp.isep.dei.esoft.pot.model.Tarefa;

/**
 *
 * @author Mini Mi
 */
public class RegistoTarefas {

    private ArrayList<Tarefa> listaTarefas;

    public RegistoTarefas(ArrayList<Tarefa> listaTarefas) {
        this.listaTarefas = listaTarefas;
    }

    public RegistoTarefas() {
        this.listaTarefas = new ArrayList<>();
    }

    public Tarefa novaTarefa(String refUnica, String designacao, String descInf, String descTec, int duracao, CategoriaTarefa categoria, double custo) {
        return new Tarefa(refUnica, designacao, descInf, descTec, duracao, categoria, custo);
    }

    public boolean registaTarefa(Tarefa oTarefa) {
        if (this.validaTarefa(oTarefa)) {
            return addTarefa(oTarefa);
        }
        return false;
    }

    public boolean addTarefa(Tarefa oTarefa) {
        return listaTarefas.add(oTarefa);
    }

    public boolean validaTarefa(Tarefa oTarefa) {
        boolean bRet = true;

        // Escrever aqui o código de validação
        //
        return bRet;
    }

    public Tarefa getTarefaByRefUnica(String refUnica) {
        for (Tarefa tarefa : this.listaTarefas) {
            if (tarefa.hasRefUnica(refUnica)) {
                return tarefa;
            }
        }

        return null;
    }

    public ArrayList<Tarefa> getListaTarefas() {
        return listaTarefas;
    }

    public void setListaTarefas(ArrayList<Tarefa> listaTarefas) {
        this.listaTarefas = listaTarefas;
    }
    
}
