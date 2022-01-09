/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Utilizador
 */
public class SeriacaoAutomatica extends Seriacao {

    private RegimentoAplicavel tipoReg;
    private List<Candidatura> lstCand;

    public SeriacaoAutomatica(List<Candidatura> lstCand, RegimentoAplicavel tipoReg) {
        super();
        this.lstCand = lstCand;
        this.tipoReg = tipoReg;
    }

    public List<Candidatura> getLstCand() {
        return lstCand;
    }

    public void setLstCand(List<Candidatura> lstCand) {
        this.lstCand = lstCand;
    }

    @Override
    public Candidatura getCandidaturaOfPosicao(int i) {
        return this.lstCand.get(0);
    }

}
