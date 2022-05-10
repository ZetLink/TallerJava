package app;

import java.util.Scanner;

public class App {
    Scanner entrada = new Scanner(System.in);
    Lista miL = new Lista();
    Fecha fecha = new Fecha();
    Hora hora = new Hora();
    
    //Metodo para ingresar datos
    public void ingresarVuelos(){ 
        int ingresar = -1; 
        while(ingresar != 0){
            System.out.println("Seguir ingresando? (1/0)");
            ingresar = entrada.nextInt();
            if (ingresar != 0){
                Vuelos v = new Vuelos();
                System.out.println("Ingrese el codigo de vuelo");
                v.setCod_vuelo(entrada.nextInt());
        
                System.out.println("Ingrese el destino");
                entrada.next();
                v.setDestino(entrada.nextLine());
                
                System.out.println("Ingrese la hora y minutos");
                v.setHora(hora.cargarHora());
        
                System.out.println("Ingrese la fecha (D/M/A)");
                v.setFecha(fecha.cargarFecha());
                miL.insertar(v);
            }
        }
    }
    //--------------------------
    
    //Metodo para eliminar
    public void eliminarVuelos(){
        int e = 1;
        System.out.println("Ingrese 0 para salir");
        while(e != 0){
            System.out.println("Ingrese el codigo de vuelo");
            e = entrada.nextInt();
            miL.eliminarElemento(e);
       }
    }
    //--------------------
    
    //Metodo para imprimir
    public void imprimir(){
        Nodo p = miL.inicio();
        System.out.println("\n Lista de Vuelos");
        System.out.println("Codigo Vuelos       Destino        Hora         Fecha");
        while(p!= null){
            Vuelos vuelos = p.getDato();
            System.out.print(vuelos.getCod_vuelo()+"                "); 
            System.out.print(vuelos.getDestino()+"           ");
            System.out.print(vuelos.getHora().getHH()+":"+vuelos.getHora().getMM()+"            ");
            System.out.println(vuelos.getFecha().getD()+"/"+vuelos.getFecha().getM()+"/"+vuelos.getFecha().getA());
            p=p.getPs();
        }
    }
    //-------------------
    
    //Metodo para verificar si la lista se encuentra vacia}
    public boolean verificar() {
        if (miL.listaVacia()) {
            System.out.println("Lista vacía!\n");
            return false;
        }
        return true;
    }
    //----------------------------------------------------
    
    //Metodo para seleccionar opciones
    public void mostrarOpciones(){
        System.out.println("Aeropuerto LSGO");
        System.out.println("1-Generar Lista Vuelos");
        System.out.println("2-Eliminar Vuelo");
        System.out.println("3-Imprimir");
        System.out.println("0-Salir");
        System.out.print("Ingrese su opcion:");
    }
    
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
                        imprimir();
                    }
                    break;
            }
            mostrarOpciones();
            opcion = entrada.nextInt();

        } while (opcion != 0);
    }
    //-------------------------------
    
    public static void main(String[] args) {
        App miApp = new App();
        miApp.menu();
    }
    
}
