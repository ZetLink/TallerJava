package arbol;

import lista.*;

public class NodoArbol{

    private int codCli;
    private Object dato;
    private NodoArbol izdo;
    private NodoArbol dcho;

    public NodoArbol(int cod,Object valor){
        codCli = cod;
        dato = valor;
        izdo = dcho = null;
       
    }

    public NodoArbol(NodoArbol ramaIzdo, int cod, Object valor, NodoArbol ramaDcho) {
        codCli = cod;
        dato = valor;
        izdo = ramaIzdo;
        dcho = ramaDcho;
      
    }

    public Object getDato() {
        return dato;
    }

    public NodoArbol getIzdo() {
        return izdo;
    }

    public NodoArbol getDcho() {
        return dcho;
    }

    public void setDato(Object d) {
        dato = d;
    }

    public void setIzdo(NodoArbol n) {
        izdo = n;
    }

    public void setDcho(NodoArbol n) {
        dcho = n;
    }

    public int getCodCli() {
        return codCli;
    }

    public void setCodCli(int codCli) {
        this.codCli = codCli;
    }
    
    public void imprimirDato() {
        System.out.print(dato.toString() + "\n\n");
    }
   
}
