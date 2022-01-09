/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;

/**
 *
 * @author Hugo
 */
public class ListaAnuncio {
    private ArrayList<Anuncio> listaAnuncio;

    public ListaAnuncio() {
        listaAnuncio = new ArrayList<>();
    }

    public ArrayList<Anuncio> getListaAnuncio() {
        return listaAnuncio;
    }

    public void setListaAnuncio(ArrayList<Anuncio> listaAnuncio) {
        this.listaAnuncio = listaAnuncio;
    }
    
    
    
}
