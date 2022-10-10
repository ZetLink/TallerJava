package principal;

import persistencia.*;
import datos.*;
import entradaDatos.*;

public class VendedorMenu {
    private static Archivo m2;

    public static Registro cargarVendedor() {
        vendedor pers = new vendedor();
        int codigo;
        do {
            System.out.print("Codigo--> ");
            codigo = Consola.readInt();
            if (obtener(codigo) != null) {
                System.out.println("Codigo ya existente.");
                codigo = -1;
            }
        } while (codigo < 0 || codigo > pers.tamArchivo());
        pers.setCod_V(codigo);
        pers.cargarDatos();
        Registro reg = new Registro(pers, pers.getCod_V());
        return reg;
    }

    public static vendedor obtener(int codigo) {
        m2.abrirParaLectura();
        m2.buscarRegistro(codigo);
            if (m2.eof()) {
                return null;
            }
            Registro reg = m2.leerRegistro();
                if (!reg.getActivo()) {
                    return null;
                }
        vendedor art = (vendedor) reg.getDatos();
        m2.cerrarArchivo();

        return art;
    }
    
    public static void mostrarApe_Nom(int cod) {
        m2.abrirParaLectura();
        m2.irPrincipioArchivo();
        while (!m2.eof()) {
            Registro reg = m2.leerRegistro();
            if (reg.getActivo() && reg.getNroOrden() == cod) {
                vendedor aux = (vendedor) reg.getDatos();
                System.out.println("Vendedor: " + aux.getApe_nom());
            }
        }
        m2.cerrarArchivo();
    }

    public static void cargar() {
        m2.abrirParaLeerEscribir();
        try {
            do {
                Registro reg = cargarVendedor();
                m2.cargarUnRegistro(reg);
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
    
    public static void planPorVendedor(int cod) {
        m2.abrirParaLectura();
        m2.irPrincipioArchivo();
        while (!m2.eof()) {
            Registro reg = m2.leerRegistro();
            if (reg.getActivo()) {
                vendedor aux = (vendedor) reg.getDatos();
                System.out.println("Vendedor " + aux.getApe_nom());
                AutoPlanMenu.mostrarPorVendedor(cod);
            }
        }
        m2.cerrarArchivo();
        Consola.pausa();
    }
    
    public static void inicializarArchivo() {
        try {
            m2 = new Archivo("Vendedor.dat", new vendedor());
            if (!m2.getFd().exists()){
                m2.crearArchivoVacio(new Registro(new vendedor(), 0));
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
            System.out.println("              Actualizacion de Vendedor             ");
            System.out.println("----------------------------------------------------");
            System.out.println("1. Alta");
            System.out.println("2. Listado de Planes por Vendedor");
            System.out.println("3. Mostrar Vendedores Activos (NO TOCAR)");
            System.out.println("0. Salir");
            System.out.print("--> ");
            op = Consola.readInt();
            switch (op) {
                case 1:
                    cargar();
                    break;
                case 2:
                    System.out.print("Codigo del Vendedor: ");
                    int aux = Consola.readInt();
                    planPorVendedor(aux);
                    break;
                case 3:
                    mostrar();
                    break;
            }
        } while (op != 0);

    }
}