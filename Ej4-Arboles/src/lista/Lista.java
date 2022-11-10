package lista;

public class Lista {
    private NodoLista list;
    
    public Lista(){
        list = null;
    }
    
    public NodoLista inicio(){
        return list;
    }
    
//    public void insertarPrim(BibliotecaEscolar e){
//        NodoLista N = new NodoLista(e);
//        if (list != null){
//            N.setPs(list);
//        }
//        list = N;
//    }
    
    public void insertarPrim(BibliotecaEscolar entrada) {
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
                BibliotecaEscolar miembro = p.getDato();
                System.out.println(String.format("| %10d | %20d | %15s | %15s | %15s |", + 
                    miembro.getDocumento(), miembro.getNroTele(), miembro.getNom(), miembro.getCorreoElectronico(), miembro.getDomicilio()));
                p = p.getPs();   
            }
        } else {
            System.out.println("Lista Vacia\n");
        }
    }
     
}
