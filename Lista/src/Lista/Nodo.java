package Lista;

public class Nodo {
    private Dato dato;
    private Nodo ps;
    
    public Nodo(Dato dato) {
        this.dato = dato;
    }

    public Dato getDato() {
        return dato;
    }

    public void setDato(Dato dato) {
        this.dato = dato;
    }

    public Nodo getPs() {
        return ps;
    }

    public void setPs(Nodo ps) {
        this.ps = ps;
    }   
}