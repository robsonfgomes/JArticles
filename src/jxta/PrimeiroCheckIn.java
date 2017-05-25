package jxta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Robson Gomes
 */
public class PrimeiroCheckIn extends JFileChooser {

    private boolean primeiraVez = true;
    private String CaminhoCompartilhado = "desconhecido";

    public PrimeiroCheckIn() {
    }

    public void pesquisarArquivoConfiguracao() {
        File arquivoConfig = new File("config.ini");
        if (arquivoConfig.exists() && arquivoConfig.isFile()) {
            lerArquivoConfiguracao(arquivoConfig);
        } else {
            criarArquivoConfiguracao();
        }
    }

    public void lerArquivoConfiguracao(File arquivo) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(arquivo));
            String str, diretorio;
            int index;
            while ((str = in.readLine()) != null) {
                if (str.startsWith("SharedFolder")) {
                    index = str.indexOf("=");
                    diretorio = str.substring(index + 1);
                    File temp = new File(diretorio);
                    if (temp.exists()) {
                        CaminhoCompartilhado = temp.getAbsolutePath();
                    } else {
                        criarPastaCompartilhada(temp);
                    }
                }
            }
            in.close();

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage(), "JArticles", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage(), "JArticles", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void criarPastaCompartilhada(File caminho) {
        if (caminho.mkdir()) {
            CaminhoCompartilhado = caminho.getAbsolutePath();
        }
    }

    public void criarArquivoConfiguracao() {
        File config = new File("config.ini");
        String caminho = "C:\\JArticles";
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int retVal = chooser.showOpenDialog(this);
        if (retVal == JFileChooser.APPROVE_OPTION) {
            caminho = chooser.getSelectedFile().getAbsolutePath();
        }
        CaminhoCompartilhado = caminho;
        try {
            boolean success = config.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(config));
            if (success) {
                out.write("SharedFolder=" + caminho);
                out.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage(), "JArticles", JOptionPane.ERROR_MESSAGE);
        }
        lerArquivoConfiguracao(config);
    }

    public String getCaminhoCompartilhado() {
        return CaminhoCompartilhado;
    }

    public boolean ehPrimeiraVez() {
        File configFile = new File("config.ini");
        primeiraVez = !(configFile.exists() && configFile.isFile());
        return primeiraVez;
    }
}
