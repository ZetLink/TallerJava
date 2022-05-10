package tallerpractica;

import java.util.Scanner;

public class Main {
    Scanner entrada = new Scanner(System.in);
    Lista miL = new Lista();
    
    public void ingresarDatos(){ 
        int dni = 1; 
        while(dni != 0){
            System.out.println("Ingrese los datos del empleado");
            System.out.println("0 p/salir");
            System.out.print("DNI:");
            dni = entrada.nextInt();
            if (dni != 0){
                System.out.print("Apellido: ");
                String ape = entrada.next();
                System.out.print("Nombre: ");
                String nom = entrada.next();
                System.out.print("Direccion: ");
                String dir = entrada.next();
                System.out.print("Numero de telefono: ");
                int tel = entrada.nextInt();
                System.out.print("Categoria (M/A/E): ");
                char cat = entrada.next().charAt(0);
                System.out.print("Suelo: ");
                float sueldo = entrada.nextFloat();
                System.out.println("");
            Informacion info = new Informacion(dni, ape, nom, dir, tel, cat, sueldo);   
            miL.insertar(info);
            }
       }
    }
    
    public void imprimir(){
        Nodo p = miL.inicio();
        System.out.println("Lista de empleados");
        System.out.println("DNI     Apellido y Nombre     Direccion     Telefono     Categoria     Sueldo");
      while(p!= null){
          Informacion info = p.getDatos();
          System.out.print(info.getDNI()+"          "); 
          System.out.print(info.getApellido()+" "+info.getNombre()+"          ");
          System.out.print(info.getDireccion()+"          ");
          System.out.print(info.getNum_telefono()+"          ");
          System.out.print(info.getCat()+"          ");
          System.out.println(info.getSueldo());
          p=p.getPs();
      }
    }
    
    public void modificar(){
        System.out.println("Ingrese la Categoria que decea modificar: ");
        char x = entrada.next().charAt(0);
        System.out.println("Ingrese el procentaje de aumento: ");
        int y = entrada.nextInt();
        miL.actualizarSueldo(x, y);
    }
    
    public void borrar(){
        int e=1;
        System.out.println("Ingrese 0 para salir");
        while(e != 0){
            System.out.println("Ingrese numero");
            e = entrada.nextInt();
            miL.eliminarElemento(e);
       }
    }
    
    public boolean verificar() {
        if (miL.listaVacia()) {
            System.out.println("Lista vacía!\n");
            return false;
        }
        return true;
    }
    
    
    public void menu() {
        int opcion = 9;
        do {
            switch (opcion) {
                case 1:
                    ingresarDatos();
                    break;
                case 2:
                    if (verificar()) {
                        imprimir();
                    }
                    break;
                case 3:
                    if (verificar()) {
                        borrar();
                    }
                    break;
                case 4:
                    if (verificar()) {
                        modificar();
                    }
                    break;

            }
            mostrarOpciones();
            opcion = entrada.nextInt();
            System.out.print("--------->");

        } while (opcion != 0);
    }

    public void mostrarOpciones() {
        System.out.println("\nAcciones a realizar");
        System.out.println("1- Cargar");
        System.out.println("2- Imprimir");
        System.out.println("3- Borrar");
        System.out.println("4- Modificar");
        System.out.println("0- Salir");
        System.out.print("--------->");

    }
    
    public static void main(String[] args) {
        Main app = new Main();
        app.menu();
        
    }
    
}
