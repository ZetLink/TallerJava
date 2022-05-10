package aeropuertolse;

import java.util.Scanner;

public class App {
    Scanner entrada = new Scanner(System.in);
    Lista miL = new Lista();
    
    //Metodo para insertar elementos
    public int verificarHora(){
        int x = entrada.nextInt();
        while (x >= 24 || x <= -1){
            System.out.println("Hora invalida, vuelva a ingresar: ");
            x = entrada.nextInt();
        }
        return x;
    }
    
    public int verificarMinutos(){
        int y = entrada.nextInt();
        while (y >= 60 || y <= -1){
            System.out.println("Minutos invalidos, vuelva a ingresar: ");
            y = entrada.nextInt();
        }
        return y;
    }
    
    public void ingresarVuelos() {
        int cod = -1;
        while (cod != 0) {
            System.out.println("Ingrese elemento (0 p/cancelar): ");
            cod = entrada.nextInt();
            if (cod != 0) {
                System.out.println("Ingrese la hora (HH:MM)");
                Hora h = new Hora();
                
                /*verificar hora
                int x = entrada.nextInt();
                while (x >= 25 || x <= -1){
                    System.out.println("Hora invalida, vuelva a ingresar: ");
                    x = entrada.nextInt();
                }*/
                
                int hh = verificarHora();
                h.setHH(hh);
           
                        
                /*int y = entrada.nextInt();
                while (y >= 60 || y <= -1){
                    System.out.println("Minutios invalidos, vuelva a ingresar: ");
                    y = entrada.nextInt();
                }*/
                
                int mm = verificarMinutos();
                h.setMM(mm);
                
                Datos dat = new Datos(cod, h);
                miL.insertar(dat);
            }
        }
    }
    
    //------------------------------
    
    //Metodo para eliminar elementos de una LSE
    public void eliminarVuelos() {
        int elem = -1;
        while (elem != 0) {
            System.out.println("Ingrese un elemento (0 p/cancelar): ");
            elem = entrada.nextInt();
            if (elem != 0) {
                Nodo x = miL.eliminar(elem);
                System.out.println("--Elemento eliminado--");
            }
        }
    }
    //-----------------------------------------
    
    //Metodo para modificar datos de un nodo
    //--------------------------------------
    
    //Imprimir
    public void imprimir(){
        Nodo p = miL.inicio();
        System.out.println("Codigo de Vuelo           Hora");
        while(p!= null){
            Datos vuelo = p.getDato();
            System.out.print(vuelo.getCod_vuelo()+"                 "); 
            System.out.println(vuelo.getHora().getHH()+":"+vuelo.getHora().getMM());
            p = p.getPs();
      }
    }
    //------------------------------------
    
    //Verficar lista vacia
    public boolean verificar() {
        if (miL.listaVacia()) {
            System.out.println("Lista vacía!\n");
            return false;
        }
        return true;
    }
    //------------------------
    
    //Metodo para mostrar menu
    public void menu() {
        int opcion = 9;
        do {
            switch (opcion) {
                case 1:
                    ingresarVuelos();
                    break;
                case 2:
                    if (verificar()){
                        eliminarVuelos();
                    }
                    break;
                case 3:
                    if (verificar()){
                        //modificarVuelos();
                    }
                    break;
                case 4:
                    if (verificar()){
                        imprimir();
                    }
            }
            mostrarOpciones();
            System.out.print("Ingrese su opcion: ");
            opcion = entrada.nextInt();

        } while (opcion != 0);
    }
    
    public void mostrarOpciones(){
        System.out.println("Aeropuerto LSGO");
        System.out.println("1-Ingresar vuelos");
        System.out.println("2-Eliminar vuelos");
        System.out.println("3-Modificar vuelos");
        System.out.println("4-Imprimir");
        System.out.println("0-Salir");
    }
    //------------------------------------------------
    
    public static void main(String[] args) {
        App miApp = new App();
        miApp.menu();
      
    }
    
}
