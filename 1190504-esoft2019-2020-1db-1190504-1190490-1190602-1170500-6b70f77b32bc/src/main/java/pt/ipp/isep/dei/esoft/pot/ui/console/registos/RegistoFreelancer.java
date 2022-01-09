/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.ui.console.registos;

import java.util.ArrayList;
import pt.ipp.isep.dei.esoft.pot.model.Freelancer;
import pt.ipp.isep.dei.esoft.pot.model.HabilitacaoAcademica;
import pt.ipp.isep.dei.esoft.pot.model.Reconhecimento;

/**
 *
 * @author Hugo
 */
public class RegistoFreelancer {
    
    private ArrayList<Freelancer> listaFreelancer;

    public RegistoFreelancer() {
        listaFreelancer = new ArrayList<>();
    }

    public void addHabilitacaoAcademica(HabilitacaoAcademica ha, Freelancer freel) {
        freel.addHabilitacaoAcademica(ha);
        
    }


    public void addReconhecimento(Reconhecimento re, Freelancer freel) {
        freel.setRe(re);
    }
    
}
