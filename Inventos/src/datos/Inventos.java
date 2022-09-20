package datos;

import entradaDatos.Consola;
import java.io.*;
import persistencia.*;
import principal.PersonalMenu;

public class Inventos implements Grabable {

    private int Cod_Inv; // 4
    private String Den; // 60 [30]
    private int codPersonal; // 4
    private float monto; // 4 bytes
    private int patente; // 4 bytes

    private static int TAMARCHIVO = 100; // cantidad de registros que tendra el archivo
    private static int TAMAREG = 76; // cantidad de bytes que tendrá el registro

    public Inventos() {
        this.Cod_Inv = 0;
        this.Den = "";
        this.codPersonal = 0;
        this.monto = 0;
        this.patente = 0;
    }

    //--------------------Getters and Setters------------------------

    public int getCod_Inv() {
        return Cod_Inv;
    }

    public void setCod_Inv(int Cod_Inv) {
        this.Cod_Inv = Cod_Inv;
    }

    public String getDen() {
        return Den;
    }

    public void setDen(String Den) {
        this.Den = Den;
    }

    public int getCodPersonal() {
        return codPersonal;
    }

    public void setCodPersonal(int codPersonal) {
        this.codPersonal = codPersonal;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public int getPatente() {
        return patente;
    }

    public void setPatente(int patente) {
        this.patente = patente;
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

    @Override
    public void grabar(RandomAccessFile file) {
        try {
            file.writeInt(Cod_Inv);
            Registro.writeString(file, Den, 30);
            file.writeInt(codPersonal);
            file.writeFloat(monto);
            file.writeInt(patente);
        } catch (IOException e) {
            System.out.println("Error al grabar el registro: " + e.getMessage());
            System.exit(1);
        }
    }

    @Override
    public void leer(RandomAccessFile file) {
        try {
            Cod_Inv = file.readInt();
            Den = Registro.readString(file, 30).trim();
            codPersonal = file.readInt();
            monto = file.readFloat();
            patente = file.readInt();
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

        Inventos file = (Inventos) x;
        return (Cod_Inv == file.Cod_Inv);
    }

    @Override
    public int hashCode() {
        return Cod_Inv;
    }

    @Override
    public void mostrarRegistro() {
        // https://www.javatpoint.com/java-string-format
        System.out.println(String.format("| %6d | %10s | %6d | $%5.2f | %6d |", Cod_Inv, Den, codPersonal, monto, patente));
    }

    @Override
    public void cargarDatos() {
        cargarDen();
        cargarCodPersonal();
        cargarMonto();
        cargarPatente();
    }
    
    public void cargarDen(){
        do{
            System.out.print("Denominacion: ");
            Den = Consola.readLine();
        } while (Den.equals(" "));
    }
    
    public void cargarCodPersonal(){
        do{
            System.out.print("Codigo Personal: ");
            int aux = Consola.readInt();
            if (PersonalMenu.verificarExistencia(aux)){
                codPersonal = aux;
            }
        } while (codPersonal < 0);
        if (codPersonal == 0){
            System.out.println("Investigador Inexistente");
        } else {
            PersonalMenu.mostrarApe_Nom(codPersonal);
        }
    }
    
    public void cargarMonto(){
        do{
            System.out.print("Monto: ");
            monto = Consola.readFloat();
        } while (monto < 0);
    }
    
    public void cargarPatente(){
        do{
            System.out.print("Patente: ");
            patente = Consola.readInt();
        } while (patente < 0);
    }
}