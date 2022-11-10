package Principal;

import Consola.Consola;

public class principal {

    ListaMenu lM = new ListaMenu();
    ArbolMenu aM = new ArbolMenu();
    
    public void menu(){
        int op;

        do {
            System.out.println("----------------------------------------------------");
            System.out.println("                    MENU PRINCIPAL                  ");
            System.out.println("----------------------------------------------------");
            System.out.println("1. Lista Menu");
            System.out.println("2. Arbol Menu");
            System.out.println("0. Salir");
            System.out.print("--> ");
            op = Consola.readInt();
            switch (op) {
                case 1:
                    lM.menu();
                    break;
                case 2:
                    //aM.menu();
                    break;
            }
        } while (op != 0);
    }
    
    public static void main(String[] args) {
        principal app = new principal();
        app.menu();
    }
    
}
