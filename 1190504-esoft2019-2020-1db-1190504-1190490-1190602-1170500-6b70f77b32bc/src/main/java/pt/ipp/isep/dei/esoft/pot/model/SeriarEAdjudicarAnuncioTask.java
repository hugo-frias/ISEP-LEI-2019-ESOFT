/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.model;

import java.util.List;
import java.util.TimerTask;
import pt.ipp.isep.dei.esoft.pot.controller.AplicacaoPOT;

/**
 *
 * @author Utilizador
 */
public class SeriarEAdjudicarAnuncioTask  extends TimerTask {
    private Plataforma plataforma;
    public SeriarEAdjudicarAnuncioTask(Plataforma plataforma) {
        this.plataforma = plataforma;
    }
    @Override
    public  void run()  {
        this.seriarEadjudicarAnuncio();
    }
    private  void seriarEadjudicarAnuncio()  {
        plataforma = AplicacaoPOT.getInstance().getPlataforma();
        List<Anuncio> lstAnun = plataforma.getRegistoAnuncio().getListaAnunciosSeriacaoAutomatica();
        for (Anuncio anun : lstAnun) {
            List<Candidatura> lstCand = anun.getRegimento().seriar(anun.getListaCandidaturas());
            Seriacao serAutomatica = new SeriacaoAutomatica(lstCand,anun.getRegimento());
            anun.setSeriacao(serAutomatica);
            plataforma.getRegistoAnuncio().novaAdjudicacao(anun);
            
        }
    }
}
