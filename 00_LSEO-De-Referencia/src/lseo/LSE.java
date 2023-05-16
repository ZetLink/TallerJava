package lseo;

import datos.Articulo;

public class LSE {
    protected Nodo list;
    
    public LSE(){
        list = null;
    }
    
    public Nodo inicio(){
        return list;
    }
    
    public boolean listaVacia() {
        return (list == null);
    }
    
    //Insertar LSE
    public void insertar(Articulo entrada) {
        Nodo x = new Nodo(entrada);
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
        Nodo p = list;
        while (b == false && p != null){
            if (p.getDato().getCod() == elem){
                b = true;
            }
            p = p.getPs();
        }
        return b;
    }
    //----------
    
    //Eliminar LSE
    public Nodo quitar(Nodo p, Nodo ant) {
        Nodo x = p;
        if (p == list) {
            list = p.getPs();
        } else {
            ant.setPs(p.getPs());
        }
        return x;
    }
    
    public Nodo eliminar(int elem) {
        Nodo x = null;
        Nodo p = list;
        Nodo ant = null;
        if(list == null){
            return x;
        }
        boolean band = false;
        while (p != null && !band) {
            if (p.getDato().getCod() == elem) {
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
