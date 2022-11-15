package principal;

import consola.Consola;
import lista.*;
import arbol.*;

public class principal {
    
    Lista list = new Lista();
    private ArbolBinarioBusqueda abb;
    
    public principal() {
        abb = new ArbolBinarioBusqueda();
    }
    
    //-----GENERAR-----
    public void generarLista(){
        list.insertarPrim(new Suscripcion(123, "AwA de OwO", "Argentina", "Calle Falsa 123", 'E', 'A', 1200));
        list.insertarPrim(new Suscripcion(456, "OwO de AwA", "Argentina", "Falsa Calle 321", 'E', 'M', 1000));
        list.insertarPrim(new Suscripcion(254, "UwU de OwO", "Argentina", "Falsa Calle 123", 'E', 'A', 1500));
        list.insertarPrim(new Suscripcion(785, "AwA de EwE", "Argentina", "Calle Falsa 123", 'M', 'M', 2000));
    }
    
    public void generarArbol(){
        if (!list.listaVacia()){
            LSE.NodoLista p = list.inicio();
            while (p != null){
                abb.insertar(p);
                p = p.getPs();   
            }
        } else {
            System.out.println("Lista Vacia\n");
        }
    }
    //-----------------
    
    //-----Actualizar-----
    public void actualizarLista() {
        int buscado = Consola.cargarInt(0, "DNI Buscado: ");
        NodoArbol aux = abb.buscar(buscado);
        if (aux != null) {
            NodoLista uwu = (NodoLista) aux.getDato();
            Suscripcion sub = (Suscripcion) uwu.getDato();
            System.out.println("Costo Antiguo: " + sub.getCosto());
            if(sub.getPais() == "Argentina" && sub.getFdp() == 'E') {
		if(sub.getTds() == 'M') {
                    sub.setCosto((float) (sub.getCosto() + sub.getCosto() * 0.07));
                } else {
                    sub.setCosto((float) (sub.getCosto() + sub.getCosto() * 0.30));
		}
            }
            System.out.println("Costo Nuevo: " + sub.getCosto());
            System.out.println("Actualizacion completada!!!");
            } else {
            System.out.println("DNI inexistente!!!");
            }
	}
    //--------------------
    
    //-----Eliminar-----
    public void eliminarSuscriptor(){
        int dni = Consola.cargarInt(0, "DNI Buscado: ");
        abb.borrar(abb.getRaiz(), null, dni, null);
        list.eliminar(dni);
    }
    //------------------
    
    //-----Mostrar-----   
    public void mostrar(){
        list.imprimirDatos();
    }
    //-----------------
    
    public void menuDeOpciones() {
        int op;
        do {
            System.out.println("\n--------------------");
            System.out.println("| MENU DE OPCIONES |");
            System.out.println("--------------------");
            System.out.println("1- Generar Arbol");
            System.out.println("2- Actualizar");
            System.out.println("3- Eliminar");
            System.out.println("4- Mostrar");
            System.out.println("0- Salir");
            op = Consola.cargarInt(0, "--> ");
            switch (op) {
                case 1:
                    generarLista();
                    generarArbol();
                    System.out.println("\nARBOL GENERADO");
                    abb.entreorden();
                    break;
                case 2:
                    actualizarLista();
                    break;
                case 3:
                    eliminarSuscriptor();
                case 4:
                    System.out.println(" ");
                    mostrar();
                case 0:
                    break;
            }
        } while (op != 0);
    }
    
    public static void main(String[] args) {
        principal app = new principal();
        app.menuDeOpciones();
    }
    
}
