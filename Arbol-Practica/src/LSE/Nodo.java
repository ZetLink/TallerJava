package LSE;

public class Nodo {
    private Informacion dato;
    private Nodo ps;
    
    public Nodo(Informacion dato) {
        this.dato = dato;
    }

    public Informacion getDato() {
        return dato;
    }

    public void setDato(Informacion dato) {
        this.dato = dato;
    }

    public Nodo getPs() {
        return ps;
    }

    public void setPs(Nodo ps) {
        this.ps = ps;
    }  
}
