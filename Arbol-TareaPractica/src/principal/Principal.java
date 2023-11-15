package principal;

import arbol.Arbol;
import arbol.Palabra;
import arbol.NodoArbol;
import utilidades.Consola;

public class Principal {

    Arbol abb = new Arbol();
    
    public void cargarArbol(){
        do {
            Palabra oTemp = new Palabra();
            oTemp.cargarDatos();
            abb.insertar(oTemp);
        } while (Consola.continuar());
    }
    
    public void eliminarNodo(){
        do {
            int codigo = Consola.readInt(0, "DNI a Eliminar: ");
            NodoArbol q = abb.borrar(abb.obtenerRaiz(), null, codigo, null);
            if (q != null){
                Consola.prtGreen("Nodo Eliminado\n");
            } else {
                Consola.prtRed("Nodo No Encontrado\n");
            }
        } while (Consola.continuar());
    }
    
    public void mostrarArbol(){
        if (abb.obtenerRaiz() != null){
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
        } else {
            Consola.prtRed("Arbol Vacio");
        }
        
    }
    
//    public void actualizarNodo(){
//        int dni = Consola.readInt(0, "DNI: ");
//        Palabra oTemp = abb.buscar(abb.obtenerRaiz(), dni, null);
//        if (oTemp != null){
//            if (oTemp.getCod() == dni){
//                abb.borrar(abb.obtenerRaiz(), null, dni, null);
//                System.out.println("--- Nuevos Datos ---");
//                oTemp.cargarDatos();
//                abb.insertar(oTemp);
//            }
//        } else {
//            Consola.prtRed("Nodo No Encontrado");
//        }
//    }
    
    public void buscarPalabra(){
        int cod = Consola.readInt(0, "Palabra Buscada: ");
        Palabra oTemp = abb.buscar(abb.obtenerRaiz(), cod, null);
        if (oTemp != null){
            if (oTemp.getCod() == cod){
                System.out.println("Palabra: " + oTemp.getPalabra());
                System.out.println("Sector: " + oTemp.getSector());
            }
        } else {
            Consola.prtRed("No existe la palabra buscada\n");
        }
    }
    
    public void menu(){
        int op;
        do {
            System.out.println("\n--------------------");
            System.out.println("| MENU DE OPCIONES |");
            System.out.println("--------------------");
            System.out.println("1- Cargar Palabra");     //Item B
            System.out.println("2- Eliminar Palabra");   //Item D
            System.out.println("3- Mostrar Arbol");      //Item C
            System.out.println("4- Buscar Palabra");     //Item A
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
                    buscarPalabra();
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
