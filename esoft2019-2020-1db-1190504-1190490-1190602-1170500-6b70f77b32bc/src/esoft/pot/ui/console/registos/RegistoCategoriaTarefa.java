/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.ui.console.registos;

import java.util.ArrayList;
import pt.ipp.isep.dei.esoft.pot.model.AreaAtividade;
import pt.ipp.isep.dei.esoft.pot.model.CategoriaTarefa;
import pt.ipp.isep.dei.esoft.pot.model.CompetenciaTecnica;

/**
 *
 * @author diogo
 */
public class RegistoCategoriaTarefa {
    
    private ArrayList<CategoriaTarefa> listaCategoriaTarefa;

    public RegistoCategoriaTarefa(ArrayList<CategoriaTarefa> listaCategoriaTarefa) {
        this.listaCategoriaTarefa = listaCategoriaTarefa;
    }

    public RegistoCategoriaTarefa() {
        this.listaCategoriaTarefa = new ArrayList<>();
    }

    public CategoriaTarefa novaCategoriaTarefa(String strId, String strDescriçao, AreaAtividade oArea, CompetenciaTecnica oCompetencia) {
        return new CategoriaTarefa(strId, strDescriçao, oArea, oCompetencia);
    }

    public boolean registaCategoriaTarefa(CategoriaTarefa oCategoria) {
        if (this.validaCategoriaTarefa(oCategoria)) {
            return addCategoriaTarefa(oCategoria);
        }
        return false;
    }

    public boolean addCategoriaTarefa(CategoriaTarefa oCategoria) {
        return listaCategoriaTarefa.add(oCategoria);
    }

    public boolean validaCategoriaTarefa(CategoriaTarefa oCategoria) {
        boolean bRet = true;

        // Escrever aqui o código de validação
        //
        return bRet;
    }

    public CategoriaTarefa getCategoriaById(String Id) {
        for (CategoriaTarefa oCategoria : this.listaCategoriaTarefa) {
            if (oCategoria.hasId(Id)) {
                return oCategoria;
            }
        }

        return null;
    }

    public ArrayList<CategoriaTarefa> getListaCategoriaTarefa() {
        return listaCategoriaTarefa;
    }

    public void setListaCategoriaTarefa(ArrayList<CategoriaTarefa> listaCategoriaTarefa) {
        this.listaCategoriaTarefa = listaCategoriaTarefa;
    }
    
    
}
