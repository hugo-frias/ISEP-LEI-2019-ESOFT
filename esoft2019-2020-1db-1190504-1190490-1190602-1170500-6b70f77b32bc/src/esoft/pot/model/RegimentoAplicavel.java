/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.util.List;

/**
 *
 * @author Utilizador
 */
public interface RegimentoAplicavel {
    void seriar();
    List<Candidatura> seriar(List<Candidatura> lst);
    String getDesignacao();
    
}
