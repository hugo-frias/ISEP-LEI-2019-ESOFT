/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;

/**
 *
 * @author Hugo
 */
public class Freelancer {
    private String nome;
    private EnderecoPostal end;
    private long tlf;
    private String email;
    private ArrayList<HabilitacaoAcademica> ha;
    private Reconhecimento re;



    public Freelancer(String nome, EnderecoPostal end, long tlf, String email) {
        this.nome = nome;
        this.end = end;
        this.tlf = tlf;
        this.email = email;
        ha = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EnderecoPostal getEnd() {
        return end;
    }

    public void setEnd(EnderecoPostal end) {
        this.end = end;
    }

    public long getTlf() {
        return tlf;
    }

    public void setTlf(long tlf) {
        this.tlf = tlf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<HabilitacaoAcademica> getHa() {
        return ha;
    }

    public void setHa(ArrayList<HabilitacaoAcademica> ha) {
        this.ha = ha;
    }

    public Reconhecimento getRe() {
        return re;
    }

    public void setRe(Reconhecimento re) {
        this.re = re;
    }

    public void addHabilitacaoAcademica(HabilitacaoAcademica ha) {
        this.ha.add(ha);
    }
    
    
}
