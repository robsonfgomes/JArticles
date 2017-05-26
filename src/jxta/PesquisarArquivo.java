/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jxta;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.jxta.peergroup.PeerGroup;
import net.jxta.share.ContentAdvertisement;
import net.jxta.share.client.CachedListContentRequest;

/**
 *
 * @author Robson Gomes
 */
public class PesquisarArquivo extends Thread {

    private PeerGroup grupoSistemasDistribuidos = null;
    private final String pesquisaValor;
    protected ListaRequisicao solicitador;
    private final JTable tabela;
    public static ContentAdvertisement[] contents;
    private boolean funcionamento = true;

    public PesquisarArquivo(PeerGroup group, String searchKey, JTable table) {
        this.grupoSistemasDistribuidos = group;
        this.pesquisaValor = searchKey;
        this.tabela = table;
    }

    @Override
    public void run() {
        while (true) {
            if (funcionamento == false) {
                break;
            }
            solicitador = new ListaRequisicao(grupoSistemasDistribuidos, pesquisaValor, tabela);
            solicitador.activateRequest();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                stopThread();
            }
        }
    }

    public void stopThread() {
        funcionamento = false;
        if (solicitador != null) {
            solicitador.cancel();
        }
    }

    public void killThread() {
        funcionamento = false;
    }

    public ContentAdvertisement[] getContentAdvs() {
        return ListaRequisicao.resultadoPesquisa;
    }
}

class ListaRequisicao extends CachedListContentRequest {

    public static ContentAdvertisement[] resultadoPesquisa = null;   
    private final JTable tabela;

    public ListaRequisicao(PeerGroup grupo, String subStr, JTable tabela) {
        super(grupo, subStr);
        this.tabela = tabela;
    }

    @Override
    public void notifyMoreResults() {
        int countPDFs = 0;
        resultadoPesquisa = getResults();
        for(int i = 0; i < resultadoPesquisa.length; i++) {
            String extensao = resultadoPesquisa[i].getName().substring(resultadoPesquisa[i].getName().lastIndexOf("."), resultadoPesquisa[i].getName().length());            
            if(extensao.equalsIgnoreCase(".pdf")) {
                countPDFs++;
            }
        }
        //String[] titles = {"Nome do Arquivo", "Tamanho (Bytes)", "Check Sum (CRC-32)"};
        String[] titles = {"Nome do Arquivo"};
        DefaultTableModel TableModel = new DefaultTableModel(titles, countPDFs);
        tabela.setModel(TableModel);
        for (int i = 0; i < resultadoPesquisa.length; i++) {                       
            String extensao = resultadoPesquisa[i].getName().substring(resultadoPesquisa[i].getName().lastIndexOf("."), resultadoPesquisa[i].getName().length());            
            if(extensao.equalsIgnoreCase(".pdf")) {
                tabela.setValueAt(resultadoPesquisa[i].getName(), i, 0);
            }
            //tabela.setValueAt(resultadoPesquisa[i].getLength(), i, 1);
            //tabela.setValueAt(resultadoPesquisa[i].getDescription(), i, 2);
        }
    }

    public ContentAdvertisement[] getResultadoPesquisa() {
        return resultadoPesquisa;
    }
}
