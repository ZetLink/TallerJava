package principal;

import com.sun.org.apache.xalan.internal.xsltc.cmdline.getopt.GetOpt;
import persistencia.*;
import datos.*;
import entradaDatos.*;

public class BarcosMenu {
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

    
    //Metodo para mostrar activos
    public static void listarBarcos() {
        m2.abrirParaLectura();
        m2.irPrincipioArchivo();
        while (!m2.eof()) {
            Registro reg = m2.leerRegistro();
            if (reg.getActivo()) {
                Barcos aux = (Barcos) reg.getDatos();
                aux.mostrarRegistro();
            }
        }
        m2.cerrarArchivo();
        Consola.pausa();
    }

    public static Registro cargarInvento() {
        Barcos inv = new Barcos();
        int codigo;
        System.out.print("Codigo del Barco: ");
        codigo = Consola.readInt();
        
        do {
            if (obtener(codigo) != null) {
            System.out.println("Codigo ya existente.");
            codigo = -1;
            }
        } while (codigo < 0 || codigo > inv.tamArchivo());
        inv.setCod_B(codigo);
        inv.cargarDatos();
        Registro reg = new Registro(inv, inv.getCod_B());
        return reg;
    }
    
    public static void mostrarPorSocio(int cod){
        m2.abrirParaLectura();
        m2.irPrincipioArchivo();
        while (!m2.eof()) {
            Registro reg = m2.leerRegistro();
            if (reg.getActivo()) {
                Barcos aux = (Barcos) reg.getDatos();
                if (aux.getCod_B() == cod){
                    aux.mostrarRegistro();
                }
            }
        }
        m2.cerrarArchivo();
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

    public static void cargar() {
        m2.abrirParaLeerEscribir();
        try {
            do {
                Registro reg = cargarInvento();
                m2.cargarUnRegistro(reg);
            } while (Consola.deseaContinuar());
        } catch (Exception e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
            System.exit(1);
        }
        m2.cerrarArchivo();
    }

    public static void baja() {
        Registro reg = new Registro(new Socios(), 0);
        reg.cargarNroOrden();
        m2.bajaRegistro(reg);
        Consola.pausa();
    }

    public static void modificar() {
        System.out.print("Codigo del Barco: ");
        int codigo = Consola.readInt();

        m2.abrirParaLeerEscribir();
        m2.buscarRegistro(codigo);
        if (m2.eof()) {
            System.out.println("No existe el registro");
            Consola.pausa();
            return;
        }

        Registro reg = m2.leerRegistro(); // Lee el registro existente
        Barcos art = (Barcos) reg.getDatos();
        art.aumentarCuota();
        reg.setDatos(art);
        m2.cargarUnRegistro(reg); // Sobreescribe el registro ya existente

        m2.cerrarArchivo();

        System.out.println("Registro modificado");
        Consola.pausa();
    }

    public static void inicializarArchivo() {
        try {
            m2 = new Archivo("Barcos.dat", new Barcos());
            if (!m2.getFd().exists()){
                m2.crearArchivoVacio(new Registro(new Barcos(), 0));
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
            System.out.println("              MENU PRINCIPAL (Inventos)             ");
            System.out.println("----------------------------------------------------");
            System.out.println("1. Alta");
            System.out.println("2. Actualizacion de Cuota");
            System.out.println("3. Listado de Barcos");
            System.out.println("0. Salir");
            System.out.print("--> ");
            op = Consola.readInt();
            switch (op) {
                case 1:
                    cargar();
                    break;
                case 2:
                    modificar();
                    break;
                case 3:
                    listarBarcos();
                    break;
            }
        } while (op != 0);
    }
}