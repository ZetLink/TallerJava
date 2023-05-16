package estructura;

import datos.Cliente;

public class NodoCola {
    private Cliente dato;
    private NodoCola ps;

    public NodoCola() {
        this.dato = dato;
        this.ps = null;
    }
    
    public NodoCola(Cliente e){
        dato = e;
        ps = null;
                       }

    public Cliente getDato() {
        return dato;
    }

    public NodoCola getPs() {
        return ps;
    }

    public void setDato(Cliente dato) {
        this.dato = dato;
    }

    public void setPs(NodoCola ps) {
        this.ps = ps;
    }  
}
