package moverdelseoalse;

public class Nodo {
    private Datos dato;
    private Nodo ps;

    public Nodo(Datos dato) {
        this.dato = dato;
    }

    public Datos getDato() {
        return dato;
    }

    public void setDato(Datos dato) {
        this.dato = dato;
    }

    public Nodo getPs() {
        return ps;
    }

    public void setPs(Nodo ps) {
        this.ps = ps;
    }
    
    
}
