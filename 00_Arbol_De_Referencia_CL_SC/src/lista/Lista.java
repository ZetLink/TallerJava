package lista;

import utilidades.Consola;

public class Lista {
    protected NodoL list;
    
    public Lista(){
        list = null;
    }
    
    public NodoL inicio(){
        return list;
    }
    
    public boolean listaVacia() {
        return (list == null);
    }
    
    //Insertar LSE
    public void insertar(Socio entrada) {
        NodoL x = new NodoL(entrada);
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
        NodoL p = list;
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
    public NodoL quitar(NodoL p, NodoL ant) {
        NodoL x = p;
        if (p == list) {
            list = p.getPs();
        } else {
            ant.setPs(p.getPs());
        }
        return x;
    }
    
    public NodoL eliminar(int elem) {
        NodoL x = null;
        NodoL p = list;
        NodoL ant = null;
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