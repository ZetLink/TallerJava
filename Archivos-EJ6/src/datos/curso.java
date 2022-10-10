package datos;

import consola.Consola;
import java.io.*;
import persistencia.*;

public class curso implements Grabable {

    private int cod_C; // 4
    private int anio; // 4
    private char division; // 2

    private static int TAMARCHIVO = 100; // cantidad de registros que tendra el archivo
    private static int TAMAREG = 10; // cantidad de bytes que tendrá el registro

    public curso() {
        this.cod_C = 0;
        this.anio = 0;
        this.division = ' ';
    }

    //------------Getters and Setters--------------

    public int getCod_C() {
        return cod_C;
    }

    public void setCod_C(int cod_C) {
        this.cod_C = cod_C;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public char getDivision() {
        return division;
    }

    public void setDivision(char division) {
        this.division = division;
    }
    
    //-----------------------------------------------
    
    @Override
    public int tamRegistro() {
        return TAMAREG;
    }

    @Override
    public int tamArchivo() {
        return TAMARCHIVO;
    }

    //---------------------AwA de OwO--------------------
    
    @Override
    public void grabar(RandomAccessFile file) {
        try {
            file.writeInt(cod_C);
            file.writeInt(anio);
            file.writeChar(division);
        } catch (IOException e) {
            System.out.println("Error al grabar el registro: " + e.getMessage());
            System.exit(1);
        }
    }

    @Override
    public void leer(RandomAccessFile file) {
        try {
            cod_C = file.readInt();
            anio = file.readInt();
            division = file.readChar();
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

        curso file = (curso) x;
        return (cod_C == file.cod_C);
    }

    @Override
    public int hashCode() {
        return cod_C;
    }

    @Override
    public void mostrarRegistro() {
        // https://www.javatpoint.com/java-string-format
        System.out.println(String.format("| %6d | %4d | %4c |", cod_C, anio, division));
    }

    @Override
    public void cargarDatos() {
        cargarAnio();
        cargarDivision();
    }
    
    public void cargarAnio(){
        do{
            System.out.print("Año: ");
            anio = Consola.readInt();
        } while (anio < 0);
    }
    
    public void cargarDivision(){
        do{
            System.out.print("Division: ");
            division = Consola.readLine().charAt(0);
        } while (division == ' ');
    }
}