package lista;

public class Lista {
    private NodoLista list;
    
    public Lista(){
        list = null;
    }
    
    public NodoLista inicio(){
        return list;
    }
    
    public void insertarPrim(Cliente entrada) {
        NodoLista x = new NodoLista(entrada);
        if (list == null) {
            list = x;
        } else {
            x.setPs(list);
            list = x;
        }
    }
    
//     public NodoLista quitar(NodoLista p, NodoLista ant) {
//        NodoLista x = p;
//
//        if (p == list) {
//            list = p.getPs();
//        } else {
//            ant.setPs(p.getPs());
//
//        }
//        return x;
//    }
//    
//    public NodoLista eliminar(int elem) {
//        NodoLista x = null;
//        NodoLista p = list;
//        NodoLista ant = null;
//        if(list == null)
//            return x;
//        boolean band = false;
//        while (p != null && !band) {
//            if (p.getDato().getCodCli() == elem) {
//                band = true;
//            } else {
//                ant = p;
//                p = p.getPs();
//
//            }
//        }
//        if (band == true) {
//            quitar(p, ant);
//            x = p;
//        }
//        return x;
//    }
    
    public boolean listaVacia() {
        return (list == null);
    }
    
    public void imprimirDatos(){
        if (!listaVacia()){
            lista.NodoLista p = inicio();
            while (p != null){
                Cliente temp = p.getDato();
                System.out.println(String.format("| %10d | %20s | %20s | %20d | %2d | %8.2f | %4d |", + 
                    temp.getCodCli(), temp.getApe_nom(), temp.getDomicilio(), temp.getNumCelular(),temp.getCondicion(), temp.getMontoPrestamo(),temp.getCantCuotas()));
                p = p.getPs();   
            }
        } else {
            System.out.println("Lista Vacia\n");
        }
    }
     
}
