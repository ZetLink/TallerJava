package lista;

import interfaces.Comparador;

public class BibliotecaEscolar implements Comparador{
    private int documento;
    private int nroTele;
    private String nom;
    private String correoElectronico;
    private String domicilio;

    public BibliotecaEscolar(int documento, int nroTele, String nom, String correoElectronico, String domicilio) {
        this.documento = documento;
        this.nroTele = nroTele;
        this.nom = nom;
        this.correoElectronico = correoElectronico;
        this.domicilio = domicilio;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public int getNroTele() {
        return nroTele;
    }

    public void setNroTele(int nroTele) {
        this.nroTele = nroTele;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    
    @Override
    public String toString() {
        return " " + this.getDocumento() + " ";
    }

    @Override
    public boolean igualQue(Object op2) {
        BibliotecaEscolar x = (BibliotecaEscolar) op2;
        return (getDocumento() == x.getDocumento());
    }

    @Override
    public boolean menorQue(Object op2) {
        BibliotecaEscolar x = (BibliotecaEscolar) op2;
        return (getDocumento() < x.getDocumento());
    }

    @Override
    public boolean menorIgualQue(Object op2) {
        BibliotecaEscolar x = (BibliotecaEscolar) op2;
        return (getDocumento() <= x.getDocumento());
    }

    @Override
    public boolean mayorQue(Object op2) {
        BibliotecaEscolar x = (BibliotecaEscolar) op2;
        return (getDocumento() > x.getDocumento());
    }

    @Override
    public boolean mayorIgualQue(Object op2) {
        BibliotecaEscolar x = (BibliotecaEscolar) op2;
        return (getDocumento() >= x.getDocumento());
    }
    
}
