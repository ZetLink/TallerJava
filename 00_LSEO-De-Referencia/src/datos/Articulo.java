package datos;

import consola.Consola;

public class Articulo {
    private int cod;
    private String descripcion;
    private float precio;
    private int cantExis;

    public Articulo() {
        this.cod = 0;
        this.descripcion = " ";
        this.precio = 0;
        this.cantExis = 0;
    }

    public Articulo(int cod, String descripcion, float precio, int cantExis) {
        this.cod = cod;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantExis = cantExis;
    }
    

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantExis() {
        return cantExis;
    }

    public void setCantExis(int cantExis) {
        this.cantExis = cantExis;
    }
    
    public void leerDatos(int cod){
        setCod(cod);
        cargarDescripcion();
        cargarPrecio();
        cargarStock();
    }
    
    public void modificarDatos(){
        cargarPrecio();
        cargarStock();
    }
    
    public void cargarDescripcion(){
        do {
            setDescripcion(Consola.cargarString("Descripcion: "));
        } while (getDescripcion().equals(""));
    }
    
    public void cargarPrecio(){
        do {
            setPrecio(Consola.cargarFloat(0, "Precio: "));
        } while (getPrecio() <= 0);
    }
    
    public void cargarStock(){
        do {
            setCantExis(Consola.cargarInt(0, "Cantidad en Stock: "));
        } while (getCantExis() < 0);
    }

    @Override
    public String toString() {
        return String.format("| %2d | %15s | %4.2f | %4d |", + getCod(), getDescripcion(), getPrecio(), getCantExis());
    }
}
