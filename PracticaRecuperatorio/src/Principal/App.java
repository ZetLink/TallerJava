package Principal;

import EntradaSalida.Consola;
import Cola.*;

public class App {
    
    Cola grupoConductores;
    
    public App() {
        grupoConductores = new Cola();
    }
    
    public void menu(){
             
      int opcion = 1;
      do {
            System.out.println(" ");
            System.out.println("1) Cargar Conductor");
            System.out.println("2) Asignar Transporte");
            System.out.println("3) Listar");
            System.out.println("4) Salir");
            System.out.println("Opcion: ");
            opcion = Consola.leerInt();
             
            switch (opcion) {
                case 1:
                    cargarConductor();
                    break;
                case 2:
                    asignarTransporte();
                    break;
                case 3:
                    Listar();
                    break;
            }
        } while (opcion != 4);
    }
    
    public void cargarConductor(){
        System.out.println("Datos del Conductor");
        System.out.print("DNI: ");
        int dni = Consola.leerInt();
        System.out.print("Horas: ");
        int horas = Consola.leerInt();
        Conductor c = new Conductor(dni,horas);
        grupoConductores.insertar(c);
    }
    
    public void asignarTransporte(){
        System.out.print("DNI del Transportista: ");
        int dni = Consola.leerInt();
        Cola aux = new Cola();
        int b = 0;
        if (!grupoConductores.colaVacia()){
            while (!grupoConductores.colaVacia()){
                Nodo x = grupoConductores.quitar();
                if (x.getDato().getDni() == dni){
                    x.getDato().asignarTransporte();
                    b = 1;
                }
                aux.insertar(x);
            }
        } else {
            System.out.println("???");
        }
        retornar(aux,grupoConductores);
        if (b == 0 ){
            System.out.println("No existe");
        }
    }
    
    public void retornar(Cola A, Cola B){
        Nodo x;
        while (!A.colaVacia()) {
            x = A.quitar();
            B.insertar(x);
        }
    }
    
    public void Listar(){
        Cola aux = new Cola();
        while (!grupoConductores.colaVacia()){
            Nodo x = grupoConductores.quitar();
            System.out.println("DNI: " + x.getDato().getDni());
            System.out.println("Monto: " + "$"+ x.getDato().getSueldo());
            aux.insertar(x);
        }
        retornar(aux,grupoConductores);
    }
}
