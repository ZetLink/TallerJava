package lseo;

import datos.Articulo;

public class LSEO extends LSE{

    public LSEO() {
        super();
    }
    
    public void insertarPrim(Articulo e){
        Nodo N = new Nodo(e);
        if (list != null){
            N.setPs(list);
        }
        list = N;
    }
    
    public void insertarMedio(Nodo p, Nodo ant, Nodo x) {
        x.setPs(p);
        ant.setPs(x);
    }
    
    public void insertarFin(Nodo ant, Nodo p, Nodo x) {
        if (p == null) {
            x.setPs(null);
            ant.setPs(x);
        }
    }
    
    @Override
    public void insertar(Articulo entrada) {
        Nodo p = inicio();
        Nodo ant = null;
        int b = 0;
        
        while (p != null && b == 0) {
            if (p.getDato().getCod() >= entrada.getCod()) {
                b = 1;
            } else {
                ant = p;
                p = p.getPs();
            }
        }
        Nodo x = new Nodo(entrada);
        if (b == 1) {
            if (p == list) {
                insertarPrim(entrada);
            } else {
                insertarMedio(p, ant, x);
            }
        } else {
            if (ant == null) {
                list = x;
            } else {
                insertarFin(ant, p, x);
            }
        }
    }
}
