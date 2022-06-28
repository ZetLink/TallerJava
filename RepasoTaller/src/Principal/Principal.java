package Principal;

import EntradaSalida.Consola;
import Pila.*;

public class Principal {
    
    Pila P;
    
    public Principal() {
        P = new Pila();
    }
    
    
    public void menu() {
    
        int op;
        do {
            System.out.println("\n");
            System.out.println("Cargamentos");
            System.out.println("1. Cargar Cargamentos");
            System.out.println("2. Asignar Cargamentos");
            System.out.println("3. Mostrar Cargamentos");
            System.out.println("0. Salir");
            System.out.print("Ingrese opcion: ");
            op = Consola.leerInt();
            System.out.println("");
            switch (op) {
                case 1:
                    insertar();
                    break;
                case 2:
                    asignarVehiculos();
                    break;
                case 3:
                    mostrar();
                    break;
                 case 0:
                 break  ;
            }
        } while (op != 0);
    }
    
    //---------------------------------Insertar en una pila---------------------
    private void insertar() {
                int num;
		String op = "s";
		while(!op.equalsIgnoreCase("n")){
                    
			System.out.print("Ingresar peso del cargamento: ");
                        int peso = Consola.leerInt();   
                        System.out.println(" ");
                        
                        Cargamento carg = new Cargamento(peso);
                        P.apilar(carg);
                        
			System.out.println("Continuar s/n");
			op = Consola.leerString();	
                } 
    }
    //--------------------------------------------------------------------------
    
    
    
    //------------------------------Mostrar la pila-----------------------------
    private void mostrar() {
        Pila aux = new Pila();
            while (!P.pilaVacia()) {
                Nodo temp = P.desapilar();
                System.out.println(" ");
                
                
                System.out.println("Cargamento: " + temp.getDato().getPeso());
                if (temp.getDato().isListo() == true){
                    System.out.println("Cargamento listo");
                } else {
                    System.out.println("Cargamento no listo");
                    int aux1 = (temp.getDato().getVehiculos().getCamiones() * 3000) + (temp.getDato().getVehiculos().getCamionetas() * 1000) + (temp.getDato().getVehiculos().getFurgonetas() * 2500);
                    int peso = temp.getDato().getPeso();
                    int faltan = peso - aux1;
                    System.out.println("Faltan: " + faltan + "Kg");
                }
                
                aux.apilar(temp.getDato());
            }
            retornar(P,aux);
    }
    
    private void retornar(Pila A, Pila B){
    
        while (!B.pilaVacia()) {
            Nodo x = B.desapilar();  
            A.apilar(x.getDato());
        }
    }
    //--------------------------------------------------------------------------
    
    
    //------------------------Eliminar elementos de una pila--------------------
    /*private void quitar() {
       	int num;
        String op = "s";
	while(!op.equalsIgnoreCase("n")){
            System.out.println("ingrese numero: ");
            num = Consola.leerInt();
            buscoyElimino(num);
            System.out.println("Continuar s/n");
            op = Consola.leerString();	
		
    }
 
    }
    
    private void buscoyElimino(int n){
       Pila Aux = new Pila();
       int B=0;
        if (!E.pilaVacia()){
            while (!E.pilaVacia()) {
                Nodo x = E.desapilar();
                if(x.getDato().getN_exp() == n){
                    B=1;
                } else {
                    Aux.apilar(x.getDato());
                }
            } 
        if (B!=1) {
            System.out.println("no existe el elemento en la pila");
        } else {
         System.out.println(" vacia");
         retornar(E,Aux);
        } 

        }
    }*/
    //------------------------Asignar vehiculos---------------------------------
    public void asignarVehiculos(){
        Pila aux = new Pila();
        
            while (!P.pilaVacia()) {
                Nodo temp = P.desapilar();
                System.out.println(" ");
                
                temp.getDato().asignar();
                
                aux.apilar(temp.getDato());
            }
            retornar(P,aux);
        
    }
    //--------------------------------------------------------------------------
}
