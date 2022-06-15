package practicadecola;

import EntradaSalida.Consola;
import java.util.Scanner;

public class Main {
    
    Scanner entrada = new Scanner(System.in);
    Cola CR = new Cola();

    public void menu(){
             
      int opcion = 1;
      int ban;
      do {
    
            System.out.println("1) Agregar elementos a la Cola");
            System.out.println("2) Eliminar elementos de la Cola");
            System.out.println("3) Mostrar elementos de la Cola");
            System.out.println("4) Fin de Programa");
            System.out.println("Opcion: ");
            opcion = entrada.nextInt();
             
            switch (opcion) {
                case 1:
                    System.out.println("Alta de Proyectos ");
                    AltaProyecto();
                   
                    break;
                case 2:
                    eliminarProyecto();
                   
                    break;
                case 3:
                    System.out.println(" Cola ");
                     mostrarCola();
                    
                    break;
                case 4:
                    break;
            }
        } while (opcion != 4);
    }
    
    //------------------------Ingresar datos------------------------------------
    private void AltaProyecto() {
        String op = "s";
        while(!op.equalsIgnoreCase("n")){
            
            System.out.print("Cant producto: ");
            int cp = Consola.leerInt();
            
            System.out.print("Monto recaudado: ");
            float mr = Consola.leerFloat();
            
            System.out.print("Tipo de pago (Tarjeta/Contado): ");
            char tp = Consola.leerString().charAt(0);
            
            Supermercado n = new Supermercado(cp,mr,tp);
            CR.insertar(n);
            
            System.out.println("Continuar s/n");
            op = entrada.next();	
        } 
    }   
    //--------------------------------------------------------------------------
    
    
    //-------------------------Mostrar cosas de la Cola-------------------------
    public void mostrarCola() {
        Nodo temp;
        float total_recaudado = 0;
        
        int cant_autos = 0;
        
        Cola Aux = new Cola();
        
        if (!CR.colaVacia()){
            while (!CR.colaVacia()){
                temp = CR.quitar();
                
                total_recaudado = total_recaudado + temp.getDato().getMonto_reca();
                
                cant_autos = cant_autos + 1;
                
                if (temp.getDato().getMonto_reca() >= 10000 && temp.getDato().getT_pago() == 't'){
                    System.out.println("Datos de la compra");
                    System.out.println("Cantidad de Productos : " + temp.getDato().getCant_prod());
                    System.out.println("Monto recaudado: " + temp.getDato().getMonto_reca());
                    System.out.println("Tipo de pago: Tarjeta");
                }
                
                Aux.insertar(temp);
            }
        } else { 
            System.out.println("cola vacia");
            retornar(Aux,CR);
        }
        System.out.println("El total recaudado fue: " + total_recaudado);
        System.out.println("La cantidad de autos que pasaron fueron: " + cant_autos);
    }
   
    public void retornar(Cola A, Cola B){
        Nodo x;
        while (!A.colaVacia()) {
            x=A.quitar();
            B.insertar(x);
        }
    }
    //--------------------------------------------------------------------------
    
    
    //----------------------------Eliminar cosas de una cola--------------------
    private void eliminarProyecto() {
     // ingresa el elemento hasta que el operador lo decida
        String op="s";
        while(!op.equalsIgnoreCase("n")){
             System.out.println("ingrese el elemento a eliminar");
             int ele= Consola.leerInt();
             buscoyElimino(ele);
             System.out.println("continua(s/n");
             op = Consola.leerString();
        }
   }
 public void buscoyElimino(int ele){
     // recorrido de la cola buscando el elemento , convoca al metodo quitar()
    int B=0;
    Cola Aux=new Cola();
    while(!CR.colaVacia()){
        Nodo x = CR.quitar();
        if(x.getDato().getCant_prod() == ele){
            B=1;
        } else {
            Aux.insertar(x);
        }  
    }
    if(B == 0){
        System.out.println("no existe el elemento");
    }
    retornar(Aux,CR);    
    }
    //--------------------------------------------------------------------------
    
    
    public static void main(String[] args) {
        Main App = new Main();
        App.menu();
    }
    
    
    
}
