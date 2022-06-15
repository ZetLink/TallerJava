package practicaautoasistida1;

public class Expediente {
    private int n_exp;
    private String apellido;
    private String nombre;
    private String asunto;
    private String inicio_tramite;
    private String num_resolucion;
    private char estado;

    public Expediente(int n_exp, String apellido, String nombre, String asunto, String inicio_tramite, String num_resolucion, char estado) {
        this.n_exp = n_exp;
        this.apellido = apellido;
        this.nombre = nombre;
        this.asunto = asunto;
        this.inicio_tramite = inicio_tramite;
        this.num_resolucion = num_resolucion;
        this.estado = estado;
    }

    public int getN_exp() {
        return n_exp;
    }

    public void setN_exp(int n_exp) {
        this.n_exp = n_exp;
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

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getInicio_tramite() {
        return inicio_tramite;
    }

    public void setInicio_tramite(String inicio_tramite) {
        this.inicio_tramite = inicio_tramite;
    }

    public String getNum_resolucion() {
        return num_resolucion;
    }

    public void setNum_resolucion(String num_resolucion) {
        this.num_resolucion = num_resolucion;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
    
    
}
