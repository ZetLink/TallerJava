package principal;

import arbol.Arbol;
import arbol.Persona;
import arbol.NodoArbol;
import utilidades.Consola;

public class Principal {

    Arbol abb = new Arbol();
    
    public void cargarArbol(){
        do {
            Persona oTemp = new Persona();
            oTemp.cargarDatos();
            abb.insertar(oTemp);
        } while (Consola.continuar());
    }
    
    public void eliminarNodo(){
        int dni = Consola.readInt(0, "DNI: ");
        NodoArbol q = abb.borrar(abb.obtenerRaiz(), null, dni, null);
    }
    
    public void mostrarArbol(){
        int op;
        do {
            System.out.println("\n--------------------");
            System.out.println("|  MENU DE MOSTRAR |");
            System.out.println("--------------------");
            System.out.println("1- Preorden");
            System.out.println("2- Entreorden");
            System.out.println("3- Postorden");
            System.out.println("0- Salir");
            op = Consola.readInt(0, "--> ");
            switch (op) {
                case 1:
                    abb.preorden();
                    break;
                case 2:
                    abb.entreorden();
                    break;
                case 3:
                    abb.postorden();
                    break;
                case 0:
                    break;
            }
        } while (op != 0);
    }
    
    public void actualizarNodo(){
        int dni = Consola.readInt(0, "DNI: ");
        Persona oTemp = abb.buscar(abb.obtenerRaiz(), dni, null);
        if (oTemp != null){
            if (oTemp.getDni() == dni){
                abb.borrar(abb.obtenerRaiz(), null, dni, null);
                oTemp.cargarDatos();
                abb.insertar(oTemp);
            }
        } else {
            Consola.prtRed("Nodo No Encontrado");
        }
    }
    
    public void menu(){
        int op;
        do {
            System.out.println("\n--------------------");
            System.out.println("| MENU DE OPCIONES |");
            System.out.println("--------------------");
            System.out.println("1- Cargar Arbol");
            System.out.println("2- Eliminar Nodo");
            System.out.println("3- Mostrar Arbol");
            System.out.println("4- Actualizar Nodo");
            System.out.println("0- Salir");
            op = Consola.readInt(0, "--> ");
            switch (op) {
                case 1:
                    cargarArbol();
                    break;
                case 2:
                    eliminarNodo();
                    break;
                case 3:
                    mostrarArbol();
                    break;
                case 4:
                    actualizarNodo();
                    break;
                case 0:
                    break;
            }
        } while (op != 0);
    }
    
    public static void main(String[] args) {
        Principal app = new Principal();
        app.menu();
    }
    
}
