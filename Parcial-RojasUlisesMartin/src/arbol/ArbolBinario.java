package arbol;

import interfaces.Comparador;
import lista.*;

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

    private void preorden(NodoArbol r) {
        if (r != null) {
            r.imprimirDato();
            preorden(r.getIzdo());
            preorden(r.getDcho());
        }
    }

    private void entreorden(NodoArbol r) {
        if (r != null) {
            entreorden(r.getIzdo());
            //entreorden(r.getDcho());
            
            NodoLista aux = (NodoLista) r.getDato();
            Cliente aux2 = (Cliente) aux.getDato();
            if (aux2.getCantCuotas() == 0){
                aux2.mostrarDatos();
            }
            
            entreorden(r.getDcho());
            //entreorden(r.getIzdo());
        }
    }
    
    public void mostrarTodo(NodoArbol r) {
        if (r != null) {
            mostrarTodo(r.getIzdo());
            //mostrarTodo(r.getDcho());
            
            NodoLista aux = (NodoLista) r.getDato();
            Cliente aux2 = (Cliente) aux.getDato();
            aux2.mostrarTodo();
            
            mostrarTodo(r.getDcho());
            //mostrarTodo(r.getIzdo());
        }
    }

    private void entreordenMostrarHojas(NodoArbol r) {
        if (r != null) {
            if (r.getDcho() == null && r.getIzdo() == null) {
                r.imprimirDato();
            }
            entreordenMostrarHojas(r.getIzdo());
            entreordenMostrarHojas(r.getDcho());
        }
    }

   
    private void postorden(NodoArbol r) {
        if (r != null) {
            postorden(r.getIzdo());
            postorden(r.getDcho());
            NodoLista aux = (NodoLista) r.getDato();
            System.out.println(aux.getDato().getCodCli());
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

    public boolean verificarExistencia(NodoArbol r, int num){
        boolean bTemp = false;
        bTemp = verificarExistencia(r.getIzdo(),num);
        bTemp = verificarExistencia(r.getDcho(), num);
        if (r == null){
            System.out.println("...");
        } else {
            if (r.getCodCli() == num){
                bTemp = true;
            }
        }
        return bTemp;
    }
}
