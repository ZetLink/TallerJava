package principal;

import consola.Consola;
import lista.*;
import arbol.*;

public class principal {
    
    Lista list = new Lista();
    private ArbolBinarioBusqueda abb;
    
    public principal() {
        abb = new ArbolBinarioBusqueda();
    }
    
    //-----GENERAR LISTA-----
//    public void generarLista(){
//        do {
//            int cod = cargarCod();
//            String AP = Consola.cargarString("Apellido y Nombre: ");
//            String domi = Consola.cargarString("Domicilio: ");
//            long tel = Consola.cargarLong(0, "Telefono: ");
//            int cond = cargarCondicion();
//            float mPres = Consola.cargarFloat(0, "Monto del Prestamo: ");
//            int cantC = Consola.cargarInt(0, "Cantidad de Cuotas: ");
//            
//            Cliente temp = new Cliente(cod, AP, domi, tel, cond, mPres, cantC);
//            list.insertarPrim(temp);
//            
//        } while (Consola.deseaContinuar());
//    }
    
    public void generarLista(){
      list.insertarPrim(new Cliente(20, "Juan Pedro", "Calle Falsa 123", 385592339, 2, 1200, 0));
      list.insertarPrim(new Cliente(15, "Juan Pedro", "Calle Falsa 123", 385592339, 2, 1200, 2));
      list.insertarPrim(new Cliente(7, "Juan Pedro", "Calle Falsa 123", 385592339, 2, 1200, 3));
      list.insertarPrim(new Cliente(5, "Juan Pedro", "Calle Falsa 123", 385592339, 2, 1200, 0));
      list.insertarPrim(new Cliente(10, "Juan Pedro", "Calle Falsa 123", 385592339, 2, 1200, 1));
    }
    
    public int cargarCondicion(){
        int cond;
        do {
            System.out.print("Condicion (1/2): ");
            cond = Consola.readInt();
        } while (cond != 1 && cond != 2);
        return cond;
    }
    
    public int cargarCod(){
        int iTemp = 0;
        do {
            System.out.print("Codigo del Cliente: ");
            iTemp = Consola.readInt();
            
            if (!list.listaVacia()){
                while (verificarExistencia(iTemp)){
                    System.out.println("\nCodigo Existente");
                    System.out.print("Codigo del Cliente: ");
                    iTemp = Consola.readInt();
                }
            }
        } while (iTemp < 0);
        return iTemp;
    }
    
    public boolean verificarExistencia(int iTemp){
        boolean bTemp = false;
        NodoLista p = list.inicio();  
        while (p != null){
            Cliente oTemp = p.getDato();
            if (oTemp.getCodCli() == iTemp){
                bTemp = true;
            }
            p = p.getPs();
        }
        return bTemp;
    }  
    //-----------------------
    
    
    //-----GENERAR ARBOL-----
    public void generarArbol(){
        if (!list.listaVacia()){
            NodoLista p = list.inicio();
            while (p != null) {
                abb.insertar(p);
                p = p.getPs();
            }
        }
    }
    //-----------------------
    
    //-----PAGO DE CUOTA-----
    public void pagoDeCuota() {
        NodoLista p = list.inicio();
        int cod = Consola.cargarInt(0, "Codigo Buscado: ");
        boolean b = false;
        while (p != null) {
            NodoLista node = abb.buscar(p);         
            if (node != null) {
                if (cod == node.getDato().getCodCli()){
                    float desc = Consola.cargarFloat(-1, "Monto: ");
                    node.getDato().setMontoPrestamo(node.getDato().getMontoPrestamo() - desc);
                    node.getDato().setCantCuotas(node.getDato().getCantCuotas() - 1);
                    System.out.println("");
                    b = true;
                }                     
                node.setDato(p.getDato());
            }
            p = p.getPs();
        }
        if (b == false){
            System.out.println("Cliente No Encontrado");
        }
    }
    
    //-----------------------
    
    //-----MOSTRAR-----   
    public void mostrar(){
        abb.entreorden();
    }
    //-----------------
    
    public void menuDeOpciones() {
        int op;
        do {
            System.out.println("\n--------------------");
            System.out.println("| MENU DE OPCIONES |");
            System.out.println("--------------------");
            System.out.println("1- Generar Lista de Clientes");
            System.out.println("2- Generar Arbol Indice");
            System.out.println("3- Pago de Cuota");
            System.out.println("4- Informe de Prestamos Cancelados");
            System.out.println("5- Mostrar Lista");
            System.out.println("6- Mostrar Arbol");
            System.out.println("0- Salir");
            op = Consola.cargarInt(0, "--> ");
            switch (op) {
                case 1:
                    generarLista();
                    break;
                case 2:
                    generarArbol();
                    System.out.println("ARBOL GENERADO\n");
                    break;
                case 3:
                    pagoDeCuota();
                    break;
                case 4:
                    mostrar();
                    break;
                case 5:
                    list.imprimirDatos();
                    break;
                case 6:
                    abb.postorden();
                    break;
                case 0:
                    break;
            }
        } while (op != 0);
    }
    
    public static void main(String[] args) {
        principal app = new principal();
        app.menuDeOpciones();
    }
    
}
