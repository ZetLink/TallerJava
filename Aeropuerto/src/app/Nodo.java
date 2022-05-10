package app;

public class Nodo {
    private Vuelos dato;
    private Nodo ps;

    public Nodo(Vuelos dato) {
        this.dato = dato;
    }

    public Vuelos getDato() {
        return dato;
    }

    public void setDato(Vuelos dato) {
        this.dato = dato;
    }

    public Nodo getPs() {
        return ps;
    }

    public void setPs(Nodo ps) {
        this.ps = ps;
    }
    
    
}
