package principal;

import arbol.ArbolBinarioBusqueda;
import arbol.NodoArbol;
import lista.Lista;
import lista.Suscripcion;
import consola.Consola;
import lista.NodoLista;

public class ArbolAPP {
      
    private ArbolBinarioBusqueda abb;
    
    Lista list = new Lista();
    Lista listN = new Lista();
    
    public ArbolAPP() {
        abb = new ArbolBinarioBusqueda();
    }
    
    
    //-----Item A-----
    public void cargaEstaticaLista(){
        Suscripcion aux1 = new Suscripcion(44069123, 385592339, "Juan", "temp@temp.com", "Calle Falsa 123");
        Suscripcion aux2 = new Suscripcion(23069124, 385592338, "Pedro", "temp@temp.com", "Falsa Calle 321");
        Suscripcion aux3 = new Suscripcion(55069125, 385592337, "Geriberto", "temp@temp.com", "321 aslaF ellaC");
        list.insertarPrim(aux1);
        list.insertarPrim(aux2);
        list.insertarPrim(aux3);
    }

    public void generarArbol(){
        if (!list.listaVacia()){
            lista.NodoLista p = list.inicio();
            while (p != null){
                abb.insertar(p);
                p = p.getPs();   
            }
        } else {
            System.out.println("Lista Vacia\n");
        }
    }
    //----------------
    
    //-----Item B-----
    
    private void listaNovedades(){
        Suscripcion aux1 = new Suscripcion(45761776, 385592339, "Pablo", "temp@temp.com", "Calle Null");
        Suscripcion aux2 = new Suscripcion(32767529, 385592338, "Limon", "temp@temp.com", "Null Calle");
        Suscripcion aux3 = new Suscripcion(44069123, 385592337, "Juan", "temp@temp.com", "Calle False 123");
        Suscripcion aux4 = new Suscripcion(68510750, 385592337, "Armando", "temp@temp.com", "lluN ellaC");
        listN.insertarPrim(aux1);
        listN.insertarPrim(aux2);
        listN.insertarPrim(aux3);
        listN.insertarPrim(aux4);
    }
    
    public void actualizarLista(){
        if (!listN.listaVacia()){
            lista.NodoLista p = listN.inicio();
            while (p != null){
                NodoArbol buscado = null;
                Suscripcion aux = (Suscripcion) p.getDato();
                buscado = abb.buscar(p);
                if (buscado != null) {
                    NodoLista aux1 = (NodoLista) buscado.getDato();
                    Suscripcion aux2 = (Suscripcion) aux1.getDato();
                    aux2.setDocumento(aux.getDocumento());
                    aux2.setNroTele(aux.getNroTele());
                    aux2.setNom(aux.getNom());
                    aux2.setCorreoElectronico(aux.getCorreoElectronico());
                    aux2.setDomicilio(aux.getDomicilio());
                    p = p.getPs();
                } else {
                    abb.insertar(p);
                }
                p = p.getPs();   
            }
        } else {
            System.out.println("Lista Vacia\n");
        }
        
    }
    
    //----------------
    
    public void menuDeOpciones() {
        int op;
        do {
            System.out.println("\n--------------------");
            System.out.println("| MENU DE OPCIONES |");
            System.out.println("--------------------");
            System.out.println("1- Generar Arbol");
            System.out.println("2- Actualizar");
            System.out.println("0- Salir");
            op = Consola.cargarInt(0, "--> ");
            switch (op) {
                case 1:
                    generarArbol();
                    System.out.println("\nARBOL GENERADO");
                    abb.entreorden();
                    break;
                case 2:
                    listaNovedades();
                    actualizarLista();
                    break;
                case 0:
                    break;
            }
        } while (op != 0);
    }
    
    public static void main(String[] args) {
        ArbolAPP app = new ArbolAPP();
        app.cargaEstaticaLista();
        app.menuDeOpciones();
    }
    
}
