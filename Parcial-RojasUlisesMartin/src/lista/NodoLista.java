package lista;

public class NodoLista{
    private Cliente dato;
    private NodoLista ps;
    
    public NodoLista(Cliente dato) {
        this.dato = dato;
    }

    public Cliente getDato() {
        return dato;
    }

    public void setDato(Cliente dato) {
        this.dato = dato;
    }

    public NodoLista getPs() {
        return ps;
    }

    public void setPs(NodoLista ps) {
        this.ps = ps;
    }  

}
