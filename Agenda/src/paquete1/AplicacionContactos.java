
package paquete1;

import java.util.Scanner;
 

public class AplicacionContactos {

    Scanner ingreso = new Scanner(System.in);
    
     Lista miL; 
    
    public AplicacionContactos(){
        miL = new Lista();
    } 
    
    public static void main(String[] args) {
        AplicacionContactos L =new AplicacionContactos();
        L.menu();
    }
    
 
    
    public void menu(){
        int op = 9;
        do{
            switch(op){
                case 1: generarContactos();
                break;
                case 2: eliminarContacto();
                break;
                case 3: actualizarContacto();
                break;
                case 4: imprimir();
                break;
            }
            mostrarOpciones();
            prt("\n Ingrese su opcion: ");
            op = ingreso.nextInt();
        }
        while(op!=0);
    }
    
    
    public void mostrarOpciones(){
            prt("\nLista de Contactos");
            prt("1- Generar contactos");
            prt("2- Eliminar contacto");
            prt("3- Actualizar contacto");
            prt("4- Imprimir");
            prt("0-salir");
            
        } 
    
    
    public void generarContactos(){ 
         int num=1; 
       prt("ingrese 0 para salir");
       while(num!=0){
           prt("Ingrese del contacto");
           prt("Ingrese numero /(0) para salir");
            num=ingreso.nextInt();
            if (num!=0){
                prt("Ingrese apellido");
                String ape = ingreso.next();
                prt("Ingrese nombre");
                String nom = ingreso.next();
                prt("Ingrese cantidad de grupos");
                int grupos = ingreso.nextInt();
             Contacto cont = new Contacto(num, nom, ape, grupos);   
            miL.insertar(cont);
            }
       }
    }
    
    public void eliminarContacto(){
        int e=1;
       prt("Ingrese 0 para salir");
       while(e!=0){
           prt("Ingrese numero");
           e=ingreso.nextInt();
           miL.eliminarElemento(e);
       }
    }
    
    public void actualizarContacto(){
        Nodo p=miL.Inicio();
 
       if(p!=null){
          System.out.println("Ingrese numero a actualizar");
            int num = ingreso.nextInt();
         //   Nodo n = p.buscarElemento(num);
            int l = 0;
            while(p!= null && l!= 1){
                 Contacto cont = p.getDato();
                if(cont.getNumtelefono()==num){
                    l = 1;
                    System.out.println("Ingrese que desea actualizar");
                    System.out.println("1-Apellido y nombre, 2-grupos");
                    int opcion = ingreso.nextInt();
                    if(opcion ==1){
                        prt("Ingrese apellido");
                        cont.setApellido(ingreso.next());
                        prt("Ingrese nombre");
                        cont.setNombre(ingreso.next());
                    }if(opcion==2){
                        prt("Ingrese cantidad de grupos");
                        cont.setGrupos(ingreso.nextInt());

                    }
                }else{
                     p=p.getPs();
                }
      }
            if(l == 0){
                System.out.println("Numero no existente");
            }
        }else{
            System.out.println("Lista vacia");
        }
 
    }
    
    public void imprimir(){
        Nodo p=miL.Inicio();
        prt("\n Lista de Contactos");
        prt("Num       Apellido        Nombre         Grupos");
      while(p!= null){
          Contacto cont = p.getDato();
          System.out.print(cont.getNumtelefono()+"              "); 
          System.out.print(cont.getApellido()+"         ");
          System.out.print(cont.getNombre()+"        ");
          System.out.println(cont.getGrupos());
          p=p.getPs();
      }
    }
    
    public void prt(String mensaje){  
      System.out.println(mensaje);
      
  }
}
