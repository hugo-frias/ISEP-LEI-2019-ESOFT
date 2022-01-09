/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Hugo
 */
public class Reconhecimento {
    private Date data;
    private ArrayList<CompetenciaTecnica> compTec;

    public Reconhecimento(Date data) {
        this.data = data;
        this.compTec = new ArrayList<>();
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ArrayList<CompetenciaTecnica> getCompTec() {
        return compTec;
    }

    public void setCompTec(ArrayList<CompetenciaTecnica> compTec) {
        this.compTec = compTec;
    }

    public void addCompTec(CompetenciaTecnica compTec) {
        this.compTec.add(compTec);
    }

    

    
    
}
