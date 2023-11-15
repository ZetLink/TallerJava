package arbol;

import utilidades.Consola;
import lista.NodoLista;

public class Arbol {
    private NodoArbol raiz;
    
    public Arbol(){
        raiz = null;
    }
    
    public void preorden() {
        this.preorden(this.raiz);
    }

    public void entreorden() {
        this.entreorden(this.raiz);
    }

    public void entreordenHojas() {
        this.entreordenMostrarHojas(this.raiz);
    }
  
    public void postorden() {
        this.postorden(this.raiz);
    }
    
    public NodoArbol obtenerRaiz(){
        return raiz;
    }
    
    public void insertar(NodoLista x){
        Persona aux = (Persona) x.getDato();
        if(raiz == null) {
            raiz = new NodoArbol(aux.getDni(), x);
        } else {
            insertarNodo(raiz,x);
        }
    }
    
    private void insertarNodo(NodoArbol p, NodoLista dato){
        if (dato.getDato().getDni() != p.getDni()){
            if (dato.getDato().getDni() < p.getDni()){
                if (p.getPI() == null){
                    p.setPI(new NodoArbol(dato.getDato().getDni(), dato));
                } else {
                    insertarNodo(p.getPI(), dato);
                }
            } else {
                if (p.getPD() == null){
                    p.setPD(new NodoArbol(dato.getDato().getDni(), dato));
                } else {
                    insertarNodo(p.getPD(), dato);
                }
            }
        } else {
            Consola.prtRed("Persona Existente");
        }
    }

    private void preorden(NodoArbol r) {
        if (r != null) {
            r.imprimirDato();
            preorden(r.getPI());
            preorden(r.getPD());
        }
    }

    private void entreorden(NodoArbol r) {
        if (r != null) {
            //entreorden(r.getIzdo());
            entreorden(r.getPD());
            r.imprimirDato();
            //entreorden(r.getDcho());
            entreorden(r.getPI());
        }
    }

    private void entreordenMostrarHojas(NodoArbol r) {
        if (r != null) {
            if (r.getPD() == null && r.getPI() == null) {
                r.imprimirDato();
            }
            entreordenMostrarHojas(r.getPI());
            entreordenMostrarHojas(r.getPD());
        }
    }

    private void postorden(NodoArbol r) {
        if (r != null) {
            postorden(r.getPI());
            postorden(r.getPD());
            r.imprimirDato();
        }
    }
    
    public NodoArbol borrar(NodoArbol p, NodoArbol ant, NodoLista nl, NodoArbol q){
        Persona oTemp = nl.getDato();
        if (p != null){
            if (p.getDni() == oTemp.getDni()){
                q = desengancharNodo(p, ant);
            } else {
                if (p.getDni() > oTemp.getDni()){
                    borrar(p.getPI(), p, nl, q);
                } else {
                    borrar(p.getPD(), p, nl, q);
                }
            }
        }
        return q;
    }
    
    public NodoArbol desengancharNodo(NodoArbol p, NodoArbol ant){
        NodoArbol q = null;
        if (p.getPI() == null && p.getPD() == null) {
            q = eliminarHoja(p, ant);
        } else {
            if (p.getPI() != null && p.getPD() != null){
                q = eliminar2subarbol(p);
            } else {
                q = eliminar1subarbol(p, ant);
            }
        }
        return q;
    }
    
    public NodoArbol eliminarHoja(NodoArbol p, NodoArbol ant){
        if (ant == null){
            raiz = null;
        } else {
            if (ant.getPI() == p){
                ant.setPI(null);
            } else {
                ant.setPD(null);
            }
        }
        return p;
    }
    
    public NodoArbol eliminar1subarbol(NodoArbol p, NodoArbol ant){
        if (ant == null){
            if (p.getPI() == null){
                raiz = p.getPD();
            } else {
                raiz = p.getPI();
            }
        } else {
            if (ant.getPI() == p){
                if (p.getPI() == null){
                    ant.setPI(p.getPD());
                } else {
                    ant.setPI(p.getPI());
                }
            } else {
                if (p.getPD() == null){
                    ant.setPD(p.getPI());
                } else {
                    ant.setPD(p.getPD());
                }
            }
        }
        return p;
    }
    
    public NodoArbol eliminar2subarbol(NodoArbol p){
        NodoArbol ant = p;
        NodoArbol q = p.getPD();
        while(q.getPI() != null) {
            ant = q;
            q = q.getPI();
        }
        Persona Aux = p.getDato().getDato();
        p.setDato(q.getDato());
        q.setDato(new NodoLista(Aux));
        q = desengancharNodo(q,ant);
        return q;
    } 

    
//    public Persona buscar(NodoArbol p, NodoLista nl, Persona q) {
//        Persona oTemp = nl.getDato();
//        if (p == null){
//            return null;
//        } else if (p.getDato().getDni() == oTemp.getDni()){
//            q = p.getDato();
//            return q;
//        } else if (p.getDato().getDni() > oTemp.getDni()){
//            return buscar(p.getPI(), nl, q);
//        } else {
//            return buscar(p.getPD(), nl, q);
//        }
//    }
    
    public NodoArbol buscar(NodoLista buscado) {
        Persona oTemp = (Persona) buscado.getDato();
        if (raiz == null) {
            return null;
        } else {
            return localizar(obtenerRaiz(), oTemp.getDni());
        }
    }

    private NodoArbol localizar(NodoArbol raizSub, int buscado) {
        NodoLista oTemp  = raizSub.getDato();
        Persona aux = oTemp.getDato();
        if (raizSub == null) {
            return null;
        } else if (buscado == aux.getDni()) {
            return raizSub;
        } else if (buscado == aux.getDni()) {
            return localizar(raizSub.getPI(), buscado);
        } else {
            return localizar(raizSub.getPD(), buscado);
        }
    }
}
