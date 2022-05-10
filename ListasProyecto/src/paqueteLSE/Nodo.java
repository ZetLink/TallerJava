package paqueteLSE;

public class Nodo {
    private int dato;
    private Nodo ps; // referencia a tipo Nodo

    public Nodo(int elem) {
        dato = elem;
        ps = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getPs() {
        return ps;
    }

    public void setPs(Nodo ps) {
        this.ps = ps;
    }
}