/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.ui.console.registos;

import java.util.ArrayList;
import pt.ipp.isep.dei.esoft.pot.model.AreaAtividade;
import pt.ipp.isep.dei.esoft.pot.model.CompetenciaTecnica;
import pt.ipp.isep.dei.esoft.pot.model.GrauProficiencia;

/**
 *
 * @author Hugo
 */
public class RegistoCompetenciaTecnica {

    private ArrayList<CompetenciaTecnica> listaCompetenciasTecnicas;

    public RegistoCompetenciaTecnica() {
        listaCompetenciasTecnicas = new ArrayList<>();
    }

    public ArrayList<CompetenciaTecnica> getListaCompetenciasTecnicas() {
        return listaCompetenciasTecnicas;
    }

    public void setListaCompetenciasTecnicas(ArrayList<CompetenciaTecnica> listaCompetenciasTecnicas) {
        this.listaCompetenciasTecnicas = listaCompetenciasTecnicas;
    }

    public CompetenciaTecnica novaCompetenciaTecnica(String id, String descB, String descD, AreaAtividade area) {
        CompetenciaTecnica compTec = new CompetenciaTecnica(id, descB, descD, area);
        return compTec;
    }

    public boolean validaCompetenciaTecnica(CompetenciaTecnica compTec) {
        boolean status = false;
        /*verificações*/
        return status;
    }

    public boolean registaCT(CompetenciaTecnica oCompTec) {
        if (this.validaCompetenciaTecnica(oCompTec)) {
            return this.addCompetenciaTecnica(oCompTec);
        }
        return false;
    }

    public GrauProficiencia addGrauProficiencia(String grau, String designacao, CompetenciaTecnica compTec) {
        GrauProficiencia grauProf = new GrauProficiencia(grau, designacao);
        validaGrauProficiencia(grauProf);
        compTec.addGrauProficiencia(grauProf);
        return grauProf;
    }

    public boolean validaGrauProficiencia(GrauProficiencia grauProf) {
        boolean status = false;
        /*verificações*/
        return status;
    }

    public boolean addCompetenciaTecnica(CompetenciaTecnica compTec) {
        return listaCompetenciasTecnicas.add(compTec);
    }

    public CompetenciaTecnica getCompTecById() {
         return null;
    }
}
