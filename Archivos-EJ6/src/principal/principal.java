package principal;

import consola.Consola;

public class principal {
    
//    Long: 8 bytes
//    Integer: 4 bytes
//    Short: 2 bytes
//    Byte: 1 byte
//    Double: 8 bytes
//    Float: 4 bytes
//    Boolean: 1 byte
//    Char: 2 bytes
//    String: 2 bytes por cada caracter
    
    public static void main(String[] args) {
        int op;

        CursoMenu.inicializarArchivo();
        AlumnosMenu.inicializarArchivo();

        do {
            System.out.println("----------------------------------------------------");
            System.out.println("                    MENU PRINCIPAL                  ");
            System.out.println("----------------------------------------------------");
            System.out.println("1. Control de Cursos: ");
            System.out.println("2. Actualizacion de Alumnos: ");
            System.out.println("0. Salir");
            System.out.print("--> ");
            op = Consola.readInt();
            switch (op) {
                case 1:
                    CursoMenu.menu();
                    break;
                case 2:
                    AlumnosMenu.menu();
                    break;
            }
        } while (op != 0);
    }
}
