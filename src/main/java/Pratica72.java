/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import utfpr.ct.dainf.if62c.pratica.ContadorPalavras;

/**
 *
 * @author DANIEL
 */
public class Pratica72 {

    public static void main(String[] args) {

        HashMap<String, Integer> mapa;

        Scanner scanner = new Scanner(in);
        String caminho;
        out.println("Digite o nome (caminho completo) de um arquivo de texto:");
        caminho = scanner.next();
        String caminhoChegada = caminho + ".out";

        File origem = new File(caminho);
        File destino = new File(caminhoChegada);
        ContadorPalavras cp = new ContadorPalavras(origem);
        mapa = cp.getPalavras();
        

        ArrayList<String> listaPalavras = new ArrayList<>(mapa.keySet());
        listaPalavras.sort(new Comparator<String>() {@Override
            public int compare(String o1, String o2) {
                return -mapa.get(o1).compareTo(mapa.get(o2));
            }
        });

        //String palavra;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(destino));) {
            destino.createNewFile();
            for(String palavra:listaPalavras) {
                bw.write(String.format("%s,%d", palavra, mapa.get(palavra)));
                bw.newLine();
            }
            

        } catch (IOException ioe) {
            out.println("Erro: " + ioe.getLocalizedMessage());
        }

    }
}
