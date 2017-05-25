/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jxta;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.util.Enumeration;
import javax.swing.JOptionPane;
import net.jxta.credential.AuthenticationCredential;
import net.jxta.credential.Credential;
import net.jxta.discovery.DiscoveryService;
import net.jxta.document.MimeMediaType;
import net.jxta.document.StructuredDocument;
import net.jxta.document.StructuredTextDocument;
import net.jxta.exception.PeerGroupException;
import net.jxta.id.IDFactory;
import net.jxta.membership.Authenticator;
import net.jxta.membership.MembershipService;
import net.jxta.peergroup.PeerGroup;
import net.jxta.peergroup.PeerGroupFactory;
import net.jxta.peergroup.PeerGroupID;
import net.jxta.protocol.ModuleImplAdvertisement;
import net.jxta.protocol.PeerGroupAdvertisement;

/**
 *
 * @author Robson Gomes
 */
public class IniciarJXTA {
    private final static int tempoEsgotado = 5 * 1000;
    private PeerGroup grupoPeersNet, grupoSD;
    DiscoveryService minhaDescobertaServico, grupoSDDescobertaServico;
    PeerGroupAdvertisement grupoSistemaDistribuidosAdv;
    private final String stringID = "jxta:uuid-4E0742B0E54F4D0ABAC6809BB82A311E02";

    public IniciarJXTA() {
        iniciaJXTA();
        getServicos();
        pesquisaParaGrupo();
    }

    private void iniciaJXTA() {
        try {
            grupoPeersNet = PeerGroupFactory.newNetPeerGroup();
        } catch (PeerGroupException ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage(), "JArticles", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
    }

    private void getServicos() {
        minhaDescobertaServico = grupoPeersNet.getDiscoveryService();
    }

    private void pesquisaParaGrupo() {
        Enumeration adv = null;
        int count = 0;
        while (count < 5) {
            try {
                adv = minhaDescobertaServico.getLocalAdvertisements(DiscoveryService.GROUP, "Name", "GrupoSD");
                if ((adv != null) && adv.hasMoreElements()) {
                    grupoSistemaDistribuidosAdv = (PeerGroupAdvertisement) adv.nextElement();
                    grupoSD = grupoPeersNet.newGroup(grupoSistemaDistribuidosAdv);
                    juntarAoGrupo(grupoSD);
                    break;
                } else {
                    minhaDescobertaServico.getRemoteAdvertisements(null, DiscoveryService.GROUP, "Name", "GrupoSD", 1);
                }
                Thread.sleep(tempoEsgotado);
                if ((count == 4) && (adv == null || !adv.hasMoreElements())) {
                    grupoSD = criaGrupo();
                    juntarAoGrupo(grupoSD);
                    break;
                }
            } catch (IOException | InterruptedException ex) {
                JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage(), "JArticles", JOptionPane.ERROR_MESSAGE);
            } catch (PeerGroupException ex) {
                JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage(), "JArticles", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
            }
            count++;
        }
    }

    private PeerGroup criaGrupo() {
        PeerGroup myNewGroup = null;
        try {
            ModuleImplAdvertisement myMIA = grupoPeersNet.getAllPurposePeerGroupImplAdvertisement();
            myNewGroup = grupoPeersNet.newGroup(getGID(), myMIA, "GrupoSD", "Sistema Distribuidos - Aplicação em P2P para compartilhamento de arquivos");
            grupoSistemaDistribuidosAdv = myNewGroup.getPeerGroupAdvertisement();
            minhaDescobertaServico.publish(grupoSistemaDistribuidosAdv);
            minhaDescobertaServico.remotePublish(grupoSistemaDistribuidosAdv);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage(), "JArticles", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
        return myNewGroup;
    }

    private PeerGroupID getGID() throws Exception {
        return (PeerGroupID) IDFactory.fromURL(new URL("urn", "", stringID));
    }

    private void juntarAoGrupo(PeerGroup group) {
        StructuredDocument credencial = null;
        try {
            AuthenticationCredential authCred = new AuthenticationCredential(group, null, credencial);
            MembershipService membership = group.getMembershipService();
            Authenticator auth = membership.apply(authCred);
            if (auth.isReadyForJoin()) {
                Credential myCred = membership.join(auth);
                StructuredTextDocument doc = (StructuredTextDocument) myCred.getDocument(new MimeMediaType("text/plain"));
                StringWriter out = new StringWriter();
                doc.sendToWriter(out);
                System.out.println(out.toString());
                grupoSDDescobertaServico = group.getDiscoveryService();
                grupoSDDescobertaServico.publish(group.getPeerAdvertisement());
                grupoSDDescobertaServico.remotePublish(group.getPeerAdvertisement());
            } else {
                System.exit(-1);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage(), "JArticles", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
    }

    public PeerGroup getGrupoSistemaDistribuidos() {
        return grupoSD;
    }

    public PeerGroupAdvertisement getGrupoSistemaDistribuidoAdv() {
        return grupoSistemaDistribuidosAdv;
    }
}
