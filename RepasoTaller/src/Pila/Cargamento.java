package Pila;

import EntradaSalida.Consola;

public class Cargamento {
    private int peso;
    private Vehiculos vehiculos;
    private boolean Listo;

    public Cargamento(int peso) {
        this.peso = peso;
        this.Listo = false;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Vehiculos getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Vehiculos vehiculos) {
        this.vehiculos = vehiculos;
    }

    public boolean isListo() {
        return Listo;
    }

    public void setListo(boolean Listo) {
        this.Listo = Listo;
    }
    
    
    
    public void asignar(){
        int total = 0;
        int b = 0;
        System.out.println("---Ingrese la cantidad de vahiculos a usar---");
        System.out.println("Peso: " + peso);
        System.out.print("Camiones: ");
        int cami = Consola.leerInt();
        System.out.print("Furgonetas: ");
        int furgo = Consola.leerInt();
        System.out.print("Camionetas: ");
        int camis = Consola.leerInt();
        
        Vehiculos vehi = new Vehiculos(cami,furgo,camis);
        vehiculos = vehi;
        
        total = total + (cami * 3000);
        total = total + (furgo * 2500);
        total = total + (camis * 1000);
        
        if (total >= peso){
            Listo = true;
        }
       
    }
    
}
