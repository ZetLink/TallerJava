package principal;

import persistencia.*;
import datos.*;
import entradaDatos.*;

public class AutoPlanMenu {
    private static Archivo m2;
    
    public static void mostrarTodo() {
        Registro reg;
        m2.abrirParaLeerEscribir();
        m2.irPrincipioArchivo();
        while (!m2.eof()) {
            reg = m2.leerRegistro();
            reg.mostrarRegistro();
        }
        m2.cerrarArchivo();
    }

    public static int cantidad() {
        m2.abrirParaLectura();
        m2.irPrincipioArchivo();
        int contador = 0;
        while (!m2.eof()) {
            Registro reg = m2.leerRegistro();
            if (reg.getActivo()) {
                contador++;
            }
        }
        m2.cerrarArchivo();
        return contador;
    }

    public static void listarAutoPlan() {
        m2.abrirParaLectura();
        m2.irPrincipioArchivo();
        while (!m2.eof()) {
            Registro reg = m2.leerRegistro();
            if (reg.getActivo()) {
                //autoplan aux = (autoplan) reg.getDatos();
                reg.mostrarRegistro();
            }
        }
        m2.cerrarArchivo();
        Consola.pausa();
    }

    public static Registro cargarAutoPlan() {
        autoplan inv = new autoplan();
        int codigo;
        System.out.print("Codigo--> ");
        codigo = Consola.readInt();
        
        do {
            if (obtener(codigo) != null) {
            System.out.println("Codigo ya existente.");
            codigo = -1;
            }
        } while (codigo < 0 || codigo > inv.tamArchivo());
        inv.setCod_S(codigo);
        inv.cargarDatos();
        Registro reg = new Registro(inv, inv.getCod_S());
        return reg;
    }

    public static autoplan obtener(int codigo) {
        m2.abrirParaLectura();
        m2.buscarRegistro(codigo);
        if (m2.eof()) {
            return null;
        }
        Registro reg = m2.leerRegistro();
        if (!reg.getActivo()) {
            return null;
        }
        autoplan art = (autoplan) reg.getDatos();
        m2.cerrarArchivo();

        return art;
    }

    public static void cargar() {
        m2.abrirParaLeerEscribir();
        try {
            do {
                Registro reg = cargarAutoPlan();
                m2.cargarUnRegistro(reg);
            } while (Consola.deseaContinuar());
        } catch (Exception e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
            System.exit(1);
        }
        m2.cerrarArchivo();
    }

//    NO SE USA BAJA EN ESTE PROYECTO    
//    public static void baja() {
//        Registro reg = new Registro(new autoplan(), 0);
//        reg.cargarNroOrden();
//        m2.bajaRegistro(reg);
//        Consola.pausa();
//    }

    
//    NO SE USA MODIFICACAR EN ESTE PROYECTO    
//    public static void modificar() {
//        System.out.print("Codigo a modificar--> ");
//        int codigo = Consola.readInt();
//
//        m2.abrirParaLeerEscribir();
//        m2.buscarRegistro(codigo);
//        if (m2.eof()) {
//            System.out.println("No existe el registro");
//            Consola.pausa();
//            return;
//        }
//
//        Registro reg = m2.leerRegistro(); // Lee el registro existente
//        Personal art = (Personal) reg.getDatos();
//        art.cargarDatos();
//        reg.setDatos(art);
//        m2.cargarUnRegistro(reg); // Sobreescribe el registro ya existente
//
//        m2.cerrarArchivo();
//
//        System.out.println("Registro modificado");
//        Consola.pausa();
//    }
    
    public static void mostrarPorVendedor(int cod){
       m2.abrirParaLectura();
        m2.irPrincipioArchivo();
        while (!m2.eof()) {
            Registro reg = m2.leerRegistro();
            if (reg.getActivo()) {
                autoplan aux = (autoplan) reg.getDatos();
                if (aux.getCod_V() == cod){
                    aux.mostrarRegistro();
                }
            }
        }
        m2.cerrarArchivo();
    }

    public static void inicializarArchivo() {
        try {
            m2 = new Archivo("Autoplan.dat", new autoplan());
            if (!m2.getFd().exists()){
                m2.crearArchivoVacio(new Registro(new autoplan(), 0));
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error al crear los descriptores de archivos: " + e.getMessage());
            System.exit(1);
        }
    }

    public static void menu() {
        int op;
        Registro reg;

        do {
            System.out.println("----------------------------------------------------");
            System.out.println("              Actualizacion de AutoPlan             ");
            System.out.println("----------------------------------------------------");
            System.out.println("1. Solicitud de AutoPlan");
            System.out.println("2. Listado de planes");
            System.out.println("0. Salir");
            System.out.print("--> ");
            op = Consola.readInt();
            switch (op) {
                case 1:
                    cargar();
                    break;
                case 2:
                    listarAutoPlan();
                    break;
            }
        } while (op != 0);
    }
}