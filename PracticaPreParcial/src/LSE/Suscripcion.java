package LSE;

import Interfaces.Comparador;

public class Suscripcion implements Comparador{
    private int dni;
    private String ape_nom;
    private String pais;
    private String direccion;
    private char fdp;
    private char tds;
    private float costo;

    public Suscripcion(int dni, String ape_nom, String pais, String direccion, char fdp, char tds, float costo) {
        this.dni = dni;
        this.ape_nom = ape_nom;
        this.pais = pais;
        this.direccion = direccion;
        this.fdp = fdp;
        this.tds = tds;
        this.costo = costo;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public char getFdp() {
        return fdp;
    }

    public void setFdp(char fdp) {
        this.fdp = fdp;
    }

    public char getTds() {
        return tds;
    }

    public void setTds(char tds) {
        this.tds = tds;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
    
    @Override
    public String toString() {
        return " " + this.getDni() + " ";
    }

    @Override
    public boolean igualQue(Object op2) {
        Suscripcion x = (Suscripcion) op2;
        return (getDni() == x.getDni());
    }

    @Override
    public boolean menorQue(Object op2) {
        Suscripcion x = (Suscripcion) op2;
        return (getDni() < x.getDni());
    }

    @Override
    public boolean menorIgualQue(Object op2) {
        Suscripcion x = (Suscripcion) op2;
        return (getDni() <= x.getDni());
    }

    @Override
    public boolean mayorQue(Object op2) {
        Suscripcion x = (Suscripcion) op2;
        return (getDni() > x.getDni());
    }

    @Override
    public boolean mayorIgualQue(Object op2) {
        Suscripcion x = (Suscripcion) op2;
        return (getDni() >= x.getDni());
    }
    
}
