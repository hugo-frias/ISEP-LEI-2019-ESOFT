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
public class HabilitacaoAcademica {
    private String grau;
    private String desCur;
    private String inst;
    private String media;

    public HabilitacaoAcademica(String grau, String desCur, String inst, String media) {
        this.grau = grau;
        this.desCur = desCur;
        this.inst = inst;
        this.media = media;
    }

    public String getGrau() {
        return grau;
    }

    public void setGrau(String grau) {
        this.grau = grau;
    }

    public String getDesCur() {
        return desCur;
    }

    public void setDesCur(String desCur) {
        this.desCur = desCur;
    }

    public String getInst() {
        return inst;
    }

    public void setInst(String inst) {
        this.inst = inst;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }
    
    
}
