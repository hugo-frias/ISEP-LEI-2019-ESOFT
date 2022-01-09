/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import pt.ipp.isep.dei.esoft.pot.ui.console.registos.RegistoAdjudicacao;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import pt.ipp.isep.dei.esoft.autorizacao.AutorizacaoFacade;
import pt.ipp.isep.dei.esoft.pot.ui.console.registos.RegistoAnuncio;
import pt.ipp.isep.dei.esoft.pot.ui.console.registos.RegistoAreasAtividade;
import pt.ipp.isep.dei.esoft.pot.ui.console.registos.RegistoCandidatura;
import pt.ipp.isep.dei.esoft.pot.ui.console.registos.RegistoCategoriaTarefa;
import pt.ipp.isep.dei.esoft.pot.ui.console.registos.RegistoColaborador;
import pt.ipp.isep.dei.esoft.pot.ui.console.registos.RegistoCompetenciaTecnica;
import pt.ipp.isep.dei.esoft.pot.ui.console.registos.RegistoFreelancer;
import pt.ipp.isep.dei.esoft.pot.ui.console.registos.RegistoHabilitacaoAcademica;
import pt.ipp.isep.dei.esoft.pot.ui.console.registos.RegistoOrganizacao;
import pt.ipp.isep.dei.esoft.pot.ui.console.registos.RegistoReconhecimento;
import pt.ipp.isep.dei.esoft.pot.ui.console.registos.RegistoSeriacao;
import pt.ipp.isep.dei.esoft.pot.ui.console.registos.RegistoTarefas;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Plataforma {

    private String m_strDesignacao;
    private final AutorizacaoFacade m_oAutorizacao;
    private Timer timer;

    private RegistoCompetenciaTecnica registoCompetenciaTecnica;
    private RegistoAreasAtividade registoAreasAtividade;
    private RegistoColaborador registoColaborador;
    private RegistoOrganizacao registoOrganizacao;
    private RegistoReconhecimento registoReconhecimento;
    private RegistoFreelancer registoFreelancer;
    private RegistoHabilitacaoAcademica registoHabilitacaoAcademica;
    private RegistoTarefas registoTarefas;
    private RegistoSeriacao registoSeriacao;
    private RegistoCandidatura registoCandidatura;
    private RegistoCategoriaTarefa registoCategoriaTarefa;
    private RegistoAnuncio registoAnuncio;
    private RegistoAdjudicacao registoAdjudicacao;
    private RegistoCompetenciaTecnica regCt;
    private SeriarEAdjudicarAnuncioTask seriarEAdjudicarAnuncioTask; 
  

    public Plataforma(String strDesignacao) {
        if ((strDesignacao == null)
                || (strDesignacao.isEmpty())) {
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        }

        this.m_strDesignacao = strDesignacao;

        this.m_oAutorizacao = new AutorizacaoFacade();
        this.registoCompetenciaTecnica = new RegistoCompetenciaTecnica();
        this.registoAreasAtividade = new RegistoAreasAtividade();
        this.registoColaborador = new RegistoColaborador();
        this.registoOrganizacao = new RegistoOrganizacao();
        this.registoReconhecimento = new RegistoReconhecimento();
        this.registoFreelancer = new RegistoFreelancer();
        this.registoTarefas = new RegistoTarefas();
        this.registoSeriacao = new RegistoSeriacao();
        this.registoHabilitacaoAcademica = new RegistoHabilitacaoAcademica();
        this.registoAnuncio = new RegistoAnuncio();
        this.registoAdjudicacao = new RegistoAdjudicacao();
        this.regCt = new RegistoCompetenciaTecnica();
        this.seriarEAdjudicarAnuncioTask = new SeriarEAdjudicarAnuncioTask(this);
        timer.schedule(seriarEAdjudicarAnuncioTask, 100000, 86400000);

    }

    public RegistoAnuncio getRegistoAnuncio() {
        return registoAnuncio;
    }

    public void setRegistoAnuncio(RegistoAnuncio registoAnuncio) {
        this.registoAnuncio = registoAnuncio;
    }

    public RegistoReconhecimento getRegistoReconhecimento() {
        return registoReconhecimento;
    }

    public void setRegistoReconhecimento(RegistoReconhecimento registoReconhecimento) {
        this.registoReconhecimento = registoReconhecimento;
    }

    public RegistoFreelancer getRegistoFreelancer() {
        return registoFreelancer;
    }

    public void setRegistoFreelancer(RegistoFreelancer registoFreelancer) {
        this.registoFreelancer = registoFreelancer;
    }

    public RegistoHabilitacaoAcademica getRegistoHabilitacaoAcademica() {
        return registoHabilitacaoAcademica;
    }

    public void setRegistoHabilitacaoAcademica(RegistoHabilitacaoAcademica registoHabilitacaoAcademica) {
        this.registoHabilitacaoAcademica = registoHabilitacaoAcademica;
    }

    public String getM_strDesignacao() {
        return m_strDesignacao;
    }

    public void setM_strDesignacao(String m_strDesignacao) {
        this.m_strDesignacao = m_strDesignacao;
    }

    public RegistoCompetenciaTecnica getRegistoCompetenciaTecnica() {
        return registoCompetenciaTecnica;
    }

    public void setRegistoCompetenciaTecnica(RegistoCompetenciaTecnica registoCompetenciaTecnica) {
        this.registoCompetenciaTecnica = registoCompetenciaTecnica;
    }

    public RegistoAreasAtividade getRegistoAreasAtividade() {
        return registoAreasAtividade;
    }

    public void setRegistoAreasAtividade(RegistoAreasAtividade registoAreasAtividade) {
        this.registoAreasAtividade = registoAreasAtividade;
    }

    public RegistoColaborador getRegistoColaborador() {
        return registoColaborador;
    }

    public void setRegistoColaborador(RegistoColaborador registoColaborador) {
        this.registoColaborador = registoColaborador;
    }

    public RegistoOrganizacao getRegistoOrganizacao() {
        return registoOrganizacao;
    }

    public void setRegistoOrganizacao(RegistoOrganizacao registoOrganizacao) {
        this.registoOrganizacao = registoOrganizacao;
    }

    public AutorizacaoFacade getAutorizacaoFacade() {
        return this.m_oAutorizacao;
    }

    public RegistoTarefas getRegistoTarefas() {
        return registoTarefas;
    }

    public void setRegistoTarefas(RegistoTarefas registoTarefas) {
        this.registoTarefas = registoTarefas;
    }

    public RegistoSeriacao getRegistoSeriacao() {
        return registoSeriacao;
    }

    public void setRegistoSeriacao(RegistoSeriacao registoSeriacao) {
        this.registoSeriacao = registoSeriacao;
    }

    public RegistoCandidatura getRegistoCandidatura() {
        return registoCandidatura;
    }

    public void setRegistoCandidatura(RegistoCandidatura registoCandidatura) {
        this.registoCandidatura = registoCandidatura;
    }

    public RegistoCategoriaTarefa getRegistoCategoriaTarefa() {
        return registoCategoriaTarefa;
    }

    public void setRegistoCategoriaTarefa(RegistoCategoriaTarefa registoCategoriaTarefa) {
        this.registoCategoriaTarefa = registoCategoriaTarefa;
    }

    public static Anuncio novoAnuncio(String perPublicitacao, String perApresentacao, String perSeriacao, SeriacaoSubjetivaAtribuicaoOpcional Regimento) {
        return new Anuncio(perPublicitacao, perApresentacao, perSeriacao, Regimento);
    }

    public RegistoAdjudicacao getRegistoAdjudicacao() {
        return this.registoAdjudicacao;
    }

}
