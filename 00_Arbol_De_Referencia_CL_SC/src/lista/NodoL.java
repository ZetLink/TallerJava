package lista;

public class NodoL {
        private Socio dato;
     	private NodoL ps;

    public NodoL(Socio dato) {
        this.dato = dato;
    }

    public Socio getDato() {
        return dato;
    }

    public void setDato(Socio dato) {
        this.dato = dato;
    }

    public NodoL getPs() {
        return ps;
    }
    
    public void setPs(NodoL ps) {
        this.ps = ps;
    }

}
   

	 
