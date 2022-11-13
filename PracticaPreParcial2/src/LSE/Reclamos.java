package LSE;

import Interfaces.Comparador;

public class Reclamos implements Comparador{
    private int dni;
    private String ape_nom;
    private String reclamo;
    private String fecha;
    private int estado;

    public Reclamos(int dni, String ape_nom, String reclamo, String fecha, int estado) {
        this.dni = dni;
        this.ape_nom = ape_nom;
        this.reclamo = reclamo;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApe_nom() {
        return ape_nom;
    }

    public void setApe_nom(String ape_nom) {
        this.ape_nom = ape_nom;
    }

    public String getReclamo() {
        return reclamo;
    }

    public void setReclamo(String reclamo) {
        this.reclamo = reclamo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    
    
    @Override
    public String toString() {
        return " " + this.getDni() + " ";
    }

    @Override
    public boolean igualQue(Object op2) {
        Reclamos x = (Reclamos) op2;
        return (getDni() == x.getDni());
    }

    @Override
    public boolean menorQue(Object op2) {
        Reclamos x = (Reclamos) op2;
        return (getDni() < x.getDni());
    }

    @Override
    public boolean menorIgualQue(Object op2) {
        Reclamos x = (Reclamos) op2;
        return (getDni() <= x.getDni());
    }

    @Override
    public boolean mayorQue(Object op2) {
        Reclamos x = (Reclamos) op2;
        return (getDni() > x.getDni());
    }

    @Override
    public boolean mayorIgualQue(Object op2) {
        Reclamos x = (Reclamos) op2;
        return (getDni() >= x.getDni());
    }
    
}
