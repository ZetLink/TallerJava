package lista;

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
    
    public boolean listaVacia() {
        return (list == null);
    }
    
    public void imprimirDatos(){
        if (!listaVacia()){
            lista.NodoLista p = inicio();
            while (p != null){
                Suscripcion miembro = p.getDato();
                System.out.println(String.format("| %10d | %20s | %15s | %15s | %2c | %2c | %8.2f |", + 
                    miembro.getDocumento(), miembro.getApe_nom(), miembro.getPais(),
                    miembro.getDireccion(), miembro.getFdp(), miembro.getTds() + miembro.getCosto()));
                p = p.getPs();   
            }
        } else {
            System.out.println("Lista Vacia\n");
        }
    }
     
}
