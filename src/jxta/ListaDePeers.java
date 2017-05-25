/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jxta;

import java.util.Enumeration;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import net.jxta.discovery.DiscoveryEvent;
import net.jxta.discovery.DiscoveryListener;
import net.jxta.discovery.DiscoveryService;
import net.jxta.peergroup.PeerGroup;
import net.jxta.protocol.DiscoveryResponseMsg;
import net.jxta.protocol.PeerAdvertisement;

/**
 *
 * @author Robson Gomes
 */
public class ListaDePeers extends Thread implements Runnable, DiscoveryListener {
    private PeerGroup grupoSistemasDistribuidos = null;
    private DiscoveryService minhaDescobertaDeServicos = null;
    private JList lista = null;
    public boolean fimPesquisa = false;
    DefaultListModel listaModel = new DefaultListModel();

    public ListaDePeers(PeerGroup group, JList list) {
        this.grupoSistemasDistribuidos = group;
        this.lista = list;
        this.minhaDescobertaDeServicos = grupoSistemasDistribuidos.getDiscoveryService();
    }

    @Override
    public void run() {
        while (true) {
            if (checarUltimaVez()) {
                break;
            }
            try {
                minhaDescobertaDeServicos.getRemoteAdvertisements(null, DiscoveryService.PEER, null, null, 5, this);
                listaModel.clear();
                Thread.sleep(1000);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage(), "JArticles", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean checarUltimaVez() {
        if (fimPesquisa == true) {
            return true;
        }
        return false;
    }

    public void setFimDaPesquisa(boolean value) {
        this.fimPesquisa = value;
    }

    private void atualizarListaDePeers(Vector minhaLista) {
        lista.setListData(minhaLista);
    }

    @Override
    public void discoveryEvent(DiscoveryEvent event) {
        DiscoveryResponseMsg res = event.getResponse();
        String nome = "desconhecido";
        PeerAdvertisement peerAdv = res.getPeerAdvertisement();
        if (peerAdv != null) {
            nome = peerAdv.getName();
        }
        PeerAdvertisement meuConteudo = null;
        Enumeration numeracao = res.getAdvertisements();
        Vector listaPeers = new Vector();
        if (numeracao != null) {
            while (numeracao.hasMoreElements()) {
                meuConteudo = (PeerAdvertisement) numeracao.nextElement();
                listaPeers.addElement(meuConteudo.getName());
            }
            atualizarListaDePeers(listaPeers);
        }
    }
}
