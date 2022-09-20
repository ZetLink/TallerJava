package principal;

import persistencia.*;
import datos.*;
import Consola.*;

public class principal {
    private static Archivo m2;

    /**
     * Muestra el contenido de un archivo (incluidos los registros marcados como
     * borrados) es de utilidad para verificar el contenido del archivo a medida
     * que vamos avanzando en la resolución de modo de controlar como estan
     * cargados los registros incluyendo los vacios o los borrados
     */
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

    public static void listar() {
        System.out.println("--------------------------------------------------");
        System.out.println("| Codigo |      Titulo      |    Autor     |  Año |");
        System.out.println("--------------------------------------------------");
        m2.abrirParaLectura();
        m2.irPrincipioArchivo();
        while (!m2.eof()) {
            Registro reg = m2.leerRegistro();
            if (reg.getActivo()) {
                reg.mostrarRegistro(); // La clase Articulo se encarga de dar el formato de cada articulo
            }
        }
        m2.cerrarArchivo();
        System.out.println("---------------------------------");
        Consola.pausa();
    }

    /**
     * Carga un registro de Articulo por teclado
     */
    public static Registro leerArticulo() {
        Libro lib = new Libro();
        int codigo;
        do {
            System.out.print("Codigo: ");
            codigo = Consola.readInt();
            if (obtenerArticulo(codigo) != null) {
                System.out.println("Codigo ya existente.");
                codigo = -1;
            }
        } while (codigo < 0 || codigo > lib.tamArchivo());
        lib.setCod_Lib(codigo);
        lib.cargarDatos();
        Registro reg = new Registro(lib, lib.getCod_Lib()); // Aqui es donde se indica que la clave principal es "Codigo"
        return reg;
    }

    public static Libro obtenerArticulo(int codigo) {
        m2.abrirParaLectura();
        m2.buscarRegistro(codigo);
        if (m2.eof()) {
            return null;
        }
        Registro reg = m2.leerRegistro();
        if (!reg.getActivo()) {
            return null; // El registro no esta activo
        }
        Libro lib = (Libro) reg.getDatos();
        m2.cerrarArchivo();

        return lib;
    }

    public static void cargarArticulos() { //Cambiar nombre a alta()
        m2.abrirParaLeerEscribir();
        try {
            do {
                Registro reg = leerArticulo();
                m2.cargarUnRegistro(reg); //altaRegistro()
            } while (Consola.deseaContinuar());
        } catch (Exception e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
            System.exit(1);
        }
        m2.cerrarArchivo();
    }

    public static void bajaArticulos() {
        System.out.print("Codigo del registro: ");
        int codigo = Consola.readInt();
        boolean  b = verificarClave(codigo);
        if (b){
            Registro reg = new Registro(new Libro(), codigo);
            m2.bajaRegistro(reg);
        } else {
            System.out.println("El codigo ingresado no existe");
        }
        Consola.pausa();
    }

    public static void modificarArticulo() {
        System.out.print("Codigo a modificar: ");
        int codigo = Consola.readInt();
        boolean b = verificarClave(codigo);
        if (b){
            m2.abrirParaLeerEscribir();
            m2.buscarRegistro(codigo);
            Registro reg = m2.leerRegistro(); // Lee el registro existente
            Libro lib = (Libro) reg.getDatos();

            System.out.println("Opcion a modificar");
            System.out.println("1. Titulo");
            System.out.println("2. Autor");
            System.out.println("3. Año de Edicion: ");
            System.out.print("--> ");
            int op = Consola.readInt();
            switch (op){
                case 1:
                    System.out.print("--> ");
                    lib.setTitulo(Consola.readLine());
                    break;
                case 2:
                    System.out.print("--> ");
                    lib.setAutor(Consola.readLine());
                    break;
                case 3: 
                    System.out.print("--> ");
                    lib.setA_Edic(Consola.readInt());
                    break;
            }
            System.out.println(" ");
        
            reg.setDatos(lib);
            m2.cargarUnRegistro(reg);
            System.out.println("Registro modificado");
            m2.cerrarArchivo();
        } else {
            System.out.println("No existe");
        }
        Consola.pausa();
    }

    public static boolean verificarClave(int codigo){
        boolean existe = false;
        m2.abrirParaLectura();
        m2.irPrincipioArchivo();
        System.out.println("Ingrese la clave: ");
        System.out.println("--> ");
        
        while (!m2.eof()) {
            Registro reg = m2.leerRegistro();
            if (reg.getNroOrden() == codigo && reg.getActivo()) {
                existe = true;
            }
        }
        m2.cerrarArchivo();
        return existe;
    }
    
    public static void main(String[] args) {
        try {
            m2 = new Archivo("Articulos.dat", new Libro());
        } catch (ClassNotFoundException e) {
            System.out.println("Error al crear los descriptores de archivos: " + e.getMessage());
            System.exit(1);
        }

        int op;
        Registro reg;

        do {
            System.out.println("----------------------------------------------------");
            System.out.println("                    MENU PRINCIPAL                  ");
            System.out.println("----------------------------------------------------");
            System.out.println("1. Alta de articulos");
            System.out.println("2. Baja de articulos (lógica)");
            System.out.println("3. Modificacion de articulo");
            System.out.println("4. Listar articulos activos");
            System.out.println("0. Salir");
            System.out.print("--> ");
            op = Consola.readInt();
            switch (op) {
                case 1:
                    cargarArticulos();
                    break;
                case 2:
                    bajaArticulos();
                    break;
                case 3:
                    modificarArticulo();
                    break;
                case 4:
                    listar();
                    break;
            }
        } while (op != 0);
    }
}