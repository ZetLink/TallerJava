
import java.util.Scanner;

public class ListaApp {

    Scanner ingreso = new Scanner(System.in);

    Lista miLista;

    public ListaApp() {
        miLista = new Lista();
    }

    public void generar() {
        int elem = -1;
        while (elem != 0) {
            prt("Ingrese elemento (0 p/cancelar): ");
            elem = ingreso.nextInt();
            if (elem != 0) {
                miLista.insertar(elem);
            }
        }
    }

    public void borrar() {
        int elem = -1;
        while (elem != 0) {
            prt("Ingrese un elemento (0 p/cancelar): ");
            elem = ingreso.nextInt();
            if (elem != 0) {
                Nodo x = miLista.eliminar(elem);
            }
        }
    }

    public void imprimir() {
        Nodo p = miLista.inicio();
        while (p != null) {
            prt(p.getDato() + "");
            p = p.getPs();
        }
    }

    public boolean verificar() {
        if (miLista.listaVacia()) {
            prt("Lista vacía!");
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

            }
            mostrarOpciones();
            opcion = ingreso.nextInt();
            prt("--------->");

        } while (opcion != 0);
    }

    public void mostrarOpciones() {
        prt("Manejo de listas simples enlazadas");
        prt("1- Cargar");
        prt("2- Imprimir");
        prt("3- Borrar");
        prt("0- Salir");
        prt("--------->");

    }

    public void prt(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {

        ListaApp miListaApp = new ListaApp();
        miListaApp.menu();

    }

}
