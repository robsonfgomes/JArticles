/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jxta;

import java.io.File;
import javax.swing.JProgressBar;
import net.jxta.peergroup.PeerGroup;
import net.jxta.share.ContentAdvertisement;
import net.jxta.share.client.GetContentRequest;

/**
 *
 * @author Robson Gomes
 */
public class DownloadArquivo extends Thread {
    private final PeerGroup grupoSistemaInformacao = null;
    protected GetRemoteFile meuDownload = null;

    public DownloadArquivo(PeerGroup grupo, ContentAdvertisement conteudoAdv, File destino, JProgressBar progresso) {
        meuDownload = new GetRemoteFile(grupo, conteudoAdv, destino, progresso);
    }
}

class GetRemoteFile extends GetContentRequest {

    private JProgressBar BarraDeProgresso = null;
    private boolean DownloadConcluido = false;

    public GetRemoteFile(PeerGroup grupo, ContentAdvertisement conteudoAdv, File destino, JProgressBar progresso) {
        super(grupo, conteudoAdv, destino);
        this.BarraDeProgresso = progresso;
    }

    @Override
    public void notifyUpdate(int porcentagem) {
        BarraDeProgresso.setValue(porcentagem);
    }

    @Override
    public void notifyDone() {

    }

    @Override
    public void notifyFailure() {

    }
}
