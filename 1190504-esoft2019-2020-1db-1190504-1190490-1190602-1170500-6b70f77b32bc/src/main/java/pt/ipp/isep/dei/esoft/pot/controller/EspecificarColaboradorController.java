/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.controller;

import pt.ipp.isep.dei.esoft.pot.model.Colaborador;
import pt.ipp.isep.dei.esoft.pot.model.Organizacao;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

/**
 *
 * @author gabri
 */
public class EspecificarColaboradorController {
    private Organizacao m_oOrganização;
    private Colaborador m_oColaborador;


    public boolean novoColaborador(String nome, String funcao, String telm, String email) {
        try {
            this.m_oColaborador = this.m_oOrganização.novoColaborador(nome, funcao, telm, email);
            return this.m_oColaborador.validaColaborador(this.m_oColaborador);
        } catch (RuntimeException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.m_oColaborador = null;
            return false;
        }
    }

    public boolean registaColaborador() {
        return this.m_oColaborador.registaColaborador(this.m_oColaborador);
    }

    public String getColaborador() {
        return this.m_oColaborador.toString();
    }

    public String getOrganizacao() {
        return this.m_oOrganização.toString();
    }
    
   public String gerarPassword() {
        String password = null;
        //codigo externo de password   
       return password;
   }

}
