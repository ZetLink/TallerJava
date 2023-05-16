package pila;

import datos.Practicos;
import consola.Consola;

public class Pila {
    Nodo tope;

    public Pila() {
        this.tope = null;
    }
    
    public void apilar(Practicos prac){
        Nodo nuevo = new Nodo(prac);   
        if(pilaVacia()){
            tope = nuevo;
        } else {
            nuevo.setPs(tope);
            tope = nuevo;
        }
    }
   
    public Nodo desapilar(){
        Nodo aux = null;
        if(pilaVacia()){
            Consola.prtRed("PILA VACIA");
        } else {
            aux = tope;
            tope = tope.getPs();
        }
        return aux;
    }
  
    public boolean pilaVacia(){
        return (tope == null);
    }
}