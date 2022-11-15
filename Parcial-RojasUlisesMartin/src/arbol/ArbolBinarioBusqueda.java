package arbol;

import interfaces.Comparador;
import lista.*;

public class ArbolBinarioBusqueda extends ArbolBinario {

    public ArbolBinarioBusqueda() {
        super();
    }

    // Inserción en el árbol aplicando orden binario
    public void insertar(NodoLista dato) {
        Cliente aux = (Cliente) dato.getDato();
        if (esVacio()) {
            raiz = new NodoArbol(aux.getCodCli(),dato);
        } else {
            insertarNodo(raiz, dato);
        }
    }

//     El nodo se inserta a la izq si es menor y a la der si es mayor
    private void insertarNodo(NodoArbol p, NodoLista dato) {
        
        NodoLista listaInicio = (NodoLista) p.getDato();
        NodoLista listaObjeto = (NodoLista) dato;
        
        Cliente libInicio = (Cliente) listaInicio.getDato();
        Cliente libObjeto = (Cliente) listaObjeto.getDato();
        
        int iDNI = libInicio.getCodCli();
        int iObjDNI = libObjeto.getCodCli();
        
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
        Cliente aux  = (Cliente) uwu.getDato();
        if (raizSub == null) {
            return null;
        } else if (buscado == aux.getCodCli()) { //buscado.igualQue(raizSub.getDato())
            return raizSub;
        } else if (buscado == aux.getCodCli()) { //buscado.menorQue(raizSub.getDato())
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