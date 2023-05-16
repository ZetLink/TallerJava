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
      list.insertarPrim(new Cliente(20, "Eusebio Prats", "Harris Creek 164", 329160365, 2, 2900, 0));
      list.insertarPrim(new Cliente(15, "Leo Pérez", "Pagac Skyway 286", 595750309, 1, 750, 2));
      list.insertarPrim(new Cliente(7, "Abelardo Paniagua", "Trinity Common 1492", 968661637, 2, 1300, 3));
      list.insertarPrim(new Cliente(5, "Robert Heredia", "Howe Trail 632", 341859106, 1, 980, 0));
      list.insertarPrim(new Cliente(10, "Juan Pedro", "Calle Falsa 123", 575314331, 2, 1200, 1));
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
                    if (node.getDato().getMontoPrestamo() <= 0){
                        node.getDato().setMontoPrestamo(0);
                    }
                    node.getDato().setCantCuotas(node.getDato().getCantCuotas() - 1);
                    if (node.getDato().getCantCuotas() <= 0){
                        node.getDato().setCantCuotas(0);
                    }
                    System.out.println("Pago Efectuado");
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
    
    //-----MOSTRAR TODO-----
    
    public void mostrarTodo(){
        System.out.println("");
        Consola.printLines(119);
        System.out.println("|   Codigo   |   Apellido y Nombre  |       Domicilio      |  Telefono  |"
                + "        Condicion        |   Monto  | Cuotas |");
        Consola.printLines(119);
        abb.mostrarTodo(abb.getRaiz());
        Consola.printLines(119);
    }
    
    //----------------------
    
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
            System.out.println("5- Mostrar Todo");
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
                    mostrarTodo();
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
