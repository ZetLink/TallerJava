package LSE;

public class Lista {
    private NodoLista list;
    
    public Lista(){
        list = null;
    }
    
    public NodoLista inicio(){
        return list;
    }
    
    public void insertarPrim(Suscripcion entrada) {
        NodoLista x = new NodoLista(entrada);
        if (list == null) {
            list = x;
        } else {
            x.setPs(list);
            list = x;
        }
    }
    
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
        if(list == null)
            return x;
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
            x = p;
        }
        return x;
    }
    
    public boolean listaVacia() {
        return (list == null);
    }
    
    public void imprimirDatos(){
        if (!listaVacia()){
            LSE.NodoLista p = inicio();
            while (p != null){
                Suscripcion miembro = p.getDato();
                System.out.println(String.format("| %10d | %20s | %20s | %20s | %2c | %2c | %8.2f |", + 
                    miembro.getDni(), miembro.getApe_nom(), miembro.getPais(), miembro.getDireccion(),miembro.getFdp(), miembro.getTds(),miembro.getCosto()));
                p = p.getPs();   
            }
        } else {
            System.out.println("Lista Vacia\n");
        }
    }
     
}
