package moverdelseoalse;

import java.util.Scanner;

public class Main {
    Scanner entrada = new Scanner(System.in);
    Lista miL = new Lista();
    
    
    //Ingreso de datos
    public void ingresarDatos(){ 
        int cod = -1; 
        while(cod != 0){
            System.out.println("Seguir ingresando? (1/0)");
            cod = entrada.nextInt();
            if (cod != 0){
                System.out.print("Ingrese el nombre: "); 
                //Agregar esto antes, si antes ingresaste un int con Scanner
                entrada.nextLine();
                //---------------
                String nom = entrada.nextLine();
                System.out.print("Ingrese el apellido: ");
                String ape = entrada.nextLine();
                Datos d = new Datos(cod, nom, ape, false);
                miL.insertar(d);
            }
        }
    }
    
    //Imprimir
    public void imprimir(){
        Nodo p = miL.inicio();
        System.out.println("\n Lista de Datos");
        System.out.println("Codigo       Nombre        Apellido");
        while(p != null && p.getDato().isEliminado() == false){
            Datos d = p.getDato();
            System.out.print(d.getCodigo()+"                "); 
            System.out.print(d.getNombre()+"           ");
            System.out.println(d.getApellido());
            p = p.getPs();
        }
    }
    
    //Eliminar
    public void eliminarPersona(){
        int e = 1;
        System.out.println("Ingrese 0 para salir");
        while(e != 0){
            System.out.println("Ingrese el codigo");
            e = entrada.nextInt();
            miL.buscarElemento(e);
       }
    }
    
    //verificar si la lista se encuentra vacia
    public boolean verificar() {
        if (miL.listaVacia()) {
            System.out.println("Lista vacía!\n");
            return false;
        }
        return true;
    }
    
    //Mostrar nodos eliminados
    public void mostrarEliminados(){
        Nodo p = miL.inicio();
        System.out.println("\n Lista de Datos");
        System.out.println("Codigo       Nombre        Apellido");
        while(p != null && p.getDato().isEliminado() == true){
            Datos d = p.getDato();
            System.out.print(d.getCodigo()+"                "); 
            System.out.print(d.getNombre()+"           ");
            System.out.println(d.getApellido());
            p = p.getPs();
        }
    }
    
    //Menu
    public void menu() {
        int opcion = 9;
        do {
            switch (opcion) {
                case 1:
                    ingresarDatos();
                    break;
                case 2:
                    if (verificar()){
                        eliminarPersona();
                    }
                    break;
                case 3:
                    if (verificar()){
                        imprimir();
                    }
                    break;
                case 4:
                    mostrarEliminados();
                    break;
            }
            mostrarOpciones();
            System.out.print("Ingrese su opcion: ");
            opcion = entrada.nextInt();

        } while (opcion != 0);
    }
    
    public void mostrarOpciones(){
        System.out.println("Datos de personas");
        System.out.println("1-Ingresar");
        System.out.println("2-Eliminar");
        System.out.println("3-Imprimir");
        System.out.println("0-Salir");
    }
    
    public static void main(String[] args) {
        Main miApp = new Main();
        miApp.menu();
    }
    
}
