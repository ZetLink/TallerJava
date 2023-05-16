package estructura;

import datos.Mesa;

public class Lista {
    private NodoLista list;
    
    public Lista(){
        list = null;
    }
    
    public NodoLista inicio(){
        return list;
    }
    
    public boolean listaVacia() {
        return (list == null);
    }
    
    //Insertar LSE
    public void insertar(Mesa entrada) {
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
    public boolean buscar(long elem){
        boolean b = false;
        NodoLista p = list;
        while (b == false && p != null){
            if (p.getDato().getNumeroMesa() == elem){
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
            if (p.getDato().getNumeroMesa() == elem) {
                band = true;
            } else {
                ant = p;
                p = p.getPs();
            }
        }
        if (band == true) {
            quitar(p, ant);
            System.out.println("Elemento eliminado!!!");
            x = p;
        }
        return x;
    }
    //------------
   
}
