/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.TDAs;

import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class Util {

    public static HashMap<String, Integer> calcularFrecuencias(String texto) {
        HashMap<String, Integer> frecuencias = new HashMap<>();
        int tam = texto.length();
        if (tam > 0) {
            for (int i = 1; i < tam; i++) {
                String letra = texto.substring(i - 1, i);
                if (!frecuencias.containsKey(letra)) {
                    frecuencias.put(letra, 1);
                } else {
                    frecuencias.put(letra, frecuencias.get(letra) + 1);
                }
            }
        }
        return frecuencias;
    }

    public static String hexadecimalBinario(String texto) {
        String convertido = "";
        String bloque = "";
        String[] arreglo = texto.split(" ");
        int tam = arreglo.length;
        for (int i = 0; i < tam; i++) {
            if (!arreglo[i].equals("-")) {
                bloque = new BigInteger(arreglo[i], 16).toString(2);
                while (bloque.length() < 4) {
                    bloque = "0" + bloque;
                }
                convertido += bloque + " ";
            }
            else{
                convertido=convertido.trim();
                convertido=convertido.substring(0, convertido.length()-1);
            }

        }
        return convertido;
    }
    public static HashMap<String,String> leerMapa (String nombreArchivo){
        BufferedReader br=null;
        try {
            HashMap<String,String> mapaCaracteres=new HashMap<>();
            File f= new File(nombreArchivo);
            br = new BufferedReader(new FileReader(f));
            String linea="";
            while((linea=br.readLine())!=null){
                String[] datos=linea.split(":");
                mapaCaracteres.put(datos[0], datos[1]);
            }
            return mapaCaracteres;
        } catch (Exception ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
        
    }
}
