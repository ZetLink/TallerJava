package principal;

import entradaDatos.Consola;

public class principal {
    
    public static void main(String[] args) {
        int op;

        SociosMenu.inicializarArchivo();
        BarcosMenu.inicializarArchivo();

        do {
            System.out.println("----------------------------------------------------");
            System.out.println("                     Club Nautico                   ");
            System.out.println("----------------------------------------------------");
            System.out.println("1. Actualizacion de Barcos: ");
            System.out.println("2. Actualizacion de Socios: ");
            System.out.println("0. Salir");
            System.out.print("--> ");
            op = Consola.readInt();
            switch (op) {
                case 1:
                    BarcosMenu.menu();
                    break;
                case 2:
                    SociosMenu.menu();
                    break;
            }
        } while (op != 0);
    }
}
