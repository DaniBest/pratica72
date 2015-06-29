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
        caminho=scanner.next();
        String caminhoChegada = caminho + ".out";
        
        File origem = new File(caminho);
        File destino = new File(caminhoChegada);
        ContadorPalavras cp = new ContadorPalavras(origem);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(destino));) {
            
        }
        
            
            
        catch(IOException ioe) {
            out.println("Erro: " + ioe.getLocalizedMessage());
        }
                
        mapa = cp.getPalavras();
        
    }
}
