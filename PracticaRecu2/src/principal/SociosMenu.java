package principal;

import persistencia.*;
import datos.*;
import entradaDatos.*;

public class SociosMenu {
    private static Archivo m2;

    public static Registro cargarPersonal() {
        Socios pers = new Socios();
        int codigo;
        do {
            System.out.print("Codigo de Socio: ");
            codigo = Consola.readInt();
            if (obtener(codigo) != null) {
                System.out.println("Codigo ya existente.");
                codigo = -1;
            }
        } while (codigo < 0 || codigo > pers.tamArchivo());
        pers.setCod_S(codigo);
        pers.cargarDatos();
        Registro reg = new Registro(pers, pers.getCod_S());
        return reg;
    }

    public static Socios obtener(int codigo) {
        m2.abrirParaLectura();
        m2.buscarRegistro(codigo);
            if (m2.eof()) {
                return null;
            }
            Registro reg = m2.leerRegistro();
                if (!reg.getActivo()) {
                    return null;
                }
        Socios art = (Socios) reg.getDatos();
        m2.cerrarArchivo();

        return art;
    }
    
    public static void mostrarApe_Nom(int cod) {
        m2.abrirParaLectura();
        m2.irPrincipioArchivo();
        while (!m2.eof()) {
            Registro reg = m2.leerRegistro();
            if (reg.getActivo() && reg.getNroOrden() == cod) {
                Socios aux = (Socios) reg.getDatos();
                System.out.println("Investigador: " + aux.getApe_Nom());
            }
        }
        m2.cerrarArchivo();
    }

    public static void cargar() {
        m2.abrirParaLeerEscribir();
        try {
            do {
                Registro reg = cargarPersonal();
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
    
    public static void barcoPorSocio(int cod) {
        m2.abrirParaLectura();
        m2.irPrincipioArchivo();
        while (!m2.eof()) {
            Registro reg = m2.leerRegistro();
            if (reg.getActivo()) {
                Socios aux = (Socios) reg.getDatos();
                System.out.println("Socio " + aux.getApe_Nom());
                BarcosMenu.mostrarPorSocio(cod);
            }
        }
        m2.cerrarArchivo();
        Consola.pausa();
    }
    
    public static void inicializarArchivo() {
        try {
            m2 = new Archivo("Socios.dat", new Socios());
            if (!m2.getFd().exists()){
                m2.crearArchivoVacio(new Registro(new Socios(), 0));
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
        while (!m2.eof()) {
            reg = m2.leerRegistro();
            if (reg.getActivo()){
                reg.mostrarRegistro();
            }
        }
        m2.cerrarArchivo();
    }
    
    public static void menu() {
        int op;
        Registro reg;

        do {
            System.out.println("----------------------------------------------------");
            System.out.println("               Actualizacion de Socios              ");
            System.out.println("----------------------------------------------------");
            System.out.println("1. Alta");
            System.out.println("2. Listado de Barcos por Socios");
            System.out.println("3. Mostrar Vendedores Activos (NO TOCAR)");
            System.out.println("0. Salir");
            System.out.print("--> ");
            op = Consola.readInt();
            switch (op) {
                case 1:
                    cargar();
                    break;
                case 2:
                    System.out.print("Codigo del Socio: ");
                    int aux = Consola.readInt();
                    barcoPorSocio(aux);
                    break;
                case 3:
                    mostrar();
                    break;
            }
        } while (op != 0);

    }
}