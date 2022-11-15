package lista;

import interfaces.Comparador;

public class Cliente implements Comparador{
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
    
    @Override
    public String toString() {
        return " " + this.getCodCli() + " ";
    }

    @Override
    public boolean igualQue(Object op2) {
        Cliente x = (Cliente) op2;
        return (getCodCli() == x.getCodCli());
    }

    @Override
    public boolean menorQue(Object op2) {
        Cliente x = (Cliente) op2;
        return (getCodCli() < x.getCodCli());
    }

    @Override
    public boolean menorIgualQue(Object op2) {
        Cliente x = (Cliente) op2;
        return (getCodCli() <= x.getCodCli());
    }

    @Override
    public boolean mayorQue(Object op2) {
        Cliente x = (Cliente) op2;
        return (getCodCli() > x.getCodCli());
    }

    @Override
    public boolean mayorIgualQue(Object op2) {
        Cliente x = (Cliente) op2;
        return (getCodCli() >= x.getCodCli());
    }

    public void mostrarDatos(){
        System.out.println(" ");
        
        System.out.println(String.format("Codigo del Cliente: %-10d  %6s  Monto del Prestamo: %-8.2f ", + 
              getCodCli(), " ", getMontoPrestamo()));
        System.out.println("Apellido y Nombre: " + getApe_nom());
        System.out.println("Condicion: " + getCondicion() + " " + obtenerCondicion());
        
        System.out.println(" ");
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
        System.out.println(String.format("| %10d | %20s | %20s | %20d | %2d | %8.2f | %4d |", + 
                    getCodCli(), getApe_nom(), getDomicilio(), getNumCelular(),getCondicion(), getMontoPrestamo(),getCantCuotas()));
    }
    
}
