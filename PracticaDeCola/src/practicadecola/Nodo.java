package practicadecola;

public class Nodo {
    private Supermercado dato;
    private Nodo ps;

    public Nodo() {
        this.dato = dato;
        this.ps = null;
    }
    
    
    public Nodo(Supermercado e){
        dato = e;
        ps = null;
                       }

    public Supermercado getDato() {
        return dato;
    }

    public Nodo getPs() {
        return ps;
    }

    public void setDato(Supermercado dato) {
        this.dato = dato;
    }

    public void setPs(Nodo ps) {
        this.ps = ps;
    }

    
    
  
}
