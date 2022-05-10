package paqueteLSE;

import java.util.Scanner;

public class ListaApp {

    Scanner ingreso = new Scanner(System.in); //Libreria para ingresar 

    Lista miLista;

    public ListaApp() { //Iniciar la lista
        miLista = new Lista();
    }

    public void generar() { //Ingresar los datos de la Lista
        int elem = -1;
        while (elem != 0) {
            System.out.println("Ingrese elemento (0 p/cancelar): ");
            elem = ingreso.nextInt();
            if (elem != 0) {
                miLista.insertarpri(elem);
            }
        }
    }

    public void borrar() {
        int elem = -1;
        while (elem != 0) {
            System.out.println("Ingrese un elemento (0 p/cancelar): ");
            elem = ingreso.nextInt();
            if (elem != 0) {
                Nodo x = miLista.eliminar(elem);
                System.out.println("Elemento eliminado!\n");
            }
        }
    }

    public void imprimir() {
        Nodo p = miLista.Inicio();
        while (p != null) {
            System.out.println(p.getDato() + "");
            p = p.getPs();
        }
    }

    public void modificar() {
        Nodo p = miLista.Inicio();
        while (p != null) {
            p.setDato(p.getDato() + 10);
            p = p.getPs();
        }
        System.out.println("Lista modificada sumando 10!\n");
    }

    public boolean verificar() {
        if (miLista.listaVacia()) {
            System.out.println("Lista vacía!\n");
            return false;
        }
        return true;
    }

    public void menu() {
        int opcion = 9;
        do {
            switch (opcion) {
                case 1:
                    generar();
                    break;
                case 2:
                    if (verificar()) {
                        imprimir();
                    }
                    break;
                case 3:
                    if (verificar()) {
                        borrar();
                    }
                    break;
                case 4:
                    if (verificar()) {
                        modificar();
                    }
                    break;

            }
            mostrarOpciones();
            opcion = ingreso.nextInt();
            System.out.println("--------->");

        } while (opcion != 0);
    }

    public void mostrarOpciones() {
        System.out.println("\nManejo de listas simples enlazadas");
        System.out.println("1- Cargar");
        System.out.println("2- Imprimir");
        System.out.println("3- Borrar");
        System.out.println("4- Modificar");
        System.out.println("0- Salir");
        System.out.println("--------->");

    }

    public static void main(String[] args) {

        ListaApp miListaApp = new ListaApp();
        miListaApp.menu();
    }
}
