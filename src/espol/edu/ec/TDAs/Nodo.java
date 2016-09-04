/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.TDAs;

/**
 *
 * @author Administrador
 */
public class Nodo {
    private Info info;
    public Nodo izquierdo,derecho;

    public Nodo(Info info) {
        this.info = info;
        this.derecho=null;
        this.izquierdo=null;
    }

    public Nodo(Info info, Nodo izquierdo, Nodo derecho) {
        this.info = info;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    
    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }
    public String toString(){
        return this.izquierdo.info+""+this.derecho.info;
    }
}
