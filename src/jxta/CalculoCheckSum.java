/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jxta;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Robson Gomes
 */
public class CalculoCheckSum {
    private long Resultado = 0;

    public CalculoCheckSum() {
    }

    public String getSumArquivo(File nomeArquivo)
    {
        try {
            CheckedInputStream checar = new CheckedInputStream(new FileInputStream(nomeArquivo), new Adler32());
            byte[] tempBuf = new byte[512];
            while (checar.read(tempBuf) >= 0) {
            }
            Resultado = checar.getChecksum().getValue();
            checar.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage(), "J'Books", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage(), "J'Books", JOptionPane.ERROR_MESSAGE);
        }
        return Long.toHexString(Resultado);
    }
}
