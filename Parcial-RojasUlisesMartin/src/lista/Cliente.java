package lista;

import consola.Consola;

public class Cliente{
    private int codCli;
    private String ape_nom;
    private String domicilio;
    private long numCelular;
    private int condicion; //1: Relacion de Dependencia - 2: Independiente
    private float montoPrestamo;
    private int cantCuotas; //Cuotas == 0, se considera cacelado

    public Cliente(int codCli, String ape_nom, String domicilio, long numCelular, int condicion, float montoPrestamo, int cantCuotas) {
        this.codCli = codCli;
        this.ape_nom = ape_nom;
        this.domicilio = domicilio;
        this.numCelular = numCelular;
        this.condicion = condicion;
        this.montoPrestamo = montoPrestamo;
        this.cantCuotas = cantCuotas;
    }

    public int getCodCli() {
        return codCli;
    }

    public void setCodCli(int codCli) {
        this.codCli = codCli;
    }

    public String getApe_nom() {
        return ape_nom;
    }

    public void setApe_nom(String ape_nom) {
        this.ape_nom = ape_nom;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public long getNumCelular() {
        return numCelular;
    }

    public void setNumCelular(long numCelular) {
        this.numCelular = numCelular;
    }

    public int getCondicion() {
        return condicion;
    }

    public void setCondicion(int condicion) {
        this.condicion = condicion;
    }

    public float getMontoPrestamo() {
        return montoPrestamo;
    }

    public void setMontoPrestamo(float montoPrestamo) {
        this.montoPrestamo = montoPrestamo;
    }

    public int getCantCuotas() {
        return cantCuotas;
    }

    public void setCantCuotas(int cantCuotas) {
        this.cantCuotas = cantCuotas;
    }
    
    public void mostrarDatos(){
        System.out.println(" ");
        
        Consola.printLines(72);
        System.out.println(String.format("| Codigo del Cliente: %-10d  %6s  Monto del Prestamo: %-8.2f |", + 
              getCodCli(), " ", getMontoPrestamo()));
        System.out.println(String.format("| Apellido y Nombre: %-50s|", getApe_nom()));
        System.out.println(String.format("| Condicion: %-2d%-56s|", getCondicion(), obtenerCondicion()));
        Consola.printLines(72);
    }
    
    public String obtenerCondicion(){
        String cond;
        if (getCondicion() == 1){
            cond = "Relacion de Dependencia";
        } else {
            cond = "Independiente";
        }
        return cond;
    }
    
    public void mostrarTodo(){
        System.out.println(String.format("| %10d | %20s | %20s | %10d | %-23s | %8.2f | %6d |", + 
                    getCodCli(), getApe_nom(), getDomicilio(), getNumCelular(),obtenerCondicion(), getMontoPrestamo(),getCantCuotas()));
    }
    
}
