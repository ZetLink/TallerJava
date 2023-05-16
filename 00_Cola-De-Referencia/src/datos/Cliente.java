package datos;

import consola.Consola;

public class Cliente {
    private String apellido;
    private int cantComensales;
    private int numMesa;

    public Cliente() {
        this.apellido = " ";
        this.cantComensales = 0;
        this.numMesa = 0;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCantComensales() {
        return cantComensales;
    }

    public void setCantComensales(int cantComensales) {
        this.cantComensales = cantComensales;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }
    
    public void cargarDatos(){
        cargarApellido();
        cargarComensales();
    }
    
    private void cargarApellido(){
        setApellido(Consola.cargarString("Apellido: "));
    }
    
    private void cargarComensales(){
        setCantComensales(Consola.cargarInt(0, "Cantidad Comensales (Max 8): "));
        while (getCantComensales() > 8){
            setCantComensales(Consola.cargarInt(0, "Cantidad Comensales (Max 8): "));
        }
    }

    @Override
    public String toString() {
        return "Cliente{" + "apellido=" + apellido + ", cantComensales=" + cantComensales + '}';
    }
}
