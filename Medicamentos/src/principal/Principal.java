package principal;

import persistencia.*;
import datos.*;
import Consola.*;

public class Principal {
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
        System.out.println("---------------------------------------------------------------------");
        System.out.println("| Codigo |   Descripcion   |  Precio   | Stock | Vencimiento | Tipo |");
        System.out.println("---------------------------------------------------------------------");
        m2.abrirParaLectura();
        m2.irPrincipioArchivo();
        while (!m2.eof()) {
            Registro reg = m2.leerRegistro();
            if (reg.getActivo()) {
                reg.mostrarRegistro(); // La clase Articulo se encarga de dar el formato de cada articulo
            }
        }
        m2.cerrarArchivo();
        System.out.println("---------------------------------------------------------------------");
        Consola.pausa();
    }

    /**
     * Carga un registro de Articulo por teclado
     */
    public static Registro leerArticulo() {
        Medicamento medi = new Medicamento();
        int codigo;
        do {
            System.out.print("Codigo: ");
            codigo = Consola.readInt();
            if (obtenerArticulo(codigo) != null) {
                System.out.println("Codigo ya existente.");
                codigo = -1;
            }
        } while (codigo < 0 || codigo > medi.tamArchivo());
        medi.setCodM(codigo);
        medi.cargarDatos();
        Registro reg = new Registro(medi, medi.getCodM()); // Aqui es donde se indica que la clave principal es "Codigo"
        return reg;
    }

    public static Medicamento obtenerArticulo(int codigo) {
        m2.abrirParaLectura();
        m2.buscarRegistro(codigo);
        if (m2.eof()) {
            return null;
        }
        Registro reg = m2.leerRegistro();
        if (!reg.getActivo()) {
            return null; // El registro no esta activo
        }
        Medicamento art = (Medicamento) reg.getDatos();
        m2.cerrarArchivo();

        return art;
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
        Registro reg = new Registro(new Medicamento(), 0);
        reg.cargarNroOrden();
        m2.bajaRegistro(reg);
        Consola.pausa();
    }

    public static void modificarArticulo() {
        System.out.print("Codigo a modificar: ");
        int codigo = Consola.readInt();

        m2.abrirParaLeerEscribir();
        m2.buscarRegistro(codigo);
        if (m2.eof()) {
            System.out.println("No existe el registro");
            Consola.pausa();
            return;
        }

        Registro reg = m2.leerRegistro(); // Lee el registro existente
        Medicamento medi = (Medicamento) reg.getDatos();
        
        System.out.println("Opcion a modificar");
        System.out.println("1. Descripcion");
        System.out.println("2. Precio");
        System.out.println("3. Stock");
        System.out.println("4. Vencimiento");
        System.out.println("5. Tipo");
        System.out.print("--> ");
        int op = Consola.readInt();
        switch (op){
            case 1:
                System.out.print("--> ");
                medi.setDescripcion(Consola.readLine());
                break;
            case 2:
                System.out.print("--> ");
                medi.setPrecio(Consola.readFloat());
                break;
            case 3: 
                System.out.print("--> ");
                medi.setCant_S(Consola.readInt());
                break;
            case 4:
                System.out.print("--> ");
                medi.setFecha_Venc(Consola.readLine());
                break;
            case 5:
                System.out.print("--> ");
                medi.setTipo(Consola.leerChar());
                break;
        }
        System.out.println(" ");
        
        reg.setDatos(medi);
        m2.cargarUnRegistro(reg); // Sobreescribe el registro ya existente

        m2.cerrarArchivo();

        System.out.println("Registro modificado");
        Consola.pausa();
    }
    
    public static void mostrarStock(){
        System.out.print("Codigo del medicamento: ");
        int codigo = Consola.readInt();

        m2.abrirParaLeerEscribir();
        m2.buscarRegistro(codigo);
        if (m2.eof()) {
            System.out.println("No existe el registro");
            Consola.pausa();
            return;
        }

        Registro reg = m2.leerRegistro(); // Lee el registro existente
        Medicamento medi = (Medicamento) reg.getDatos();
        System.out.println("Descripcion: " + medi.getDescripcion());
        System.out.println("Stock: " + medi.getCant_S());
        m2.cargarUnRegistro(reg); // Sobreescribe el registro ya existente

        m2.cerrarArchivo();
    }

    public static void main(String[] args) {
        try {
            m2 = new Archivo("Articulos.dat", new Medicamento());
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
            System.out.println("5. Consultar Stock");
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
                case 5:
                    mostrarStock();
                    break;
            }
        } while (op != 0);
    }
}