/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.ui.console.registos;

import java.util.ArrayList;
import pt.ipp.isep.dei.esoft.autorizacao.AutorizacaoFacade;
import pt.ipp.isep.dei.esoft.pot.model.Colaborador;
import pt.ipp.isep.dei.esoft.pot.model.EnderecoPostal;
import pt.ipp.isep.dei.esoft.pot.model.Organizacao;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;

/**
 *
 * @author Hugo
 */
public class RegistoOrganizacao {

    private ArrayList<Organizacao> listaOrganizacao;

    public RegistoOrganizacao() {
        listaOrganizacao = new ArrayList<>();
    }

    public Organizacao novaOrganizacao(String nome, String NIFU, String site, String tlf, String email, EnderecoPostal morada, Colaborador colab) {
        Organizacao organizacao = new Organizacao(nome, NIFU, site, tlf, email, morada, colab);
        return organizacao;
    }

    public boolean validaOrganizacao(Organizacao org, String pwd) {
        boolean status = false;
        /*verificações*/
        return status;
    }

    public EnderecoPostal novoEndereco(String endLocal, String endCodPostal, String endLocalidade) {
        EnderecoPostal enderecoPostal = new EnderecoPostal(endLocal, endCodPostal, endLocalidade);
        return enderecoPostal;
    }

    public ArrayList<Organizacao> getListaOrganizacao() {
        return listaOrganizacao;
    }

    public void setListaOrganizacao(ArrayList<Organizacao> listaOrganizacao) {
        this.listaOrganizacao = listaOrganizacao;
    }

    public boolean registaOrganizacao(Organizacao m_oOrganizacao, String m_strPwd, Colaborador colab, Plataforma plataforma) {
        boolean status = validaOrganizacao(m_oOrganizacao, m_strPwd);
        String nomeG = colab.getNome();
        String emailG = colab.getEmail();
        String[] array = {"Gestor", "Colaborador"};
        plataforma.getAutorizacaoFacade().registaUtilizadorComPapeis(nomeG, emailG, m_strPwd, array);
        return status;
    }

    public Organizacao getOrganizacaoByEmailUtilizador(String email) {

        for (Organizacao organizacao : this.listaOrganizacao) {
            if (organizacao.getColaboradorByEmail(email).getEmail().equals(email)) {
                return organizacao;
            }
        }

        return null;

    }

    Organizacao getOrganizacaoByTarefa(String refUnica) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
