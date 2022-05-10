package tallerpractica;

public class Nodo {
    private Informacion datos;
    private Nodo ps;

    public Nodo(Informacion datos) {
        this.datos = datos;
    }

    public Informacion getDatos() {
        return datos;
    }

    public void setDatos(Informacion datos) {
        this.datos = datos;
    }

    public Nodo getPs() {
        return ps;
    }

    public void setPs(Nodo ps) {
        this.ps = ps;
    }
    
    
}
