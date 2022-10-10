package principal;

import persistencia.*;
import datos.*;
import consola.*;

public class AlumnosMenu {
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

    public static void listarAlumnos(int aux) {
        m2.abrirParaLectura();
        m2.irPrincipioArchivo();
        int cont = 0;
        if (CursoMenu.verificarExistencia(aux)){
            System.out.println("------------------------------------------------------");
            System.out.println("|  Codigo  CCurso     Apellido y Nombre      Monto   |");
            System.out.println("------------------------------------------------------");
            while (!m2.eof()) {
                Registro reg = m2.leerRegistro();
                if (reg.getActivo()) {
                    alumno alum = (alumno) reg.getDatos();
                    if (alum.getCod_C() == aux){
                        alum.mostrarRegistro();
                        cont ++;
                    }
                }
            }
            System.out.println("------------------------------------------------------");
            System.out.println("| Cantidad de alumnos: " + cont + "                             |");
            System.out.println("------------------------------------------------------");
        } else {
            System.out.println("Curso Inexistente");
        }
        m2.cerrarArchivo();
        Consola.pausa();
    }

    public static Registro cargarAlumno() {
        alumno inv = new alumno();
        int codigo;
        System.out.print("Codigo: ");
        codigo = Consola.readInt();
        
        do {
            if (obtener(codigo) != null) {
            System.out.println("Codigo ya existente.");
            codigo = -1;
            }
        } while (codigo < 0 || codigo > inv.tamArchivo());
        inv.setCod_A(codigo);
        inv.cargarDatos();
        Registro reg = new Registro(inv, inv.getCod_A());
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

    public static void cargar() {
        m2.abrirParaLeerEscribir();
        try {
            do {
                Registro reg = cargarAlumno();
                m2.cargarUnRegistro(reg);
            } while (Consola.deseaContinuar());
        } catch (Exception e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
            System.exit(1);
        }
        m2.cerrarArchivo();
    }

    public static void baja() {
        Registro reg = new Registro(new curso(), 0);
        reg.cargarNroOrden();
        m2.bajaRegistro(reg);
        Consola.pausa();
    }

    public static void modificar() {
        System.out.print("Codigo del Alumno: ");
        int codigo = Consola.readInt();

        m2.abrirParaLeerEscribir();
        m2.buscarRegistro(codigo);
        if (m2.eof()) {
            System.out.println("No existe el registro");
            Consola.pausa();
            return;
        }

        Registro reg = m2.leerRegistro(); // Lee el registro existente
        alumno art = (alumno) reg.getDatos();
        art.cargarDatos();
        reg.setDatos(art);
        m2.cargarUnRegistro(reg); // Sobreescribe el registro ya existente

        m2.cerrarArchivo();

        System.out.println("Registro modificado");
        Consola.pausa();
    }

    public static void inicializarArchivo() {
        try {
            m2 = new Archivo("Alumnos.dat", new alumno());
            if (!m2.getFd().exists()){
                m2.crearArchivoVacio(new Registro(new alumno(), 0));
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
            System.out.println("              Actualizacion de Alumnos              ");
            System.out.println("----------------------------------------------------");
            System.out.println("1. Alta");
            System.out.println("2. Bajas");
            System.out.println("3. Modificaciones");
            System.out.println("4. Listado de Alumnos por Curso");
            System.out.println("5. Actualizacion de Saldo");
            System.out.println("0. Salir");
            System.out.print("--> ");
            op = Consola.readInt();
            switch (op) {
                case 1:
                    cargar();
                    break;
                case 2:
                    baja();
                    break;
                case 3:
                    modificar();
                    break;
                case 4:
                    System.out.print("Codigo del Curso: ");
                    int aux = Consola.readInt();
                    listarAlumnos(aux);
                    break;
                case 5:
                    //actualizarSaldo();
                    break;
            }
        } while (op != 0);
    }
}