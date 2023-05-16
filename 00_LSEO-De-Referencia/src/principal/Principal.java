package principal;

import consola.Consola;
import datos.Articulo;
import lseo.LSEO;
import lseo.Nodo;

public class Principal {

    LSEO l1;
    
    public Principal(){
        l1 = new LSEO();
    }
    
    public void agregarArticulo(){
        //boolean b = false;
        //while (b == false){
            //int cod = Consola.cargarInt(0, "Codigo: ");
            //if (!l1.buscar(cod)){
                Articulo oTemp1 = new Articulo(45, "Papa", 100, 200);
                Articulo oTemp2 = new Articulo(2, "Queso", 3560, 4);
                Articulo oTemp3 = new Articulo(538, "Queso para Rayar", 500, 1000);
                Articulo oTemp4 = new Articulo(67, "Gaseosa", 900, 87);
                //oTemp.leerDatos(cod);
                l1.insertar(oTemp1);
                l1.insertar(oTemp2);
                l1.insertar(oTemp3);
                l1.insertar(oTemp4);
            //} else {
            //  System.out.println("\nCodigo Existente");
            //}
            //b = !Consola.deseaContinuar();
        //}
    }
    
    public void eliminarArticulo(){
        boolean b = false;
        if (!l1.listaVacia()){
            while (b == false){
                int cod = Consola.cargarInt(0, "Codigo: ");
                if (l1.buscar(cod)){
                    l1.eliminar(cod);
                } else {
                    System.out.println("\nCodigo Inexistente");
                }
                b = !Consola.deseaContinuar();
            }
        } else {
            System.out.println("\nLista Vacia!!!");
        }
    }
    
    public void actualizarArticulo(){
        int band = 0;
        if (!l1.listaVacia()){
            int cod = Consola.cargarInt(0, "Codigo Buscado: ");
            Nodo p = l1.inicio();
            while (p != null && band != 1){
                Articulo oTemp = p.getDato();
                if (oTemp.getCod() == cod){
                    oTemp.modificarDatos();
                    band = 1;
                }
                p = p.getPs();
            }
        } else {
            System.out.println("\nLista Vacia!!!");
        }
    }

    public void mostrarArticulos(){
        if (!l1.listaVacia()){
            System.out.format("%30s\n", "Lista de Articulos");
            String formatoTabla = "%-10s%-15s%-10s%-10s\n";
            System.out.format(formatoTabla, "Código", "Descripción", "Precio", "Cantidad");
            System.out.format(formatoTabla, "-------", "-----------", "------", "--------");
            Nodo p = l1.inicio();
            while (p != null){
                Articulo oTemp = p.getDato();
                System.out.println(oTemp.toString());
                System.out.format(formatoTabla, oTemp.getCod(), oTemp.getDescripcion(),
                      oTemp.getPrecio(), oTemp.getCantExis());
                p = p.getPs();
            }
        } else {
            System.out.println("\nLista Vacia!!!");
        }
    }
    
    public void menuDeOpciones() {
        int op;
        do {
            System.out.println("\n--------------------");
            System.out.println("| MENU DE OPCIONES |");
            System.out.println("--------------------");
            System.out.println("1- Agregar Articulo");
            System.out.println("2- Eliminar Articulo");
            System.out.println("3- Actualizar Articulo");
            System.out.println("4- Mostrar Articulos");
            System.out.println("0- Salir");
            op = Consola.cargarInt(0, "--> ");
            switch (op) {
                case 1: agregarArticulo();
                    break;
                case 2: eliminarArticulo();
                    break;
                case 3: actualizarArticulo();
                    break;
                case 4: mostrarArticulos();
                    break;
                case 0:
                        break;
            }
        } while (op != 0);
    }
    
    public static void main(String[] args) {
        Principal app = new Principal();
        //app.menuDeOpciones();
        app.agregarArticulo();
        app.mostrarArticulos();
    }
    
}
