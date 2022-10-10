package datos;

import entradaDatos.Consola;
import java.io.*;
import persistencia.*;
import principal.SociosMenu;

public class Barcos implements Grabable {

    private int cod_B; // 4
    private int cod_S; // 4
    private String ubicacion; // 60 [30]
    private float monto; // 4 bytes

    private static int TAMARCHIVO = 100; // cantidad de registros que tendra el archivo
    private static int TAMAREG = 72; // cantidad de bytes que tendrá el registro

    public Barcos() {
        this.cod_B = 0;
        this.cod_S = 0;
        this.ubicacion = "";
        this.monto = 0;
    }

    //--------------------Getters and Setters------------------------

    public int getCod_B() {
        return cod_B;
    }

    public void setCod_B(int cod_B) {
        this.cod_B = cod_B;
    }

    public int getCod_S() {
        return cod_S;
    }

    public void setCod_S(int cod_S) {
        this.cod_S = cod_S;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
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
            file.writeInt(cod_B);
            file.writeInt(cod_S);
            Registro.writeString(file, ubicacion, 30);
            file.writeFloat(monto);
        } catch (IOException e) {
            System.out.println("Error al grabar el registro: " + e.getMessage());
            System.exit(1);
        }
    }

    @Override
    public void leer(RandomAccessFile file) {
        try {
            cod_B = file.readInt();
            cod_S = file.readInt();
            ubicacion = Registro.readString(file, 30).trim();
            monto = file.readFloat();
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

        Barcos file = (Barcos) x;
        return (cod_B == file.cod_B);
    }

    @Override
    public int hashCode() {
        return cod_B;
    }

    @Override
    public void mostrarRegistro() {
        // https://www.javatpoint.com/java-string-format
        System.out.println(String.format("| %6d | %20s | $%5.2f |", cod_B, ubicacion, monto));
    }

    @Override
    public void cargarDatos() {
        cargarCod_S();
        cargarUbicacion();
        cargarMonto();
    }
    
    public void cargarUbicacion(){
        do{
            System.out.print("Ubicacion: ");
            ubicacion = Consola.readLine();
        } while (ubicacion.equals(" "));
    }
    
    public void cargarCod_S(){
        do{
            System.out.print("Codigo Personal: ");
            int aux = Consola.readInt();
            if (SociosMenu.verificarExistencia(aux)){
                cod_S = aux;
            }
        } while (cod_S < 0);
        if (cod_S == 0){
            System.out.println("Investigador Inexistente");
        } else {
            SociosMenu.mostrarApe_Nom(cod_S);
        }
    }
    
    public void cargarMonto(){
        do{
            System.out.print("Monto: ");
            monto = Consola.readFloat();
        } while (monto < 0);
    }
    
    public void aumentarCuota(){
        System.out.println("Monto: " + monto);
        float aux = monto;
        monto = aux + (aux * 10) / 100;
        System.out.println("Monto Modificado: " + monto);
    }
}