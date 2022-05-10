package moverdelseoalse;

public class Lista {
    
    private Nodo list;
    
    public Lista(){
        list = null;
    }
    
    public Nodo inicio(){
        return list;
    }
    
    
    //Verificar si se encuentra vacia
    public boolean listaVacia() {
        return (list == null);
    }
    //-------------------------------
    
    //Ingresar Datos
    public void insertarPrim(Datos entrada){
        Nodo N = new Nodo(entrada);
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
    
    public void insertar(Datos entrada) {
        Nodo p = inicio();
        Nodo ant = null;
        int b = 0;
        
        while (p != null && b == 0) {
            if (p.getDato().getCodigo() >= entrada.getCodigo()) {
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
    //--------------
    
    //Eliminar
    /*public void eliminarElemento(int entrada){
        Nodo p = list;
        Nodo ant = null;
        while(p!= null){
            Datos d = p.getDato();
            if (d.getCodigo() >= entrada) {
                if (d.getCodigo() == entrada) {
                    d.setEliminado(true);
                }else{
                    p = null;
                }
            } else {
                ant = p;
                p = p.getPs();
            }
        }
    }*/
    public void buscarElemento(int e){
      Nodo p = inicio();
      boolean existe = false;
      while(p!= null && !existe){
      Datos d = p.getDato();
        if (e >= d.getCodigo()){
            if(e == d.getCodigo()){
                  d.setEliminado(true);
            } else {
                  p = p.getPs();
            }
        }
    }
    }
    //--------
}
