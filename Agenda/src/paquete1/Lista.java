
package paquete1;


public class Lista {
    private Nodo list;
    
    public Lista(){
        list = null;
    }
    
    public Nodo Inicio(){
        return list;
    }
    
    //Insertar
    public void insertarPrim(Contacto e){
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
    //------
    
    //Parte agregada de LSEO
    public void insertar(Contacto entrada) {
        Nodo p = Inicio();
        Nodo ant = null;
        int b = 0;

        while (p != null && b == 0) {
            if (p.getDato().getNumtelefono() >= entrada.getNumtelefono()) {
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

    public void prt(String s) {
        System.out.println(s);
    }
    //
    
    public Nodo eliminarElemento(int entrada){
        Nodo x = null;
        Nodo p = list;
        Nodo ant = null;
        boolean band = false;
        while(p!= null & !band){
            Contacto con = p.getDato();
            if (con.getNumtelefono() >= entrada) {
                if (con.getNumtelefono()== entrada) {
                    band = true;
                }else{
                    p = null;
                }
            } else {
                ant = p;
                p = p.getPs();
            }
        }
        if(band==true){
           x=quitar(p,ant);
        }
        return x;
    }
    public Nodo quitar(Nodo p,Nodo a){
    Nodo x=p;
    if(p==list){
        list=p.getPs();
       
    }
    else
        a.setPs(p.getPs());
   
     return x;

}  
    public Nodo buscarElemento(int e){
      Nodo p=list;
      boolean existe=false;
      while(p!= null && !existe){
      Contacto cont = p.getDato();
        if (e >= cont.getNumtelefono()){
            if(e == cont.getNumtelefono()){
                  existe=true;
            } else {
                  p=p.getPs();
            }
        }
      }
        return p;
      }
}
