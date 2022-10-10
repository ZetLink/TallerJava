package principal;

import entradaDatos.Consola;

public class principal {
    
    public static void main(String[] args) {
        int op;

        VendedorMenu.inicializarArchivo();
        AutoPlanMenu.inicializarArchivo();

        do {
            System.out.println("----------------------------------------------------");
            System.out.println("                Planes Mi Circulo S.A.              ");
            System.out.println("----------------------------------------------------");
            System.out.println("1. Actualizar AutoPlan: ");
            System.out.println("2. Actualizar Vendedor: ");
            System.out.println("0. Salir");
            System.out.print("--> ");
            op = Consola.readInt();
            switch (op) {
                case 1:
                    AutoPlanMenu.menu();
                    break;
                case 2:
                    VendedorMenu.menu();
                    break;
            }
        } while (op != 0);
    }
}