package arbol;

import utilidades.Consola;

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
    
    public void insertar(Persona x){
        if(raiz == null) {
            raiz = new NodoArbol(x);
        } else {
            insertarNodo(raiz,x);
        }
    }
    
    public void insertarNodo(NodoArbol p, Persona dato){
        if (dato.getDni() != p.getDato().getDni()){
            if (dato.getDni() < p.getDato().getDni()){
                if (p.getPI() == null){
                    p.setPI(new NodoArbol(dato));
                } else {
                    insertarNodo(p.getPI(), dato);
                }
            } else {
                if (p.getPD() == null){
                    p.setPD(new NodoArbol(dato));
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
    
    public NodoArbol borrar(NodoArbol p, NodoArbol ant, int dni, NodoArbol q){
        if (p != null){
            if (p.getDato().getDni() == dni){
                q = desengancharNodo(p, ant);
            } else {
                if (p.getDato().getDni() > dni){
                    borrar(p.getPI(), p, dni, q);
                } else {
                    borrar(p.getPD(), p, dni, q);
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
        Persona Aux = p.getDato();
        p.setDato(q.getDato());
        q.setDato(Aux);
        q = desengancharNodo(q,ant);
        return q;
    } 
    
    public Persona buscar(NodoArbol p, int dni, Persona q) {
        if (p == null){
            return null;
        } else if (p.getDato().getDni() == dni){
            q = p.getDato();
            return q;
        } else if (p.getDato().getDni() > dni){
            return buscar(p.getPI(), dni, q);
        } else {
            return buscar(p.getPD(), dni, q);
        }
    }
}
