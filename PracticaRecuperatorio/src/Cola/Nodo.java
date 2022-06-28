package Cola;

public class Nodo {
    private Conductor dato;
    private Nodo ps;

    public Nodo(Conductor dato) {
        this.dato = dato;
    }

    public Conductor getDato() {
        return dato;
    }

    public void setDato(Conductor dato) {
        this.dato = dato;
    }

    public Nodo getPs() {
        return ps;
    }

    public void setPs(Nodo ps) {
        this.ps = ps;
    }
    
    
}
