/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.util.Objects;


/**
 *
 */
public class CategoriaTarefa {

    private String m_strId; 
    private String m_strDescriçao;
    private AreaAtividade m_oArea;
    private CompetenciaTecnica m_oCompetencia;

    public CategoriaTarefa(String strId, String strDescriçao, AreaAtividade oArea, CompetenciaTecnica oCompetencia) {
        if ((strId == null) || (strDescriçao == null) || (oArea == null) || (oCompetencia == null) 
                 || (strId.isEmpty()) || (strDescriçao.isEmpty())) {
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        }
        this.m_strId = strId;
        this.m_strDescriçao = strDescriçao;
        this.m_oArea = oArea;
        this.m_oCompetencia = oCompetencia;

    }

    public boolean hasId(String otherId) {
        return m_strId.equalsIgnoreCase(otherId);
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
        CategoriaTarefa obj = (CategoriaTarefa) o;
        return (Objects.equals(m_strId, obj.m_strId));
    }

    @Override
    public String toString() {
        return String.format("-%s -%s - Area de Atividade: %s - Competencia Tecnica: %s", this.m_strId, this.m_strDescriçao, this.m_oArea, this.m_oCompetencia);
    }

    
}
