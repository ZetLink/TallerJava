package lista;

import utilidades.Consola;

public class Socio {
    private int dni;
    private long tel;
    private String nom;
    private String correo;
    private String domicilio;

    public Socio(int dni, long tel, String nom, String correo, String domicilio) {
        this.dni = dni;
        this.tel = tel;
        this.nom = nom;
        this.correo = correo;
        this.domicilio = domicilio;
    }
    
    public Socio() {
        this.dni = 0;
        this.tel = 0;
        this.nom = "";
        this.correo = "";
        this.domicilio = "";
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    
    public void cargarDatos(){
        setDni(Consola.readInt(0, "DNI: "));
        setTel(Consola.readLong(0, "Telefono: "));
        setNom(Consola.readString("Nombre: "));
        setCorreo(Consola.readString("Correo: "));
        setDomicilio(Consola.readString("Domicilio: "));
    }
}