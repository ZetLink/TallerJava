package lista;

public class NodoLista{
    private BibliotecaEscolar dato;
    private NodoLista ps;
    
    public NodoLista(BibliotecaEscolar dato) {
        this.dato = dato;
    }

    public BibliotecaEscolar getDato() {
        return dato;
    }

    public void setDato(BibliotecaEscolar dato) {
        this.dato = dato;
    }

    public NodoLista getPs() {
        return ps;
    }

    public void setPs(NodoLista ps) {
        this.ps = ps;
    }  

}
