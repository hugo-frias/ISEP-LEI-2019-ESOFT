/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import pt.ipp.isep.dei.esoft.pot.ui.console.registos.RegistoTarefas;

/**
 *
 * @author paulomaio
 */
public class Organizacao {

    private String m_strNome;
    private String m_strNIF;
    private EnderecoPostal m_oEnderecoPostal;
    private String m_strWebsite;
    private String m_strTelefone;
    private String m_strEmail;
    private Colaborador m_oGestor;
    private Anuncio m_anuncio;
    private Set<Colaborador> m_lstColaboradores = new HashSet<Colaborador>();
    private RegistoTarefas listaTarefas;
    private Anuncio listaAnuncio;
    
    

    public Organizacao(String strNome, String strNIF, String strWebsite, String strTelefone,
            String strEmail, EnderecoPostal oMorada, Colaborador oColaborador) {
        if ((strNome == null) || (strNIF == null) || (strTelefone == null)
                || (strEmail == null) || (oMorada == null) || (oColaborador == null)
                || (strNome.isEmpty()) || (strNIF.isEmpty()) || (strTelefone.isEmpty())
                || (strEmail.isEmpty())) {
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        }

        this.m_strNome = strNome;
        this.m_strNIF = strNIF;
        this.m_oEnderecoPostal = oMorada;
        this.m_strWebsite = strWebsite;
        this.m_strTelefone = strTelefone;
        this.m_strEmail = strEmail;
        this.m_oGestor = oColaborador;
        this.m_lstColaboradores.add(oColaborador);
        this.listaTarefas = new RegistoTarefas();
    }

    public Colaborador getGestor() {
        return this.m_oGestor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.m_strNIF);
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
        Organizacao obj = (Organizacao) o;
        return (Objects.equals(m_strNIF, obj.m_strNIF));
    }

    @Override
    public String toString() {
        String str = String.format("%s - %s - %s - %s - %s - %s - %s", this.m_strNome, this.m_strNIF, this.m_strWebsite, this.m_strTelefone, this.m_strEmail, this.m_oEnderecoPostal.toString(), this.m_oGestor.toString());
        return str;
    }

    public static Colaborador novoColaborador(String strNome, String strFuncao, String strTelefone, String strEmail) {
        return new Colaborador(strNome, strFuncao, strTelefone, strEmail);
    }

    public static EnderecoPostal novoEnderecoPostal(String strLocal, String strCodPostal, String strLocalidade) {
        return new EnderecoPostal(strLocal, strCodPostal, strLocalidade);
    }

    public Tarefa novaTarefa(String refUnica, String designacao, String descInf, String descTec, int duracao, CategoriaTarefa categoria, double custo) {
        return new Tarefa(refUnica, designacao, descInf, descTec, duracao, categoria, custo);
    }

    public boolean registaTarefa(Tarefa oTarefa) {
        if (this.validaTarefa(oTarefa)) {
            return addTarefa(oTarefa);
        }
        return false;
    }

    private boolean addTarefa(Tarefa oTarefa) {
        return listaTarefas.addTarefa(oTarefa);
    }

    public boolean validaTarefa(Tarefa oTarefa) {
        boolean bRet = true;

        // Escrever aqui o código de validação
        //
        return bRet;
    }

    public Tarefa getTarefaByRefUnica(String refUnica) {
        for (Tarefa tarefa : this.listaTarefas.getListaTarefas()) {
            if (tarefa.hasRefUnica(refUnica)) {
                return tarefa;
            }
        }

        return null;
    }

    public Set<Colaborador> getM_lstColaboradores() {
        return m_lstColaboradores;
    }

    public Colaborador getColaboradorByEmail(String email) {
        for (Colaborador Colaborador : this.m_lstColaboradores) {
            if (Colaborador.getEmail().equals(email)) {
                return Colaborador;
            }
        }
        return null;
    }

    public boolean validaAnuncio(Anuncio m_anuncio) {
        boolean bRet = true;

        // Escrever aqui o código de validação
        //
        return bRet;
    }
    

    public boolean registaAnuncio(Anuncio m_anuncio) {
        //codigo em falta
        return false;
    }

}
