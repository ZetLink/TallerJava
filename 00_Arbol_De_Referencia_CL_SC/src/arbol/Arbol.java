package arbol;

import lista.NodoL;
import lista.Socio;

public class Arbol {
    private NodoA raiz;
    
    public Arbol(){
        raiz = null;
    }
    
    public NodoA getRaiz(){
        return raiz;
    }
    
    public boolean esVacio() {
        return raiz == null;
    }
    
    public void insertar(NodoL dato){
        if (esVacio()){
            raiz = new NodoA(dato.getDato().getDni(), dato);
        } else {
            insertarNodo(raiz, dato);
        }
    }
    
    private void insertarNodo(NodoA p, NodoL dato){
        if(p.getDni() != dato.getDato().getDni()) {
            if(dato.getDato().getDni() > p.getDni()) {
                if(p.getPD() == null) {
                    p.setPD(new NodoA(dato.getDato().getDni(), dato));
                } else {
                    insertarNodo(p.getPD(), dato);
                }
            } else {
                if(p.getPI() == null) {
                    p.setPI(new NodoA(dato.getDato().getDni(), dato));
                } else {
                    insertarNodo(p.getPI(),dato);
                }
            }
        } else {
            System.out.println("El Elemento Ya Existe");
        }
    }

    public NodoL buscar(NodoA r, NodoL nl, NodoL q) {
        if (r == null){
            return null;
        } else if (r.getDni() == nl.getDato().getDni()){
            q = r.getDir();
            return q;
        } else if (r.getDni() > nl.getDato().getDni()){
            return buscar(r.getPI(), nl, q);
        } else {
            return buscar(r.getPD(), nl, q);
        }
    }
}
