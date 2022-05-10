package aeropuertolse;

public class Lista {
    private Nodo list;
    
    public Lista(){
        list = null;
    }
    
    public Nodo inicio(){
        return list;
    }
    
    public boolean listaVacia() {
        return (list == null);
    }
    
    //Insertar LSE
    public void insertar(Datos entrada) {
        Nodo x = new Nodo(entrada);
        if (list == null) {
            list = x;
        } else {
            x.setPs(list);
            list = x;
        }
    }
    //------------
    
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
        if(list == null)
            return x;
        boolean band = false;
        while (p != null && !band) {
            if (p.getDato().getCod_vuelo() == elem) {
                band = true;
            } else {
                ant = p;
                p = p.getPs();

            }
        }
        if (band == true) {
            quitar(p, ant);
            x = p;
        }
        return x;
    }
    //------------
   
}
