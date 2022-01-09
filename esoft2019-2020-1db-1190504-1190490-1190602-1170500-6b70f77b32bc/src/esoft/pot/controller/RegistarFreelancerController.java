/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.controller;

import java.util.Date;
import java.util.List;
import pt.ipp.isep.dei.esoft.pot.model.AlgoritmoGeradorPasswords;
import pt.ipp.isep.dei.esoft.pot.model.CompetenciaTecnica;
import pt.ipp.isep.dei.esoft.pot.model.EnderecoPostal;
import pt.ipp.isep.dei.esoft.pot.model.Freelancer;
import pt.ipp.isep.dei.esoft.pot.model.HabilitacaoAcademica;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;
import pt.ipp.isep.dei.esoft.pot.model.Reconhecimento;
import pt.ipp.isep.dei.esoft.pot.ui.console.registos.RegistoCompetenciaTecnica;
import pt.ipp.isep.dei.esoft.pot.ui.console.registos.RegistoFreelancer;
import pt.ipp.isep.dei.esoft.pot.ui.console.registos.RegistoHabilitacaoAcademica;
import pt.ipp.isep.dei.esoft.pot.ui.console.registos.RegistoReconhecimento;

/**
 *
 * @author Hugo
 */
public class RegistarFreelancerController {
    private Plataforma m_oPlataforma;
    private RegistoFreelancer registoFreelancer;
    private RegistoCompetenciaTecnica registoCompetenciaTecnica;
    private RegistoHabilitacaoAcademica registoHabilitacaoAcademica;
    private RegistoReconhecimento registoReconhecimento;
    private List<CompetenciaTecnica> listaCompTec;
    private Freelancer freel;
    private Reconhecimento re;

    public RegistarFreelancerController() {
        this.m_oPlataforma = AplicacaoPOT.getInstance().getPlataforma();
    }
    
    public void getRegistos(){
        registoFreelancer = m_oPlataforma.getRegistoFreelancer();
        registoCompetenciaTecnica = m_oPlataforma.getRegistoCompetenciaTecnica();
        registoHabilitacaoAcademica = m_oPlataforma.getRegistoHabilitacaoAcademica();
        registoReconhecimento = m_oPlataforma.getRegistoReconhecimento();
    }
    
    public void novoFreelancer(String nome, String nif, String endLocal, String endCodPostal, String endLocalidade, long tlf, String email){
        EnderecoPostal end = new EnderecoPostal(endLocal, endCodPostal, endLocalidade);
        freel = new Freelancer(nome, end, tlf, email);
        listaCompTec = registoCompetenciaTecnica.getListaCompetenciasTecnicas();
    }
    
    public void addNewHabilitacaoAcademica(String grau, String desCur, String inst, String media){
        HabilitacaoAcademica ha = new HabilitacaoAcademica(grau, desCur, inst, media);
        registoFreelancer.addHabilitacaoAcademica(ha,freel);
    }
    
    
    public void addNewReconhecimento(Date data){
        re = registoReconhecimento.addNewReconhecimento(data);

    }
    public void addCompetenciaTecnica(String compTecID){
        CompetenciaTecnica compTec = registoCompetenciaTecnica.getCompTecById();
        
    }
    
    public void addGrauProficiencia(String grau, String designacao, CompetenciaTecnica compTec){
        registoReconhecimento.addGrauProficienciaACompTec(grau, designacao,compTec, re);
    }
    
    public boolean registaFreelancer(){
        boolean status = true;
        registoFreelancer.addReconhecimento(re, freel);
        String nomeG = freel.getNome();
        String emailG = freel.getEmail();
        String password = AlgoritmoGeradorPasswords.geraPassword(nomeG,emailG);
        String[] array = {"Gestor", "Freelancer"};
        m_oPlataforma.getAutorizacaoFacade().registaUtilizadorComPapeis(nomeG, emailG, password, array);
        return status;
        
    }
}
