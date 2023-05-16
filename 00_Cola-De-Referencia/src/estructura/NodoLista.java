package estructura;

import datos.Mesa;

public class NodoLista {
    private Mesa dato;
    private NodoLista ps;
    
    public NodoLista(Mesa dato) {
        this.dato = dato;
    }

    public Mesa getDato() {
        return dato;
    }

    public void setDato(Mesa dato) {
        this.dato = dato;
    }

    public NodoLista getPs() {
        return ps;
    }

    public void setPs(NodoLista ps) {
        this.ps = ps;
    }
      
}