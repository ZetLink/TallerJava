package principal;

import persistencia.*;
import datos.*;
import entradaDatos.*;

public class PersonalMenu {
    private static Archivo m2;

    public static Registro cargarPersonal() {
        Personal pers = new Personal();
        int codigo;
        do {
            System.out.print("Codigo--> ");
            codigo = Consola.readInt();
            if (obtener(codigo) != null) {
                System.out.println("Codigo ya existente.");
                codigo = -1;
            }
        } while (codigo < 0 || codigo > pers.tamArchivo());
        pers.setCodPersonal(codigo);
        pers.cargarDatos();
        Registro reg = new Registro(pers, pers.getCodPersonal());
        return reg;
    }

    public static Personal obtener(int codigo) {
        m2.abrirParaLectura();
        m2.buscarRegistro(codigo);
            if (m2.eof()) {
                return null;
            }
            Registro reg = m2.leerRegistro();
                if (!reg.getActivo()) {
                    return null;
                }
        Personal art = (Personal) reg.getDatos();
        m2.cerrarArchivo();

        return art;
    }
    
    public static void mostrarApe_Nom(int cod) {
        m2.abrirParaLectura();
        m2.irPrincipioArchivo();
        while (!m2.eof()) {
            Registro reg = m2.leerRegistro();
            if (reg.getActivo() && reg.getNroOrden() == cod) {
                Personal aux = (Personal) reg.getDatos();
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
    
    public static void inicializarArchivo() {
        try {
            m2 = new Archivo("Personal.dat", new Personal());
            if (!m2.getFd().exists()){
                m2.crearArchivoVacio(new Registro(new Personal(), 0));
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

        cargar();

    }
}