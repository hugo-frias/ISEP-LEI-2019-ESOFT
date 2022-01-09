/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author paulomaio
 */
public class CompetenciaTecnica {

    private String m_strId;
    private String m_strDescricaoBreve;
    private String m_strDescricaoDetalhada;
    private AreaAtividade m_oAreaAtividade;
    private ArrayList<GrauProficiencia> m_grausProficiencia;

    public CompetenciaTecnica(String strId, String strDescricaoBreve, String strDescricaoDetalhada, AreaAtividade oArea) {
        if ((strId == null) || (strDescricaoBreve == null) || (strDescricaoDetalhada == null)
                || (oArea == null) || (strId.isEmpty()) || (strDescricaoBreve.isEmpty()) || (strDescricaoDetalhada.isEmpty())) {
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        }

        this.m_strId = strId;
        this.m_strDescricaoBreve = strDescricaoBreve;
        this.m_strDescricaoDetalhada = strDescricaoDetalhada;
        m_oAreaAtividade = oArea;
        this.m_grausProficiencia = new ArrayList<>();
    }



    public String getM_strId() {
        return m_strId;
    }

    public void setM_strId(String m_strId) {
        this.m_strId = m_strId;
    }

    public String getM_strDescricaoBreve() {
        return m_strDescricaoBreve;
    }

    public void setM_strDescricaoBreve(String m_strDescricaoBreve) {
        this.m_strDescricaoBreve = m_strDescricaoBreve;
    }

    public String getM_strDescricaoDetalhada() {
        return m_strDescricaoDetalhada;
    }

    public void setM_strDescricaoDetalhada(String m_strDescricaoDetalhada) {
        this.m_strDescricaoDetalhada = m_strDescricaoDetalhada;
    }

    public AreaAtividade getM_oAreaAtividade() {
        return m_oAreaAtividade;
    }

    public void setM_oAreaAtividade(AreaAtividade m_oAreaAtividade) {
        this.m_oAreaAtividade = m_oAreaAtividade;
    }


    
    public boolean hasId(String strId) {
        return this.m_strId.equalsIgnoreCase(strId);
    }

    public String getId() {
        return m_strId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.m_strId);
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
        CompetenciaTecnica obj = (CompetenciaTecnica) o;
        return (Objects.equals(m_strId, obj.m_strId));
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s  - Área Atividade: %s", this.m_strId, this.m_strDescricaoBreve, this.m_strDescricaoDetalhada, this.m_oAreaAtividade.toString());
    }

    public void addGrauProficiencia(GrauProficiencia grauProf) {
        m_grausProficiencia.add(grauProf);
    }

}
