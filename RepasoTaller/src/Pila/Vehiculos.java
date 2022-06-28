package Pila;

public class Vehiculos {
    private int camiones;
    private int furgonetas;
    private int camionetas;

    public Vehiculos(int camiones, int furgonetas, int camionetas) {
        this.camiones = camiones;
        this.furgonetas = furgonetas;
        this.camionetas = camionetas;
    }

    public int getCamiones() {
        return camiones;
    }

    public void setCamiones(int camiones) {
        this.camiones = camiones;
    }

    public int getFurgonetas() {
        return furgonetas;
    }

    public void setFurgonetas(int furgonetas) {
        this.furgonetas = furgonetas;
    }

    public int getCamionetas() {
        return camionetas;
    }

    public void setCamionetas(int camionetas) {
        this.camionetas = camionetas;
    }
    
    
}
