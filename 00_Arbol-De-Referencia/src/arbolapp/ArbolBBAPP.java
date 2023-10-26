package arbolapp;

import nodoAB.Nodo;
import estructuras.ArbolBinarioBusqueda;
import utilidades.Consola;

public class ArbolBBAPP {

    private ArbolBinarioBusqueda abb;

    public ArbolBBAPP() {
        abb = new ArbolBinarioBusqueda();
    }

    public void menuDeOpciones() {
        int op;
        do {
            System.out.println("====================");
            System.out.println("**MENU DE OPCIONES**");
            System.out.println("====================");
            System.out.println("1. Generar Arbol");
            System.out.println("2. Eliminar Elementos");
            System.out.println("3. Imprimir Elementos");
            System.out.println("0. Salir");
            op = Consola.readInt(0, "--> ");
            switch (op) {
                case 1:
                    generarArbol();
                    break;
                case 2:
                    borrar();
                    break;
                case 3:
                    imprimir();
                    break;
                case 0:
                    break;
            }
        } while (op != 0);
    }

    public void generarArbol() {
        do {
            int elemento = Consola.readInt(0, "Numero: ");
            Numero nro = new Numero();
            nro.setValor(elemento);
            abb.insertar(nro);
        } while (Consola.continuar());
    }

    public void borrar() {
        Numero nro = new Numero();
        Nodo b = null;
        do {
            int elemento = Consola.readInt(0, "Numero: ");
            nro.setValor(elemento);
            b = abb.borrar(abb.getRaiz(), null, nro, b);
            if (b != null) {
                System.out.println("EL ELEMENTO ELMINADOS ES: " + b.getDato());
            } else {
                System.out.println("EL ELEMENTO NO EXISTE");
            }
        } while (Consola.continuar());
    }

    public void imprimir() {
        int op;
        do {
            System.out.println("====================");
            System.out.println("**MENU DE IMPRESION**");
            System.out.println("====================");
            System.out.println("1. Imprimir EntreOrden");
            System.out.println("2. Imprimir PreOrden");
            System.out.println("3. Imprimir PostOrden");
            System.out.println("0. Volver al Menu Principal");
            op = Consola.readInt(0, "--> ");
            switch (op) {
                case 1:
                    abb.entreorden();
                    break;
                case 2:
                    abb.preorden();
                    break;
                case 3:
                    abb.postorden();
                    break;
                case 0:
                    break;
            }
        } while (op != 0);
    }

    public static void main(String[] args) {
        ArbolBBAPP MiArbol = new ArbolBBAPP();
        MiArbol.menuDeOpciones();
    }
}
