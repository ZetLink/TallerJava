package lista;

import arbol.Persona;

public class NodoLista {
    private Persona dato;
    private NodoLista ps;
    
    public NodoLista(Persona dato) {
        this.dato = dato;
    }

    public Persona getDato() {
        return dato;
    }

    public void setDato(Persona dato) {
        this.dato = dato;
    }

    public NodoLista getPs() {
        return ps;
    }

    public void setPs(NodoLista ps) {
        this.ps = ps;
    }
      
}