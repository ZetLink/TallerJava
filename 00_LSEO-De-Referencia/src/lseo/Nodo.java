package lseo;

import datos.Articulo;

public class Nodo {
    private Articulo dato;
    private Nodo ps;
    
    public Nodo(Articulo dato) {
        this.dato = dato;
    }

    public Articulo getDato() {
        return dato;
    }

    public void setDato(Articulo dato) {
        this.dato = dato;
    }

    public Nodo getPs() {
        return ps;
    }

    public void setPs(Nodo ps) {
        this.ps = ps;
    }
      
}