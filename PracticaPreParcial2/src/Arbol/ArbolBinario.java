package Arbol;

import Interfaces.Comparador;
import LSE.*;

public class ArbolBinario {
    int niveles = 0;
    protected NodoArbol raiz;

    public ArbolBinario() {
        raiz = null;

    }

    public ArbolBinario(NodoArbol raiz) {
        this.raiz = raiz;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    boolean esVacio() {
        return raiz == null;
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

    // Recorrido de un árbol binario en preorden
    private void preorden(NodoArbol r) {
        if (r != null) {
            r.imprimirDato();
            preorden(r.getIzdo());
            preorden(r.getDcho());
        }
    }

    // Recorrido de un árbol binario en inorden o entreorden
    private void entreorden(NodoArbol r) {
        if (r != null) {
            //entreorden(r.getIzdo());
            entreorden(r.getDcho());
            
            NodoLista aux = (NodoLista) r.getDato();
            Reclamos aux2 = (Reclamos) aux.getDato();
            System.out.println(aux2.getDni());
//            System.out.println(String.format("| %10d | %20d | %15s | %15s | %15s |", + 
//                    aux2.getDocumento(), aux2.getNroTele(), aux2.getNom(), aux2.getCorreoElectronico(), aux2.getDomicilio()));
            
            //entreorden(r.getDcho());
            entreorden(r.getIzdo());
        }
    }

    // Recorrido entreorden Mostrar hojas del arbol binario.
    private void entreordenMostrarHojas(NodoArbol r) {
        if (r != null) {
            if (r.getDcho() == null && r.getIzdo() == null) {
                r.imprimirDato();
            }
            entreordenMostrarHojas(r.getIzdo());
            entreordenMostrarHojas(r.getDcho());
        }
    }

   
    // Recorrido de un árbol binario en postorden
    private void postorden(NodoArbol r) {
        if (r != null) {
            postorden(r.getIzdo());
            postorden(r.getDcho());
            r.imprimirDato();
        }
    }

    public boolean pertenece(Object buscado) {
        Comparador dato;
        dato = (Comparador) buscado;
        if (raiz == null) {
            return false;
        } else {
            return pertenece(getRaiz(), dato);
        }
    }

    private boolean pertenece(NodoArbol raizSub, Comparador buscado) {
        if (raizSub == null) {
            return false;
        } else if (buscado.igualQue(raizSub.getDato())) {
            return true;
        } else if (pertenece(raizSub.getIzdo(), buscado)) {
            return true;
        } else if (pertenece(raizSub.getDcho(), buscado)) {
            return true;
        } else {
            return false;
        }
    }
    
    // Elimina un nodo del árbol y lo retorna
    public NodoArbol borrar(NodoArbol p, NodoArbol ant, int dato, NodoArbol q) {
        if (p != null) {
            if (dato == p.getDocumento()) {
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

    public NodoArbol desengancharNodo(NodoArbol p, NodoArbol ant) {
        NodoArbol q;
        if (p.getIzdo() == null && p.getDcho() == null) {
            q = eliminarHoja(p, ant);
        } else {
            if (p.getIzdo() != null && p.getDcho() != null) {
                q = eliminarDosSubArbol(p);
            } else {
                q = eliminarUnSubArbol(p, ant);
            }
        }
        return q;
    }

    public NodoArbol eliminarHoja(NodoArbol p, NodoArbol ant) {
        if (ant == null) {
            raiz = null;
        } else {
            if (ant.getIzdo() == p) {
                ant.setIzdo(null);
            } else {
                ant.setDcho(null);
            }
        }
        return p;
    }

    public NodoArbol eliminarUnSubArbol(NodoArbol p, NodoArbol ant) {
        if (ant == null) {
            if (p.getIzdo() == null) {
                raiz = p.getDcho();
            } else {
                raiz = p.getIzdo();
            }
        } else {
            if (ant.getIzdo() == p) {
                if (p.getIzdo() == null) {
                    ant.setIzdo(p.getDcho());
                } else {
                    ant.setIzdo(p.getIzdo());
                }
            } else {
                if (p.getDcho() == null) {
                    ant.setDcho(p.getIzdo());
                } else {
                    ant.setDcho(p.getDcho());
                }
            }
        }
        return p;
    }

    public NodoArbol eliminarDosSubArbol(NodoArbol p) {
        NodoArbol ant = p;
        NodoArbol q = p.getDcho();
        while (q.getIzdo() != null) {
            ant = q;
            q = q.getIzdo();
        }
        Object Aux = p.getDato();
        p.setDato(q.getDato());
        q.setDato((NodoLista) Aux);
        q = desengancharNodo(q, ant);
        return q;
    }
    
    public NodoArbol verificarExiste(NodoArbol r, int dni) {
        if (r != null) {
            entreorden(r.getDcho());
            if (r.getDocumento() == dni){
                return r;
            }
            entreorden(r.getIzdo());
        }
        return r;
    }
    
}
