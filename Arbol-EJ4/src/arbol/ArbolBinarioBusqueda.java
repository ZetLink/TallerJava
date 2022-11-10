package arbol;

import interfaces.Comparador;
import lista.Suscripcion;
import lista.NodoLista;

public class ArbolBinarioBusqueda extends ArbolBinario {

    public ArbolBinarioBusqueda() {
        super();
    }

    // Inserción en el árbol aplicando orden binario
    public void insertar(NodoLista dato) {
        Suscripcion aux = (Suscripcion) dato.getDato();
        if (esVacio()) {
            raiz = new NodoArbol(aux.getDocumento(),dato);
        } else {
            insertarNodo(raiz, dato);
        }
    }

//     El nodo se inserta a la izq si es menor y a la der si es mayor
    private void insertarNodo(NodoArbol p, NodoLista dato) {
        
        NodoLista listaInicio = (NodoLista) p.getDato();
        NodoLista listaObjeto = (NodoLista) dato;
        
        Suscripcion libInicio = (Suscripcion) listaInicio.getDato();
        Suscripcion libObjeto = (Suscripcion) listaObjeto.getDato();
        
        int iDNI = libInicio.getDocumento();
        int iObjDNI = libObjeto.getDocumento();
        
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
    public NodoArbol buscar(NodoLista buscado) {
//        Comparador dato;
//        dato = (Comparador) buscado;
        Suscripcion aux = (Suscripcion) buscado.getDato();
        if (raiz == null) {
            return null;
        } else {
            return localizar(getRaiz(), aux.getDocumento());
        }
    }

    private NodoArbol localizar(NodoArbol raizSub, int buscado) {
        Suscripcion aux  = (Suscripcion) raizSub.getDato();
        if (raizSub == null) {
            return null;
        } else if (buscado == aux.getDocumento()) { //buscado.igualQue(raizSub.getDato())
            return raizSub;
        } else if (buscado == aux.getDocumento()) { //buscado.menorQue(raizSub.getDato())
            return localizar(raizSub.getIzdo(), buscado);
        } else {
            return localizar(raizSub.getDcho(), buscado);
        }
    }

    // Recorre el árbol de acuerdo a su orden para eliminar un nodo
    @Override
    public NodoArbol borrar(NodoArbol p, NodoArbol ant, Object dato, NodoArbol q) {
        Comparador buscado;
        buscado = (Comparador) dato;
        if (p != null) {
            if (buscado.igualQue(p.getDato())) {
                q = desengancharNodo(p, ant);
            } else {
                if (buscado.mayorIgualQue(p.getDato())) {
                    q = borrar(p.getDcho(), p, dato, q);
                } else {
                    q = borrar(p.getIzdo(), p, dato, q);
                }
            }
        }
        return q;
    }

}