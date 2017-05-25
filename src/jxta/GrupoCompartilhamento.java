/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jxta;

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import net.jxta.exception.PeerGroupException;
import net.jxta.peergroup.PeerGroup;
import net.jxta.share.CMS;
import net.jxta.share.Content;
import net.jxta.share.ContentManager;
import net.jxta.share.SearchListener;

/**
 *
 * @author Robson Gomes
 */
public class GrupoCompartilhamento extends Thread implements SearchListener {
    private PeerGroup Grupo = null;

    private File MeuCaminho = null;
    private CMS cms = null;

    public GrupoCompartilhamento(PeerGroup grupo, File caminho) {
        this.Grupo = grupo;
        this.MeuCaminho = caminho;
        IniciarCMS();
    }

    private void IniciarCMS() {
        cms = new CMS();
        try {
            cms.init(Grupo, null, null);
            if (cms.startApp(MeuCaminho) == -1) {
                System.exit(-1);
            }
            ContentManager contentManager = cms.getContentManager();
            File[] listaArquivos = MeuCaminho.listFiles();
            CalculoCheckSum checkSum = new CalculoCheckSum();
            for (File l : listaArquivos) {
                if (l.isFile()) {
                    contentManager.share(l, checkSum.getSumArquivo(l));
                }
            }
            Content[] content = cms.getContentManager().getContent();
        } catch (PeerGroupException ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage(), "JArticles", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage(), "JArticles", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void PararCMS() {
        cms.stopApp();
        File temp = new File(MeuCaminho.getAbsolutePath() + File.separator + "shares.ser");
        if (temp.delete()) {}
    }

    @Override
    public void queryReceived(String query) {
        
    }
}
