package principal;

import arbol.Arbol;
import arbol.Persona;
import arbol.NodoArbol;
import lista.*;
import utilidades.Consola;

public class Principal {

    Arbol abb = new Arbol();
    LSE l1 = new LSE();
    LSE l2 = new LSE();
    
    //----- Metodos de Lista -----
    public void cargarLista(){
        Persona pers1 = new Persona(34568345, "Juan Perez", 385592339);
        Persona pers2 = new Persona(23456789, "María González", 5555678);
        Persona pers3 = new Persona(34567890, "Carlos Rodríguez", 5559012);
        Persona pers4 = new Persona(45678901, "Laura Martínez", 5553456);
        Persona pers5 = new Persona(56789012, "Alejandro López", 5557890);
        l1.insertar(pers1);
        l1.insertar(pers2);
        l1.insertar(pers3);
        l1.insertar(pers4);
        l1.insertar(pers5);
    }
    
    public void mostrarLista(){
        NodoLista p = l1.inicio();
        while (p != null){
            Persona oTemp = p.getDato();
            oTemp.imprimirDato();
            p = p.getPs();
        }
    }
    
    public void nuevaLista(){
        Persona pers1 = new Persona(34568345, "Juan Juan", 22222222);
        Persona pers2 = new Persona(89567923, "María González", 5555678);
        Persona pers3 = new Persona(34567890, "Carlos Carlos", 1111111);
        Persona pers4 = new Persona(86947285, "Laura Martínez", 5553456);
        Persona pers5 = new Persona(55835235, "Alejandro López", 5557890);
        l2.insertar(pers1);
        l2.insertar(pers2);
        l2.insertar(pers3);
        l2.insertar(pers4);
        l2.insertar(pers5);
    }
    
    //----- Metodos de Arbol -----
    
//    public void cargarArbol(){
//        do {
//            Persona oTemp = new Persona();
//            oTemp.cargarDatos();
//            abb.insertar(oTemp);
//        } while (Consola.continuar());
//    }
    
    public void cargarArbol(){
        if (!l1.listaVacia()){
            NodoLista p = l1.inicio();
            while (p != null){
                abb.insertar(p);
                p = p.getPs();
            }
        } else {
            Consola.prtRed("Lista Vacia\n");
        }
    }
    
    public void eliminarNodo(){
        int dni = Consola.readInt(0, "DNI: ");
        NodoLista p = l1.inicio();
        while (p != null){
            if (p.getDato().getDni() == dni){
                NodoArbol q = abb.borrar(abb.obtenerRaiz(), null, p, null);
            }
        }
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
    
//    public void actualizarNodo(){
//        int dni = Consola.readInt(0, "DNI: ");
//        Persona oTemp = abb.buscar(abb.obtenerRaiz(), dni, null);
//        if (oTemp != null){
//            if (oTemp.getDni() == dni){
//                abb.borrar(abb.obtenerRaiz(), null, dni, null);
//                oTemp.cargarDatos();
//                abb.insertar(oTemp);
//            }
//        } else {
//            Consola.prtRed("Nodo No Encontrado");
//        }
//    }
    
    public void actualizarCNL(){
        nuevaLista(); //Cargar la nueva lista
        if (!l2.listaVacia()){
            NodoLista p = l2.inicio();
            while (p != null){
                NodoArbol buscado = null;
                Persona aux = (Persona) p.getDato();
                buscado = abb.buscar(p);
                if (buscado != null){
                    NodoLista aux1 = (NodoLista) buscado.getDato();
                    Persona aux2 = (Persona) aux1.getDato();
                    aux2.setDni(aux.getDni());
                    aux2.setNom(aux.getNom());
                    aux2.setTel(aux.getTel());
                    p = p.getPs();
                } else {
                    abb.insertar(p);
                }
                p = p.getPs();
            }
        } else {
            Consola.prtRed("Lista Nueva Vacia!!!\n");
        }
    }
    
    public void menu(){
        int op;
        do {
            System.out.println("\n--------------------");
            System.out.println("| MENU DE OPCIONES |");
            System.out.println("--------------------");
            System.out.println("1- Generar Lista");
            System.out.println("2. Mostrar Lista");
            System.out.println("3- Cargar Arbol");
            System.out.println("4- Eliminar Nodo");
            System.out.println("5- Mostrar Arbol");
            System.out.println("6- Actualizar Nodo");
            System.out.println("0- Salir");
            op = Consola.readInt(0, "--> ");
            switch (op) {
                case 1:
                    cargarLista();
                    break;
                case 2:
                    mostrarLista();
                    break;
                case 3:
                    cargarArbol();
                    break;
                case 4:
                    eliminarNodo();
                    break;
                case 5:
                    mostrarArbol();
                    break;
                case 6:
                    actualizarCNL();
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
