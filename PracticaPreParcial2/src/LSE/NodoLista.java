package LSE;

public class NodoLista{
    private Reclamos dato;
    private NodoLista ps;
    
    public NodoLista(Reclamos dato) {
        this.dato = dato;
    }

    public Reclamos getDato() {
        return dato;
    }

    public void setDato(Reclamos dato) {
        this.dato = dato;
    }

    public NodoLista getPs() {
        return ps;
    }

    public void setPs(NodoLista ps) {
        this.ps = ps;
    }  

}
