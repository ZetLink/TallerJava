package lista;

import arbol.Persona;
import utilidades.Consola;

public class LSE {
    protected NodoLista list;
    
    public LSE(){
        list = null;
    }
    
    public NodoLista inicio(){
        return list;
    }
    
    public boolean listaVacia() {
        return (list == null);
    }
    
    //Insertar LSE
    public void insertar(Persona entrada) {
        NodoLista x = new NodoLista(entrada);
        if (list == null) {
            list = x;
        } else {
            x.setPs(list);
            list = x;
        }
    }
    //------------
    
    //Buscar LSE   
    public boolean buscar(int elem){
        boolean b = false;
        NodoLista p = list;
        while (b == false && p != null){
            if (p.getDato().getDni() == elem){
                b = true;
            }
            p = p.getPs();
        }
        return b;
    }
    //----------
    
    //Eliminar LSE
    public NodoLista quitar(NodoLista p, NodoLista ant) {
        NodoLista x = p;
        if (p == list) {
            list = p.getPs();
        } else {
            ant.setPs(p.getPs());
        }
        return x;
    }
    
    public NodoLista eliminar(int elem) {
        NodoLista x = null;
        NodoLista p = list;
        NodoLista ant = null;
        if(list == null){
            return x;
        }
        boolean band = false;
        while (p != null && !band) {
            if (p.getDato().getDni() == elem) {
                band = true;
            } else {
                ant = p;
                p = p.getPs();
            }
        }
        if (band == true) {
            quitar(p, ant);
            Consola.prtGreen("Elemento Eliminado");
            x = p;
        }
        return x;
    }
    //------------
   
}