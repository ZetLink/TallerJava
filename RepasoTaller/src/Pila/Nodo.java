package Pila;

public class Nodo {
    private Cargamento dato;
    private Nodo ps;

    public Nodo(Cargamento dato) {
        this.dato = dato;
    }

    public Cargamento getDato() {
        return dato;
    }

    public void setDato(Cargamento dato) {
        this.dato = dato;
    }

    public Nodo getPs() {
        return ps;
    }

    public void setPs(Nodo ps) {
        this.ps = ps;
    }
    
    
}
