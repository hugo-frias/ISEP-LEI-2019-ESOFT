/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.ipp.isep.dei.esoft.pot.model.AreaAtividade;
import pt.ipp.isep.dei.esoft.pot.model.Constantes;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;
import pt.ipp.isep.dei.esoft.pot.model.CompetenciaTecnica;
import pt.ipp.isep.dei.esoft.pot.ui.console.registos.RegistoCompetenciaTecnica;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

/**
 *
 * @author paulomaio
 */
public class EspecificarCompetenciaTecnicaController
{
    private Plataforma m_oPlataforma;
    private CompetenciaTecnica m_oCompetencia;
    public EspecificarCompetenciaTecnicaController()
    {
        if(!AplicacaoPOT.getInstance().getSessaoAtual().isLoggedInComPapel(Constantes.PAPEL_ADMINISTRATIVO))
            throw new IllegalStateException("Utilizador não Autorizado");
        this.m_oPlataforma = AplicacaoPOT.getInstance().getPlataforma();
    }
    
    public List<AreaAtividade> getAreasAtividade()
    {
        return this.m_oPlataforma.getRegistoAreasAtividade().getListaAreaAtividade();
    }
    
    public boolean novaCompetenciaTecnica(String id, String descB, String descD, String area)
    {
        try
        {
            AreaAtividade areaAt = this.m_oPlataforma.getRegistoAreasAtividade().getAreaByCod(area);
            this.m_oCompetencia = this.m_oPlataforma.getRegistoCompetenciaTecnica().novaCompetenciaTecnica(id, descB, descD, areaAt);
            return this.m_oPlataforma.getRegistoCompetenciaTecnica().validaCompetenciaTecnica(this.m_oCompetencia);
            
        }
        catch(RuntimeException ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.m_oCompetencia = null;
            return false;
        }
    }
   
    public void addGrauProficiencia(String grau, String designacao,CompetenciaTecnica compTec){
        m_oPlataforma.getRegistoCompetenciaTecnica().addGrauProficiencia(grau, designacao, compTec);
    }
    
    public boolean registaCompetenciaTecnica()
    {
        return this.m_oPlataforma.getRegistoCompetenciaTecnica().registaCT(this.m_oCompetencia);
    }

    public String getCompetenciaTecnicaString()
    {
        return this.m_oCompetencia.toString();
    }
}
