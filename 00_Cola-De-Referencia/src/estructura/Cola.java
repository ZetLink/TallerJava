package estructura;

import datos.*;
import consola.Consola;

public class Cola{
    private NodoCola frente, fondo;
    
    public  Cola() {
        frente = null;
        fondo = null;
    }

    public boolean colaVacia() {
        return (frente == null);
    }

    public void insertar(Cliente elem) {
        NodoCola nuevo = new NodoCola(elem);
        if (colaVacia()) {
            frente = fondo = nuevo;
        } else {
            fondo.setPs(nuevo);
            fondo = nuevo;
        }
    }
    
    public void insertar(NodoCola nuevo) {      
        if (colaVacia()) {
            frente = fondo = nuevo;
        } else {
            fondo.setPs(nuevo);
            fondo = nuevo;
        }
    }
       
    public NodoCola quitar() {
        NodoCola regreso = frente;
        if(!colaVacia()) {
            frente =frente.getPs();      
        } else {
            Consola.prtRed("Cola Vacia");
        }    
        return (regreso);
    } 
}