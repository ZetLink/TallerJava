package principal;

import consola.Consola;
import datos.Practicos;
import pila.*;

public class Principal {

    Pila A = new Pila();
    Pila C = new Pila();
    
    public void cargarCola(){
        boolean b = false;
        while (b == false){
            Practicos oTemp = new Practicos();
            oTemp.cargarDatos();
            A.apilar(oTemp);
            b = !Consola.deseaContinuar();
        }   
    }
    
    public void colocarPilaC(Pila C,Pila A){
        if (A.pilaVacia()){
            Pila auxA = new Pila();
            Pila auxC = new Pila();
            int count = 0;
            while (!A.pilaVacia()){
                Nodo oTemp = A.desapilar();
                if (oTemp.getDato().getEstado() == 1){
                    auxC.apilar(oTemp.getDato());
                } else {
                    auxA.apilar(oTemp.getDato());
                    count++;
                }
            }
            if (count == 0){
                System.out.println("Cantidad de Practicos Sin Corregir: " + count);
            } else {
                System.out.println("Cantidad de Practicos Sin Corregir: " + count);
                retornar(A,auxA);
            }
            retornar(C, auxC);
            mostrarCola(C);
        } else {
            Consola.prtRed("Pila Vacia");
        }    
    }
    
    public void mostrarCola(Pila PilaPrint){
        if (!PilaPrint.pilaVacia()){
            Pila aux =  new Pila();
            System.out.format("%30s\n", "Lista de Practicos");
            String formatoTabla = "%-20s%-15s%-15s%-15s%-15s\n";
            System.out.format(formatoTabla, "Materia", "Tema", "Alumno", "Cant. Hojas", "Estado");
            System.out.format(formatoTabla, "---------------", "--------", "------", "-----------", "----------");  
            while (!PilaPrint.pilaVacia()){
                Nodo oTemp = PilaPrint.desapilar(); 
                Practicos prac = oTemp.getDato();
                System.out.format(formatoTabla, prac.getMateria(), prac.getTema(), prac.getNombre(), prac.getCant_hojas(), prac.getEstado());
                aux.apilar(oTemp.getDato());            
            }
            retornar(PilaPrint, aux);
        } else {
            Consola.prtRed("Pila Vacia");
        }    
    }
    
    private void retornar(Pila A, Pila B){
        while (!B.pilaVacia()) {
            Nodo x = B.desapilar();  
            A.apilar(x.getDato());
        }
    }
    
    public void menuDeOpciones() {
        int op;
        do {
            System.out.println("\n---Practicos---");
            System.out.println("1. Cargar Pila");
            System.out.println("2. Colocar en Pila C / Imprimir");
            System.out.println("3. Mostrar");
            System.out.println("0. Salir");
            op = Consola.cargarInt(0,"-->");
            System.out.println("");
            switch (op) {
                case 1: cargarCola();
                        break;
                case 2: colocarPilaC(C,A);
                        break;
                case 3: mostrarCola(A);
                        break;
                case 0: break;
            }
        } while (op != 0);
    }
    
    public static void main(String[] args) {
        Principal app = new Principal();
        app.menuDeOpciones();
    }
    
}
