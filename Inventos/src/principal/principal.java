package principal;

import entradaDatos.Consola;

public class principal {
    
    public static void main(String[] args) {
        int op;

        PersonalMenu.inicializarArchivo();
        InventosMenu.inicializarArchivo();

        do {
            System.out.println("----------------------------------------------------");
            System.out.println("                    MENU PRINCIPAL                  ");
            System.out.println("----------------------------------------------------");
            System.out.println("1. Cargar Inventigador: ");
            System.out.println("2. Actualizacion de Inventos: ");
            System.out.println("0. Salir");
            System.out.print("--> ");
            op = Consola.readInt();
            switch (op) {
                case 1:
                    PersonalMenu.menu();
                    break;
                case 2:
                    InventosMenu.menu();
                    break;
            }
        } while (op != 0);
    }
}
