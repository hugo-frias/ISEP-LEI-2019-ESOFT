/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.util.List;

/**
 *
 * @author Utilizador
 */
public class SeriacaoAutomatica2PrecoMaisBaixo implements RegimentoAplicavel {

    String designacao;
    String regras;

    public SeriacaoAutomatica2PrecoMaisBaixo(String designacao, String regras) {
        this.designacao = designacao;
        this.regras = regras;
    }

    @Override
    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public String getRegras() {
        return regras;
    }

    public void setRegras(String regras) {
        this.regras = regras;
    }

    @Override
    public void seriar() {
    }

    @Override
    public List<Candidatura> seriar(List<Candidatura> lst) {
        return null;
    }


}
