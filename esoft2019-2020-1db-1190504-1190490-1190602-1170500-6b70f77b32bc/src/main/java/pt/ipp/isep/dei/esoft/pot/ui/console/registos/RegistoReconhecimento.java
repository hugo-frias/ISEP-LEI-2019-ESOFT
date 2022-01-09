/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.ui.console.registos;

import java.util.ArrayList;
import java.util.Date;
import pt.ipp.isep.dei.esoft.pot.model.CompetenciaTecnica;
import pt.ipp.isep.dei.esoft.pot.model.GrauProficiencia;
import pt.ipp.isep.dei.esoft.pot.model.Reconhecimento;

/**
 *
 * @author Hugo
 */
public class RegistoReconhecimento {
    
    private ArrayList<Reconhecimento> listaReconhecimentos;

    public RegistoReconhecimento() {
        listaReconhecimentos = new ArrayList<>();
    }



    public Reconhecimento addNewReconhecimento(Date data) {
        Reconhecimento re = new Reconhecimento(data);
        return re;
    }

    public void addGrauProficienciaACompTec(String grau, String designacao, CompetenciaTecnica compTec, Reconhecimento re) {
        GrauProficiencia gp = new GrauProficiencia(grau, designacao);
        compTec.addGrauProficiencia(gp);
        re.addCompTec(compTec);
    }
    
    
    
}
