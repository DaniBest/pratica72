/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.ct.dainf.if62c.pratica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;
import static java.lang.System.*;

/**
 *
 * @author DANIEL
 */
public class ContadorPalavras {

    private BufferedReader reader;
    
    public ContadorPalavras() {
        
    }
    
    public ContadorPalavras(String st) {
        try {
            reader = new BufferedReader(new FileReader(new File(st)));
        } catch (IOException ioe) {

        }
    }

    public ContadorPalavras(File fl) {
        try {
            reader = new BufferedReader(new FileReader(fl));
        } catch (IOException ioe) {

        }
    }

    public HashMap<String, Integer> getPalavras() {
        HashMap<String, Integer> mapaRetornado = null;
        Scanner leitor = new Scanner(reader);
//        Pattern p = Pattern.compile("\\W");
        leitor.useDelimiter("\\W");
        String atual;
        Integer um = 1;
        Integer valor;
        while(leitor.hasNext()) {
            atual=leitor.next();
            if(mapaRetornado.containsKey(atual)) {
                valor = mapaRetornado.get(atual);
                valor = valor + 1;
                mapaRetornado.replace(atual, valor);
            }else {
                mapaRetornado.put(atual, um);
            }
        }
        
        
        
        try {
            reader.close();
        }catch (IOException ioe) {

        }
        return mapaRetornado;
    }

    public BufferedReader getReader() {
        return reader;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    
}
