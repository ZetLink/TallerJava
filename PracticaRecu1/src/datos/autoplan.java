package datos;

import entradaDatos.Consola;
import java.io.*;
import persistencia.*;
import principal.VendedorMenu;

public class autoplan implements Grabable {

    private int cod_S; // 4
    private int cod_V; // 4
    private int grupo; // 4
    private int orden; // 4
    private String plan; // 12 [6]

    private static int TAMARCHIVO = 100; // cantidad de registros que tendra el archivo
    private static int TAMAREG = 28; // cantidad de bytes que tendrá el registro

    public autoplan() {
        this.cod_S = 0;
        this.cod_V = 0;
        this.grupo = 0;
        this.orden = 0;
        this.plan = " ";
    }

    //--------------------Getters and Setters------------------------

    public int getCod_S() {
        return cod_S;
    }

    public void setCod_S(int cod_S) {
        this.cod_S = cod_S;
    }

    public int getCod_V() {
        return cod_V;
    }

    public void setCod_V(int cod_V) {
        this.cod_V = cod_V;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }
      
    //---------------------------------------------------------------
    
    @Override
    public int tamRegistro() {
        return TAMAREG;
    }

    @Override
    public int tamArchivo() {
        return TAMARCHIVO;
    }
    
    //--------------------------------------------------------------

    @Override
    public void grabar(RandomAccessFile file) {
        try {
            file.writeInt(cod_S);
            file.writeInt(cod_V);
            file.writeInt(grupo);
            file.writeInt(orden);
            Registro.writeString(file, plan, 6);
        } catch (IOException e) {
            System.out.println("Error al grabar el registro: " + e.getMessage());
            System.exit(1);
        }
    }

    @Override
    public void leer(RandomAccessFile file) {
        try {
            cod_S = file.readInt();
            cod_V = file.readInt();
            grupo = file.readInt();
            orden = file.readInt();
            plan = Registro.readString(file, 6).trim();
        } catch (IOException e) {
            System.out.println("Error al leer el registro: " + e.getMessage());
            System.exit(1);
        }
    }

    @Override
    public boolean equals(Object x) {
        if (x == null) {
            return false;
        }

        autoplan file = (autoplan) x;
        return (cod_S == file.cod_S);
    }

    @Override
    public int hashCode() {
        return cod_S;
    }

    @Override
    public void mostrarRegistro() {
        // https://www.javatpoint.com/java-string-format
        System.out.println(String.format("| %8d | %8d | %8d | %8d | %12s |", cod_S, cod_V, grupo, orden, plan));
    }

    //--------------------------------------------------------------
    
    @Override
    public void cargarDatos() {
        cargarCod_V();
        cargarGrupo();
        cargarOrden();
        cargarPlan();
    }
    
//    public void cargarCod_S(){
//        do{
//            System.out.print("Codigo Vendedor: ");
//            cod_S = Consola.readInt();
//        } while (cod_V < 0);
//    }
    
    public void cargarCod_V(){
        do{
            System.out.print("Codigo Vendedor: ");
            int aux = Consola.readInt();
            if (VendedorMenu.verificarExistencia(aux)){
                cod_V = aux;
            }
        } while (cod_V < 0);
        if (cod_V == 0){
            System.out.println("Vendedor Inexistente");
        } else {
            VendedorMenu.mostrarApe_Nom(cod_V);
        }
    }
    
    public void cargarGrupo(){
        do{
            System.out.print("Grupo: ");
            grupo = Consola.readInt();
        } while (grupo < 0);
    }
    
    public void cargarOrden(){
        do{
            System.out.print("Orden: ");
            orden = Consola.readInt();
        } while (orden < 0);
    }
    
    public void cargarPlan(){
        do{
            System.out.print("Plan: ");
            plan = Consola.readLine();
        } while (plan.equals(" "));
    }
}