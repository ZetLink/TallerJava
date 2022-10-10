package datos;

import entradaDatos.Consola;
import java.io.*;
import persistencia.*;
import java.util.Scanner;

public class Socios implements Grabable {

    Scanner entrada = new Scanner(System.in);
    
    private int cod_S; // 4
    private String Ape_Nom; // 60 [30]
    private long num_T; //8

    private static int TAMARCHIVO = 100; // cantidad de registros que tendra el archivo
    private static int TAMAREG = 72; // cantidad de bytes que tendrá el registro

    public Socios() {
        this.cod_S = 0;
        this.Ape_Nom = "";
        this.num_T = 0;
    }

    //------------Getters and Setters--------------

    public int getCod_S() {
        return cod_S;
    }

    public void setCod_S(int cod_S) {
        this.cod_S = cod_S;
    }

    public String getApe_Nom() {
        return Ape_Nom;
    }

    public void setApe_Nom(String Ape_Nom) {
        this.Ape_Nom = Ape_Nom;
    }

    public long getNum_T() {
        return num_T;
    }

    public void setNum_T(int num_T) {
        this.num_T = num_T;
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
            file.writeInt(cod_S);
            Registro.writeString(file, Ape_Nom, 30);
            file.writeLong(num_T);
        } catch (IOException e) {
            System.out.println("Error al grabar el registro: " + e.getMessage());
            System.exit(1);
        }
    }

    @Override
    public void leer(RandomAccessFile file) {
        try {
            cod_S = file.readInt();
            Ape_Nom = Registro.readString(file, 30).trim();
            num_T = file.readLong();
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

        Socios file = (Socios) x;
        return (cod_S == file.cod_S);
    }

    @Override
    public int hashCode() {
        return cod_S;
    }

    @Override
    public void mostrarRegistro() {
        // https://www.javatpoint.com/java-string-format
        System.out.println(String.format("| %6d | %20s | %10d |", cod_S, Ape_Nom, num_T));
    }

    @Override
    public void cargarDatos() {
        cargarApe_Nom();
        cargarNum_T();
    }
    
    public void cargarApe_Nom(){
        do{
            System.out.print("Apellido y Nombre: ");
            Ape_Nom = Consola.readLine();
        } while (Ape_Nom.equals(" "));
    }
    
    public void cargarNum_T(){
        do{
            System.out.print("Telefono: ");
            num_T = entrada.nextLong();
        } while (num_T < 0);
    }
}