/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.TDAs;

import java.util.Comparator;
import java.util.*;

/**
 *
 * @author Administrador
 */
public class ArbolHuffman {

    private Nodo raiz;
    private Comparator f;

    public ArbolHuffman() {

        this.raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public ArbolHuffman calcularArbol(HashMap<String, Integer> mapa) {
        ArbolHuffman arbol = new ArbolHuffman();
        PriorityQueue<Nodo> cola;
        cola = new PriorityQueue<>(10, (Nodo n1, Nodo n2) -> n1.getInfo().getFrecuencia() - n2.getInfo().getFrecuencia());
        int tamano = mapa.size();
        if (tamano > 0) {
            mapa.keySet().stream().map((caracter) -> new Nodo(new Info(caracter, mapa.get(caracter)))).forEach((n) -> {
                cola.offer(n);
            });
            while (cola.size() > 1) {
                Nodo izquierdo = cola.poll(); //saco los 2 nodos de menor frecuencia
                Nodo derecho = cola.poll();
                izquierdo.getInfo().setBit(0); //bit 0 para el nodo izquierdo de menor frecuencia que el derecho
                derecho.getInfo().setBit(1); //bit 1 para el nodo derecho
                String nuevacadena = derecho.getInfo().getCadena() + izquierdo.getInfo().getCadena(); //uno ambas cadenas de cada nodo
                int frec = derecho.getInfo().getFrecuencia() + izquierdo.getInfo().getFrecuencia(); //sumo las frecuencias de los nodos
                Info info = new Info(nuevacadena, frec); //creo el nodo fusionado
                Nodo nuevoNodo = new Nodo(info);
                nuevoNodo.setDerecho(derecho);
                nuevoNodo.setIzquierdo(izquierdo);
                cola.offer(nuevoNodo);
            }
            arbol.setRaiz(cola.poll());
        }
        return arbol;
    }
    public HashMap<String,String> calcularCodigos (){
        HashMap<String,String> resultado= new HashMap<>();
        Nodo n;
        
        return resultado;
    }
}
