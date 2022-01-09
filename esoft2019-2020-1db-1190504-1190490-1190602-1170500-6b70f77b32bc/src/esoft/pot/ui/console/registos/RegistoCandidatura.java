/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.ui.console.registos;

import java.util.ArrayList;
import java.util.Date;
import pt.ipp.isep.dei.esoft.pot.model.Candidatura;

/**
 *
 * @author diogo
 */
public class RegistoCandidatura {

    private ArrayList<Candidatura> listaCandidatura;

    public RegistoCandidatura(ArrayList<Candidatura> listaCandidatura) {
        this.listaCandidatura = listaCandidatura;
    }

    public RegistoCandidatura() {
        this.listaCandidatura = new ArrayList<>();
    }

    public Candidatura novaCandidatura(Date dataCandidatura, double valorPretendido, int numDias, String txtApresentacao, String txtMotivacao) {
        return new Candidatura(dataCandidatura, valorPretendido, numDias, txtApresentacao, txtMotivacao);
    }

    public boolean RegistoCandidatura(Candidatura oCandidatura) {
        if (this.validaCandidatura(oCandidatura)) {
            return addCandidatura(oCandidatura);
        }
        return false;
    }

    public boolean addCandidatura(Candidatura oCandidatura) {
        return listaCandidatura.add(oCandidatura);
    }

    public boolean validaCandidatura(Candidatura oCandidatura) {
        boolean bRet = true;

        // Escrever aqui o código de validação
        //
        return bRet;
    }

    public ArrayList<Candidatura> getListaCandidatura() {
        return listaCandidatura;
    }

    public void setListaCandidatura(ArrayList<Candidatura> listaCandidatura) {
        this.listaCandidatura = listaCandidatura;
    }

   public Candidatura setCandidatura(Date dataCandidatura, double valorPretendido, int numDias, String txtApresentacao, String txtMotivacao) {
        return new Candidatura(dataCandidatura, valorPretendido, numDias, txtApresentacao, txtMotivacao);
    }
   
   public Candidatura removeCandidatura(Date dataCandidatura, double valorPretendido, int numDias, String txtApresentacao, String txtMotivacao){
       Candidatura cand = new Candidatura(null,0,0,null,null);
        return cand;
       //posições recebidas por parametro passam a null 
   }
    
}
