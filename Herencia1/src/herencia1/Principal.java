package herencia1;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
       
        int opcion =0;
        Scanner sc = new Scanner(System.in);
        do {
            Alumno alu =new Alumno();
            alu.leer();
        } while(opcion !=0);
        
    }
    
}
