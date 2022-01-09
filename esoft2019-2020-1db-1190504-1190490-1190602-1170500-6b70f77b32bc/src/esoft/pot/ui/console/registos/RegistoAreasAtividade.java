/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.ipp.isep.dei.esoft.pot.ui.console.registos;

import java.util.ArrayList;
import pt.ipp.isep.dei.esoft.pot.model.AreaAtividade;

/**
 *
 * @author Hugo
 */
public class RegistoAreasAtividade {
private ArrayList<AreaAtividade> listaAreaAtividade;

    public RegistoAreasAtividade(ArrayList<AreaAtividade> listaAreaAtividade) {
        this.listaAreaAtividade = listaAreaAtividade;
    }

    public RegistoAreasAtividade() {
        listaAreaAtividade = new ArrayList<>();
    }

    public ArrayList<AreaAtividade> getListaAreaAtividade() {
        return listaAreaAtividade;
    }

    public void setListaAreaAtividade(ArrayList<AreaAtividade> listaAreaAtividade) {
        this.listaAreaAtividade = listaAreaAtividade;
    }
    public AreaAtividade novaAA(String strId, String strDescriçao, String descString ) {
        return new AreaAtividade(strId, strDescriçao,descString);
    }

    public AreaAtividade getAreaByCod(String aCod){
        /*código de modo a ir buscar a área de atividade com o código "aCod"*/
        return null;
    }
    public boolean validaAA(AreaAtividade oAA) {
        boolean bRet = true;

        // Escrever aqui o código de validação
        //
        return bRet;
    }
    public boolean registaAA(AreaAtividade oArea) {
        if (this.validaAA(oArea)) {
            return addAA(oArea);
        }
        return false;
    }
    public boolean addAA(AreaAtividade oArea) {
        return this.listaAreaAtividade.add(oArea);
    }
}
