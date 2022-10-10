package principal;

import persistencia.*;
import datos.*;
import consola.*;

public class CursoMenu {
    private static Archivo m2;

    public static Registro cargarCurso() {
        curso pers = new curso();
        int codigo;
        do {
            System.out.print("Codigo: ");
            codigo = Consola.readInt();
            if (obtener(codigo) != null) {
                System.out.println("Codigo ya existente.");
                codigo = -1;
            }
        } while (codigo < 0 || codigo > pers.tamArchivo());
        pers.setCod_C(codigo);
        pers.cargarDatos();
        Registro reg = new Registro(pers, pers.getCod_C());
        return reg;
    }

    public static curso obtener(int codigo) {
        m2.abrirParaLectura();
        m2.buscarRegistro(codigo);
            if (m2.eof()) {
                return null;
            }
            Registro reg = m2.leerRegistro();
                if (!reg.getActivo()) {
                    return null;
                }
        curso art = (curso) reg.getDatos();
        m2.cerrarArchivo();

        return art;
    }
    
//    Metodo para mostrar un string en base a un codigo dado
    
//    public static void mostrarApe_Nom(int cod) {
//        m2.abrirParaLectura();
//        m2.irPrincipioArchivo();
//        while (!m2.eof()) {
//            Registro reg = m2.leerRegistro();
//            if (reg.getActivo() && reg.getNroOrden() == cod) {
//                curso aux = (curso) reg.getDatos();
//                System.out.println("Investigador: " + aux.getApe_Nom());
//            }
//        }
//        m2.cerrarArchivo();
//    }

    public static void cargar() {
        m2.abrirParaLeerEscribir();
        try {
            do {
                Registro reg = cargarCurso();
                m2.cargarUnRegistro(reg);
                reg.mostrarRegistro();
            } while (Consola.deseaContinuar());
        } catch (Exception e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
            System.exit(1);
        }
        m2.cerrarArchivo();
    }
    
    public static boolean verificarExistencia(int codigo){
        boolean b = false;
        Registro reg;
        m2.abrirParaLeerEscribir();
        m2.irPrincipioArchivo();
        while (!m2.eof()) {
            reg = m2.leerRegistro();
            if (reg.getActivo() && reg.getNroOrden() == codigo){
                b = true;
            }
        }
        m2.cerrarArchivo();
        return b;
    }
    
    public static void inicializarArchivo() {
        try {
            m2 = new Archivo("Cursos.dat", new curso());
            if (!m2.getFd().exists()){
                m2.crearArchivoVacio(new Registro(new curso(), 0));
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error al crear los descriptores de archivos: " + e.getMessage());
            System.exit(1);
        }
    }

    public static void mostrar() {
        Registro reg;
        m2.abrirParaLeerEscribir();
        m2.irPrincipioArchivo();
        System.out.println("-----------Cursos----------");
        System.out.println("|  Codigo       Grado     |");
        System.out.println("---------------------------");
        while (!m2.eof()) {
            reg = m2.leerRegistro();
            if (reg.getActivo()){
                curso aux = (curso) reg.getDatos();
                System.out.println("|       " + aux.getCod_C() + " |     " + aux.getAnio() + "° '" + aux.getDivision() + "'    |");
            }
        }
        System.out.println("---------------------------");
        m2.cerrarArchivo();
    }
    
    public static void menu() {
        int op;
        Registro reg;

        do {
            System.out.println("----------------------------------------------------");
            System.out.println("                  Control de Cursos                 ");
            System.out.println("----------------------------------------------------");
            System.out.println("1. Alta");
            System.out.println("2. Listado de Cursos");
            System.out.println("0. Salir");
            System.out.print("--> ");
            op = Consola.readInt();
            switch (op) {
                case 1:
                    cargar();
                    break;
                case 2:
                    mostrar();
                    break;

            }
        } while (op != 0);
    }
}