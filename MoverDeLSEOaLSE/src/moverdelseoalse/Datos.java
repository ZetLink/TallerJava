package moverdelseoalse;

public class Datos {
    private int codigo;
    private String nombre;
    private String apellido;
    private boolean eliminado;

    public Datos(int codigo,String nombre, String apellido, boolean eliminado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.eliminado = eliminado;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }
    
}
