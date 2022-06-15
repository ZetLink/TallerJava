package herencia1;

import java.util.Scanner;

public class Persona {
    private String DNI;
    private String nombre;
    public String getDNI() {

    return DNI;
}

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
 
    public String getNombre() {
        return nombre; }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public void leer(){
        Scanner sc = new Scanner(System.in);
        System.out.print("DNI: ");
        DNI = sc.nextLine();
        System.out.print("Nombre: ");
        nombre = sc.nextLine();
    }
 
}
