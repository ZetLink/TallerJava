package principal;

import utilidades.Consola;
import utilidades.Tablas;
import lista.*;
import arbol.*;

public class App {

    Arbol arb = new Arbol();
    Lista ls = new Lista();
    Lista ln = new Lista();
    
    private void cargarLista(){
        Socio aux1 = new Socio(44069123, 385592339, "Juan", "temp@temp.com", "Calle Falsa 123");
        Socio aux2 = new Socio(23069124, 385592338, "Pedro", "temp@temp.com", "Falsa Calle 321");
        Socio aux3 = new Socio(55069125, 385592337, "Geriberto", "temp@temp.com", "321 aslaF ellaC");
        ls.insertar(aux1);
        ls.insertar(aux2);
        ls.insertar(aux3);
        Consola.prtGreen("Lista Cargada\n");
    }
    
    private void mostrarLista(){
        if (!ls.listaVacia()){
            NodoL p = ls.inicio();
            String formato = "| %-10s | %-12s | %-15s | %-15s | %-15s |";
            while (p != null){
                Socio oTemp = (Socio) p.getDato();
                System.out.println(String.format(formato, oTemp.getDni(),oTemp.getTel(), oTemp.getNom(), oTemp.getCorreo(), oTemp.getDomicilio()));
                p = p.getPs();
            }
        } else {
            Consola.prtRed("Lista Vacia");
        } 
        System.out.println(" ");
    }
    
    private void generarArbol(){
        if (!ls.listaVacia()){
            NodoL p = ls.inicio();
            while (p != null) {
                arb.insertar(p);
                p = p.getPs();
            }
            Consola.prtGreen("Arbol Generado");
        } else {
            Consola.prtRed("Lista Vacia");
        }
        System.out.println(" ");
    }
    
    public void mostrarArbol(NodoA r){
        if (!arb.esVacio()){
            if (r != null) {
                mostrarArbol(r.getPI());
                System.out.println("DNI: " + r.getDni());
                System.out.println("Nodo Lista: " + r.getDir());
                mostrarArbol(r.getPD());
            }
        } else {
            Consola.prtRed("Arbol Vacio");
        }
        System.out.println(" ");
    }
    
    private void cargarListaNovedades(){
        Socio aux1 = new Socio(45761776, 385592339, "Pablo", "temp@temp.com", "Calle Null");
        Socio aux2 = new Socio(32767529, 385592338, "Limon", "temp@temp.com", "Null Calle");
        Socio aux3 = new Socio(44069123, 385592337, "Juan", "temp@temp.com", "Calle False 123");
        Socio aux4 = new Socio(68510750, 385592337, "Armando", "temp@temp.com", "lluN ellaC");
        ln.insertar(aux1);
        ln.insertar(aux2);
        ln.insertar(aux3);
        ln.insertar(aux4);
        Consola.prtGreen("Lista Novedades Cargada\n");
    }
    
    private void actualizarArbol(){
        if (!arb.esVacio()){
            NodoL p = ln.inicio();
            while (p != null){
                NodoL k = arb.buscar(arb.getRaiz(), p, null);
                if (k != null){
                    Consola.prtGreen("Socio Actualizado");
                    k.getDato().setDni(p.getDato().getDni());
                    k.getDato().setTel(p.getDato().getTel());
                    k.getDato().setNom(p.getDato().getNom());
                    k.getDato().setCorreo(p.getDato().getCorreo());
                    k.getDato().setDomicilio(p.getDato().getDomicilio());
                } else {
                    NodoA x = new NodoA(p.getDato().getDni(), p);
                    ls.insertar(p.getDato());
                    arb.insertar(p);
                    Consola.prtGreen("Nuevo Socio Agregado");
                }
                p = p.getPs();
            }
        } else {
            Consola.prtRed("Arbol Vacio");
        }
        System.out.println(" ");
    }
    
    public void menu(){
        int op;
        do {
            String[] opciones = {"Menu", "1- Generar Lista", "2- Mostrar Lista", "3- Generar Arbol", "4- Mostrar Arbol", "5- Cargar Lista Novedades", "6- Actualizar Arbol", "0- Salir"};
            Tablas.imprimirArrayVertical(opciones, 5);
            op = Consola.readInt(0, "--> ");
            System.out.println(" ");
            switch (op) {
                case 1:
                    cargarLista();
                    break;
                case 2:
                    mostrarLista();
                    break;
                case 3:
                    generarArbol();
                    break;
                case 4:
                    mostrarArbol(arb.getRaiz());
                    break;
                case 5:
                    cargarListaNovedades();
                    break;
                case 6:
                    actualizarArbol();
                    break;
                case 0:
                    break;
            }
        } while (op != 0);
    }
    
    public static void main(String[] args) {
        App app = new App();
        app.menu();
    }
    
}
