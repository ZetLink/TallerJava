
package paquete1;


public class Contacto {
    private int numtelefono;
    private String nombre;
    private String apellido;
    private int grupos;

    public Contacto(int numtelefono, String nombre, String apellido, int grupos) {
        this.numtelefono = numtelefono;
        this.nombre = nombre;
        this.apellido = apellido;
        this.grupos = grupos;
    }

    
    public int getGrupos() {
        return grupos;
    }

    public void setGrupos(int grupos) {
        this.grupos = grupos;
    }
    

    public int getNumtelefono() {
        return numtelefono;
    }

    public void setNumtelefono(int numtelefono) {
        this.numtelefono = numtelefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
}
