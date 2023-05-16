package pila;

import datos.Practicos;

public class Nodo {
    private Practicos dato;
    private Nodo ps;

    public Nodo(Practicos dato) {
        this.dato = dato;
    }

    public Practicos getDato() {
        return dato;
    }

    public void setDato(Practicos dato) {
        this.dato = dato;
    }

    public Nodo getPs() {
        return ps;
    }

    public void setPs(Nodo ps) {
        this.ps = ps;
    }
}
