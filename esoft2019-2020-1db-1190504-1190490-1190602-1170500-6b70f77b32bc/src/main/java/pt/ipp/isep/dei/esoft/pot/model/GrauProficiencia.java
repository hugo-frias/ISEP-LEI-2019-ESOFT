/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

/**
 *
 * @author Hugo
 */
public class GrauProficiencia {
    private String grau;
    private String designacao;

    public GrauProficiencia(String grau, String designacao) {
        this.grau = grau;
        this.designacao = designacao;
    }

    public String getGrau() {
        return grau;
    }

    public void setGrau(String grau) {
        this.grau = grau;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }
    
    
}
