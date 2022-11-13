package Arbol;

import Interfaces.Comparador;
import LSE.*;

public class ArbolBinarioBusqueda extends ArbolBinario {

    public ArbolBinarioBusqueda() {
        super();
    }

    // Inserción en el árbol aplicando orden binario
    public void insertar(NodoLista dato) {
        Reclamos aux = (Reclamos) dato.getDato();
        if (esVacio()) {
            raiz = new NodoArbol(aux.getDni(),dato);
        } else {
            insertarNodo(raiz, dato);
        }
    }

//     El nodo se inserta a la izq si es menor y a la der si es mayor
    private void insertarNodo(NodoArbol p, NodoLista dato) {
        
        NodoLista listaInicio = (NodoLista) p.getDato();
        NodoLista listaObjeto = (NodoLista) dato;
        
        Reclamos libInicio = (Reclamos) listaInicio.getDato();
        Reclamos libObjeto = (Reclamos) listaObjeto.getDato();
        
        int iDNI = libInicio.getDni();
        int iObjDNI = libObjeto.getDni();
        
        if (iObjDNI < iDNI) {
            if (p.getDcho() == null) {
                p.setDcho(new NodoArbol(iDNI,(NodoLista) dato));
            } else {
                insertarNodo(p.getDcho(), dato);
            }
        } else if (p.getIzdo() == null) {
            p.setIzdo(new NodoArbol(iDNI,(NodoLista) dato));
        } else {
            insertarNodo(p.getIzdo(), dato);
        }
    }

    // Para buscar se considera el ordenamiento binario
    public NodoArbol buscar(int buscado) {
        if (raiz == null) {
            return null;
        } else {
            return localizar(getRaiz(), buscado);
        }
    }

    private NodoArbol localizar(NodoArbol raizSub, int buscado) {
        NodoLista uwu = (NodoLista) raizSub.getDato();
        Reclamos aux  = (Reclamos) uwu.getDato();
        if (raizSub == null) {
            return null;
        } else if (buscado == aux.getDni()) { //buscado.igualQue(raizSub.getDato())
            return raizSub;
        } else if (buscado == aux.getDni()) { //buscado.menorQue(raizSub.getDato())
            return localizar(raizSub.getIzdo(), buscado);
        } else {
            return localizar(raizSub.getDcho(), buscado);
        }
    }

    // Recorre el árbol de acuerdo a su orden para eliminar un nodo
    @Override
    public NodoArbol borrar(NodoArbol p, NodoArbol ant, int estado, NodoArbol q) {
        if (p != null) {
            NodoLista aux = (NodoLista) p.getDato();
            Reclamos aux2 = (Reclamos) aux.getDato();
            if (estado == aux2.getEstado()) {
                q = desengancharNodo(p, ant);
            } else {
                q = borrar(p.getIzdo(), p, estado, q);
                if (q == null) {
                    q = borrar(p.getDcho(), p, estado, q);
                }
            }
        }
        return q;
    }
    
    public NodoLista buscarArbol(NodoArbol r, int dni, NodoLista q){
        if (r != null){
            if (r.getDocumento() == dni){
                q = (NodoLista) r.getDato();
            }
        } else {
            if (r.getDocumento() > dni) {
                q = buscarArbol(r.getIzdo(), dni, q);
            } else {
                q = buscarArbol(r.getDcho(), dni, q);
            }
        }
        return q;
    }

}