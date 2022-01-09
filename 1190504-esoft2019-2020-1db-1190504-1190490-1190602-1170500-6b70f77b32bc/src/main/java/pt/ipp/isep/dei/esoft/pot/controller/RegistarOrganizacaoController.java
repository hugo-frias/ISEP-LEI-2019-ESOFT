/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import pt.ipp.isep.dei.esoft.pot.model.Colaborador;
import pt.ipp.isep.dei.esoft.pot.model.Organizacao;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;
import pt.ipp.isep.dei.esoft.pot.model.EnderecoPostal;
import pt.ipp.isep.dei.esoft.pot.ui.console.registos.RegistoColaborador;
import pt.ipp.isep.dei.esoft.pot.ui.console.registos.RegistoOrganizacao;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

/**
 *
 * @author paulomaio
 */
public class RegistarOrganizacaoController
{
    private AplicacaoPOT m_oApp;
    private Plataforma m_oPlataforma;
    private Organizacao m_oOrganizacao;
    private String m_strPwd;
    private RegistoOrganizacao registoOrganizacao;
    private RegistoColaborador registoColaborador;
    private Colaborador colaborador;
    public RegistarOrganizacaoController()
    {
        this.m_oApp = AplicacaoPOT.getInstance();
        this.m_oPlataforma = m_oApp.getPlataforma();
    }

    public void getRegistoOrganizacao(){
        registoOrganizacao = m_oPlataforma.getRegistoOrganizacao();
        registoColaborador = m_oPlataforma.getRegistoColaborador();
    }
    
    public boolean novaOrganizacao(String strNome, String strNIF, String strWebsite, String strTelefone, 
            String strEmail, String strLocal, String strCodPostal, String strLocalidade,
            String strNomeGestor, String strFuncaoGestor, String strEmailGestor,  String strTelefoneGestor,String strPwd)
    {
        try
        {
            this.m_strPwd = strPwd;
            EnderecoPostal oMorada = registoOrganizacao.novoEndereco(strLocal, strCodPostal, strLocalidade);
            Colaborador colaborador = registoColaborador.novoColaborador(strNomeGestor, strFuncaoGestor, strTelefoneGestor, strEmailGestor);      
            this.m_oOrganizacao = registoOrganizacao.novaOrganizacao(strNome, strNIF, strWebsite,strTelefone, strEmail, oMorada, colaborador);
            return registoOrganizacao.validaOrganizacao(this.m_oOrganizacao, this.m_strPwd);
        }
        catch(RuntimeException ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.m_oOrganizacao = null;
            return false;
        }
    }
    
    
    public boolean registaOrganizacao()
    {
        return registoOrganizacao.registaOrganizacao(m_oOrganizacao, m_strPwd, colaborador, m_oPlataforma);
    }

    public String getOrganizacaoString()
    {
        return this.m_oOrganizacao.toString();
    }
}
