package practicaautoasistida1;

import EntradaSalida.Consola;

public class Main {
    Pila E = new Pila();
    Pila D = new Pila();
    
    public void menuPrincipal() {
    
        int op;
        do {
            System.out.println("\n");
            System.out.println("Expedientes");
            System.out.println("1. agregar elementos a la Pila");
            System.out.println("2. eliminar elementos de la Pila");
            System.out.println("3. Mostrar Pila");
            System.out.println("0. Salir");
            System.out.print("Ingrese opcion: ");
            op = Consola.leerInt();
            System.out.println("");
            switch (op) {
                case 1:
                    System.out.println("agregar elementos: ");
                    insertar();
                    break;

                case 2:
                    System.out.println("eliminar elementos: ");
                    quitar();
                    break;

                case 3:
                    System.out.println("mostrar elementos ");
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
                System.out.print("Ingrese la Fecha actual (D/M/A): ");
                String fecha = Consola.leerString();
		while(!op.equalsIgnoreCase("n")){
                    
			System.out.println("ingrese los datos del tramite: ");
                        
                        System.out.print("N° de expediente: ");
                        int n_exp = Consola.leerInt();
                        
                        System.out.print("Apellido: ");
                        String ape = Consola.leerString();
                        
                        System.out.print("Nombre:");
                        String nom = Consola.leerString();
                        
                        System.out.print("Asunto: ");
                        String asunto = Consola.leerString();
                        
                        System.out.print("N° de resolucion: ");
                        char n1 = fecha.charAt(fecha.length()-1);
                        char n2 = fecha.charAt(fecha.length()-2);
                        String a = "1/";
                        String n_reso = a + n2 + n1;
                        
                        System.out.print("Estado (C:Completa/I:Incompleta): ");
                        char est = Consola.leerString().charAt(0);
                        
                        System.out.println(" ");
                        
                        Expediente exp = new Expediente(n_exp,ape,nom,asunto,fecha,n_reso,est);
                        
                        if (est == 'C'){
                            E.apilar(exp);
                        } else {
                            D.apilar(exp);
                        }
                        
			System.out.println("Continuar s/n");
			op = Consola.leerString();	
		
                } 
                
         
    }
    //--------------------------------------------------------------------------
    
    
    
    //------------------------------Mostrar la pila-----------------------------
    private void mostrar() {
        Pila Aux = new Pila();
        
        if (!E.pilaVacia()){
            System.out.println("Expedientes completos");
            while (!E.pilaVacia()) {
                Nodo temp = E.desapilar();
                System.out.println(" ");
                Consola.mostrarMensajeLN("N° de expediente: "+temp.getDato().getN_exp());
                Consola.mostrarMensajeLN("Apellido y Nombre: "+temp.getDato().getApellido()+" "+temp.getDato().getNombre());
                Consola.mostrarMensajeLN("Asunto: "+temp.getDato().getAsunto());
                Consola.mostrarMensajeLN("Fecha de inicio de tramite: "+temp.getDato().getInicio_tramite());
                Consola.mostrarMensajeLN("N° de resolucion: "+temp.getDato().getNum_resolucion());
                Consola.mostrarMensajeLN("Estado: "+temp.getDato().getEstado());
                Aux.apilar(temp.getDato());
            }
        } else {
            System.out.println("No existen expedientes Completos");  
            retornar(E,Aux);
        }
        
        /*if (!D.pilaVacia()){
            System.out.println("Expedientes Incompletos");
            while (!D.pilaVacia()) {
                Nodo temp = E.desapilar();
                System.out.println(" ");
                Consola.mostrarMensajeLN("N° de expediente: "+temp.getDato().getN_exp());
                Consola.mostrarMensajeLN("Apellido y Nombre: "+temp.getDato().getApellido()+" "+temp.getDato().getNombre());
                Consola.mostrarMensajeLN("Asunto: "+temp.getDato().getAsunto());
                Consola.mostrarMensajeLN("Fecha de inicio de tramite: "+temp.getDato().getInicio_tramite());
                Consola.mostrarMensajeLN("N° de resolucion: "+temp.getDato().getNum_resolucion());
                Consola.mostrarMensajeLN("Estado: "+temp.getDato().getEstado());
                Aux.apilar(temp.getDato());
            }
        } else {
            System.out.println("No existen expedientes Incompletos");  
            retornar(D,Aux);
        }*/
        
        
    }
    
    private void retornar(Pila A, Pila B){
    
        while (!B.pilaVacia()) {
            Nodo x = B.desapilar();  
            A.apilar(x.getDato());
        }
    }
    //--------------------------------------------------------------------------
    
    
    //------------------------Eliminar elementos de una pila--------------------
    private void quitar() {
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
    }
    //--------------------------------------------------------------------------
    public static void main(String[] args) {
        Main app = new Main();
        app.menuPrincipal();
    }
    
}
