package arbol;

import interfaces.Comparador;
import lista.*;

public class NodoArbol implements Comparador{

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
    
        
    @Override
    public String toString() {
        return " " + this.getCodCli() + " ";
    }

    @Override
    public boolean igualQue(Object op2) {
        NodoArbol x = (NodoArbol) op2;
        Cliente x2 = (Cliente) x.getDato();
        return (getCodCli() == x2.getCodCli());
    }

    public boolean menorQue(Object op2) {
        NodoArbol x = (NodoArbol) op2;
        Cliente x2 = (Cliente) x.getDato();
        return (getCodCli() < x2.getCodCli());
    }

    public boolean menorIgualQue(Object op2) {
        NodoArbol x = (NodoArbol) op2;
        Cliente x2 = (Cliente) x.getDato();
        return (getCodCli() <= x2.getCodCli());
    }

    public boolean mayorQue(Object op2) {
        NodoArbol x = (NodoArbol) op2;
        Cliente x2 = (Cliente) x.getDato();
        return (getCodCli() > x2.getCodCli());
    }

    public boolean mayorIgualQue(Object op2) {
        NodoArbol x = (NodoArbol) op2;
        Cliente x2 = (Cliente) x.getDato();
        return (getCodCli() >= x2.getCodCli());
    }
   
}
