package LSE;

public class NodoLista{
    private Suscripcion dato;
    private NodoLista ps;
    
    public NodoLista(Suscripcion dato) {
        this.dato = dato;
    }

    public Suscripcion getDato() {
        return dato;
    }

    public void setDato(Suscripcion dato) {
        this.dato = dato;
    }

    public NodoLista getPs() {
        return ps;
    }

    public void setPs(NodoLista ps) {
        this.ps = ps;
    }  

}
