package arbol;

import interfaces.Comparador;
import lista.*;

public class ArbolBinarioBusqueda extends ArbolBinario {

    public ArbolBinarioBusqueda() {
        super();
    }

    public void insertar(NodoLista l) {
        if (esVacio()) {
            raiz = new NodoArbol(l.getDato().getCodCli(),l);
        } else {
            insertarNodo(raiz,l);
        }
    }
    
    private void insertarNodo(NodoArbol p,NodoLista l) {
        
        if ((int)p.getCodCli() < (int)l.getDato().getCodCli()) {
            if (p.getDcho() == null) {
                p.setDcho(new NodoArbol(l.getDato().getCodCli(),l));
            } else {
                insertarNodo(p.getDcho(), l);
            }
        } else if (p.getIzdo() == null) {
            p.setIzdo(new NodoArbol(l.getDato().getCodCli(),l));
        } else {
            insertarNodo(p.getIzdo(), l);
        }
    }

    public NodoLista buscar(NodoLista buscado) {
        if (raiz == null) {
            return null;
        } else {
            return localizar(getRaiz(), buscado);
        }
    }

    private NodoLista localizar(NodoArbol raizSub, NodoLista buscado) {
        if (raizSub == null) {
            return null;
        } else 
            if ((int)buscado.getDato().getCodCli() == (int)raizSub.getCodCli()) {
            return (NodoLista) raizSub.getDato();
        } else if ((int)buscado.getDato().getCodCli() < (int)(raizSub.getCodCli())) {
            return localizar(raizSub.getIzdo(), buscado);
        } else {
            return localizar(raizSub.getDcho(), buscado);
        }
    }

    // Recorre el árbol de acuerdo a su orden para eliminar un nodo
    @Override
    public NodoArbol borrar(NodoArbol p, NodoArbol ant, int dato, NodoArbol q) {
        if (p != null) {
            if (dato == p.getCodCli()) {
                q = desengancharNodo(p, ant);
            } else {
                q = borrar(p.getIzdo(), p, dato, q);
                if (q == null) {
                    q = borrar(p.getDcho(), p, dato, q);
                }
            }
        }
        return q;
    }
    
    public NodoLista buscarArbol(NodoArbol r, int dni, NodoLista q){
        if (r != null){
            if (r.getCodCli() == dni){
                q = (NodoLista) r.getDato();
            }
        } else {
            if (r.getCodCli() > dni) {
                q = buscarArbol(r.getIzdo(), dni, q);
            } else {
                q = buscarArbol(r.getDcho(), dni, q);
            }
        }
        return q;
    }

}