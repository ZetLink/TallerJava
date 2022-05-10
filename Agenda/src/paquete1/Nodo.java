
package paquete1;

public class Nodo {
    private Contacto dato;
    private Nodo ps;

    public Nodo(Contacto dato) {   // ver bien
        this.dato = dato;
       
    }
    
     
    public Contacto getDato() {
        return dato;
    }

    public void setContacto(Contacto dato) {
        this.dato = dato;
    }
    
    public Nodo getPs() {
        return ps;
    }

    public void setPs(Nodo ps) {
        this.ps = ps;
    }
    
    
    
   
   
    
}
