package principal;

import Arbol.*;
import Consola.Consola;
import LSE.*;

public class principal {
    
    Lista list = new Lista();
    private ArbolBinarioBusqueda abb;
    
    public principal() {
        abb = new ArbolBinarioBusqueda();
    }
    
    //-----GENERAR-----
    public void generarLista(){
        list.insertarPrim(new Reclamos(123, "AwA de OwO", "Si", "12/28/2022", 1));
        list.insertarPrim(new Reclamos(456, "OwO de AwA", "No", "05/07/1983", 2));
        list.insertarPrim(new Reclamos(254, "UwU de OwO", "Nose", "12/05/1999", 1));
        list.insertarPrim(new Reclamos(785, "AwA de EwE", "uwu?", "09/12/2015", 2));
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
    
    //-----Procesar Reclamo-----
    
    public void procesarReclamo(){
        int dni = Consola.cargarInt(0, "DNI Buscado: ");
        NodoArbol aux = abb.buscar(dni);
        if (aux.getDocumento() != dni){
            NodoLista aux2 = (NodoLista) aux.getDato();
            Reclamos aux3 = (Reclamos) aux2.getDato();
            aux3.setEstado(2);
            aux3.setFecha("12/11/2022");
        } else {
            System.out.println("DNI Inexistente");
        }
    }
    
    //-------------------------
    
    //-----Eliminar-----
    public void eliminarSuscriptor(){
        int estado = 2;
        int cant = list.cantSoluc();
        for (int i = 0; i <= cant; i++) {
            abb.borrar(abb.getRaiz(), null, estado, null);
        }
        abb.borrar(abb.getRaiz(), null, estado, null);
        list.eliminar();
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
            System.out.println("1- Agregar Reclamos");
            System.out.println("2- Generar Arbol");
            System.out.println("3- Proceso de Reclamos");
            System.out.println("4- Eliminar Reclamos");
            System.out.println("5- Mostrar");
            System.out.println("0- Salir");
            op = Consola.cargarInt(0, "--> ");
            switch (op) {
                case 1:
                    generarLista();
                    break;
                case 2:
                    generarArbol();
                    System.out.println("\nARBOL GENERADO");
                    list.imprimirDatos();
                    break;
                case 3:
                    procesarReclamo();
                    break;
                case 4:
                    eliminarSuscriptor();
                    break;
                case 5:
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
