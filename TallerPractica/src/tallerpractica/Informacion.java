package tallerpractica;

public class Informacion {
    private int DNI;
    private String apellido;
    private String nombre;
    private String direccion;
    private int num_telefono;
    private char cat;
    private float sueldo;

    public Informacion(int DNI, String apellido, String nombre, String direccion, int num_telefono, char cat, float sueldo) {
        this.DNI = DNI;
        this.apellido = apellido;
        this.nombre = nombre;
        this.direccion = direccion;
        this.num_telefono = num_telefono;
        this.cat = cat;
        this.sueldo = sueldo;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNum_telefono() {
        return num_telefono;
    }

    public void setNum_telefono(int num_telefono) {
        this.num_telefono = num_telefono;
    }

    public char getCat() {
        return cat;
    }

    public void setCat(char cat) {
        this.cat = cat;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }
    
    
}
