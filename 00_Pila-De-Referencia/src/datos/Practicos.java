package datos;

import consola.Consola;

public class Practicos {
    private String materia, nombre;
    private int tema, cant_hojas, estado;

    public Practicos() {
        this.materia = " ";
        this.nombre = " ";
        this.tema = 0;
        this.cant_hojas = 0;
        this.estado = 0;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTema() {
        return tema;
    }

    public void setTema(int tema) {
        this.tema = tema;
    }

    public int getCant_hojas() {
        return cant_hojas;
    }

    public void setCant_hojas(int cant_hojas) {
        this.cant_hojas = cant_hojas;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    public void cargarDatos(){
        cargarMateria();
        cargarTema();
        cargarNombre();
        cargarCantHojas();
        cargarEstado();
    }
    
    public void cargarMateria(){
        setMateria(Consola.cargarString("Materia: "));
    }
    
    public void cargarTema(){
        setTema(Consola.cargarInt(0, "Tema: "));
    }
    
    public void cargarNombre(){
        setNombre(Consola.cargarString("Nombre del Alumno: "));
    }
    
    public void cargarCantHojas(){
        setCant_hojas(Consola.cargarInt(0, "Cantidad de Hojas: "));
    }
    
    public void cargarEstado(){
        int op;
        System.out.println("Estado del Practico");
        System.out.println("0. Sin Corregir");
        System.out.println("1. Corregido");
        op = Consola.cargarInt(0, "--> ");
        do {
            switch(op){
                case 1: setEstado(op);
                        break;
                case 2: setEstado(op);
                        break;
            }
        } while (op != 0 && op != 1);
    }

    @Override
    public String toString() {
        return "Practicos{" + "materia=" + materia + ", nombre=" + nombre + ", tema=" + tema + ", cant_hojas=" + cant_hojas + ", estado=" + estado + '}';
    }
    
    
}
