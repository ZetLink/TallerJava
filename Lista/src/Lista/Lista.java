package Lista;

public class Lista {
    private Nodo list;
    
    public Lista(){
        list = null;
    }
    
    public Nodo inicio(){
        return list;
    }
    
    
    //Insertar
    public void insertarPrim(Dato e){
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
    
    public void insertar(Dato entrada) {
        Nodo p = inicio();
        Nodo ant = null;
        int b = 0;
        
        while (p != null && b == 0) {
            if (p.getDato().getNum() >= entrada.getNum()) {
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
    
    //Eliminar
    public Nodo eliminarElemento(int entrada){
        Nodo x = null;
        Nodo p = list;
        Nodo ant = null;
        boolean band = false;
        while(p!= null & !band){
            Dato dat = p.getDato();
            if (dat.getNum() >= entrada) {
                if (dat.getNum() == entrada) {
                    band = true;
                }else{
                    p = null;
                }
            } else {
                ant = p;
                p = p.getPs();
            }
        }
        if(band == true){
           x = quitar(p, ant);
        }
        return x;
    }
    public Nodo quitar(Nodo p,Nodo a){
    Nodo x = p;
    if(p == list){
        list=p.getPs(); 
    } else 
        a.setPs(p.getPs());
        return x;
    }
    
    //Verificar si se encuentra vacia
    public boolean listaVacia() {
        return (list == null);
    }
     
}
