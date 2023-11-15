package arbol;

import utilidades.Consola;

public class Persona {
    private int dni;
    private String nom;
    private long tel;

    public Persona() {
        this.dni = 0;
        this.nom = "";
        this.tel = 0;
    }
    
    public Persona(int dni, String nom, long tel) {
        this.dni = dni;
        this.nom = nom;
        this.tel = tel;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }
    
    public void cargarDatos(){
        setDni(Consola.readInt(0, "DNI: "));
        setNom(Consola.readString("Nombre: "));
        setTel(Consola.readLong(0, "Telefono: "));
    }
    
    public void imprimirDato(){
        String format = "%10s%20s%12s";
        System.out.println(String.format(format, getDni(), getNom(), getTel()));
    }
}
