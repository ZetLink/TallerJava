package practicaautoasistida1;

public class Nodo {
    private Expediente dato;
    private Nodo ps;

    public Nodo(Expediente dato) {
        this.dato = dato;
        this.ps = null;
    }

    public Expediente getDato() {
        return dato;
    }

    public void setDato(Expediente dato) {
        this.dato = dato;
    }

    public Nodo getPs() {
        return ps;
    }

    public void setPs(Nodo ps) {
        this.ps = ps;
    }
    
    
    
    
}
