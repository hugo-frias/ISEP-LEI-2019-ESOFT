/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.util.Objects;

/**
 *
 * @author Mini Mi
 */
public class Tarefa {

    private String m_strRefUnica;
    private String m_strDesignacao;
    private String m_strDescInf;
    private String m_strDescTec;
    private int m_intDuracao;
    private CategoriaTarefa m_oCategoria;
    private double m_dblCusto;

    public Tarefa(String strRefUnica, String strDesignacao, String strDescInf, String strDescTec, int intDuracao, CategoriaTarefa oCategoria, double dblCusto) {
        if ((strRefUnica == null) || (strDesignacao == null) || (strDescInf == null) || (strDescTec == null) || (intDuracao == 0) || (oCategoria == null) || (dblCusto == 0)
                || (strDesignacao.isEmpty()) || (strDescInf.isEmpty()) || (strDescTec.isEmpty())) {
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        }
        this.m_strRefUnica = strRefUnica;
        this.m_strDesignacao = strDesignacao;
        this.m_strDescInf = strDescInf;
        this.m_strDescTec = strDescTec;
        this.m_intDuracao = intDuracao;
        this.m_dblCusto = dblCusto;
        this.m_oCategoria = oCategoria;

    }

    public boolean hasRefUnica(String otherRefUnica) {
        return m_strRefUnica.equalsIgnoreCase(otherRefUnica);
    }

    public String getRefUnica() {
        return m_strRefUnica;
    }

    public String getM_strRefUnica() {
        return m_strRefUnica;
    }

    public String getM_strDesignacao() {
        return m_strDesignacao;
    }

    public String getM_strDescInf() {
        return m_strDescInf;
    }

    public String getM_strDescTec() {
        return m_strDescTec;
    }

    public int getM_intDuracao() {
        return m_intDuracao;
    }

    public CategoriaTarefa getM_oCategoria() {
        return m_oCategoria;
    }

    public double getM_dblCusto() {
        return m_dblCusto;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.m_strRefUnica);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        // Inspirado em https://www.sitepoint.com/implement-javas-equals-method-correctly/

        // self check
        if (this == o) {
            return true;
        }
        // null check
        if (o == null) {
            return false;
        }
        // type check and cast
        if (getClass() != o.getClass()) {
            return false;
        }
        // field comparison
        Tarefa obj = (Tarefa) o;
        return (Objects.equals(m_strRefUnica, obj.m_strRefUnica));
    }

    @Override
    public String toString() {
        return String.format("-%s -%s -%s -%s -%s -%d  - Categoria de Tarefa: %s", this.m_strDescTec, this.m_strDescInf, this.m_strDesignacao, this.m_intDuracao, this.m_strRefUnica, this.m_dblCusto, this.m_oCategoria);
    }

}
