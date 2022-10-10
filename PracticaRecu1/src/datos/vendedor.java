package datos;

import entradaDatos.Consola;
import java.io.*;
import persistencia.*;
import java.util.Scanner;

public class vendedor implements Grabable {
    Scanner entrada = new Scanner(System.in);
    
    
    private int cod_V; // 4
    private String ape_nom; // 60 [30]
    private long num_T; //8

    private static int TAMARCHIVO = 100; // cantidad de registros que tendra el archivo
    private static int TAMAREG = 72; // cantidad de bytes que tendrá el registro

    public vendedor() {
        this.cod_V = 0;
        this.ape_nom = "";
        this.num_T = 0;
    }

    //------------Getters and Setters--------------

    public int getCod_V() {
        return cod_V;
    }

    public void setCod_V(int cod_V) {
        this.cod_V = cod_V;
    }

    public String getApe_nom() {
        return ape_nom;
    }

    public void setApe_nom(String ape_nom) {
        this.ape_nom = ape_nom;
    }

    public long getNum_T() {
        return num_T;
    }

    public void setNum_T(long num_T) {
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

    //----------------------------------------------
    
    @Override
    public void grabar(RandomAccessFile file) {
        try {
            file.writeInt(cod_V);
            Registro.writeString(file, ape_nom, 30);
            file.writeLong(num_T);
        } catch (IOException e) {
            System.out.println("Error al grabar el registro: " + e.getMessage());
            System.exit(1);
        }
    }

    @Override
    public void leer(RandomAccessFile file) {
        try {
            cod_V = file.readInt();
            ape_nom = Registro.readString(file, 30).trim();
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

        vendedor file = (vendedor) x;
        return (cod_V == file.cod_V);
    }

    @Override
    public int hashCode() {
        return cod_V;
    }

    @Override
    public void mostrarRegistro() {
        // https://www.javatpoint.com/java-string-format
        System.out.println(String.format("| %6d | %20s | %8d |", cod_V, ape_nom, num_T));
    }

    //------------Metodos de Carga----------------------------
    
    @Override
    public void cargarDatos() {
        cargarApe_Nom();
        cargarNum_T();
    }
    
    public void cargarApe_Nom(){
        do{
            System.out.print("Apellido y Nombre: ");
            ape_nom = Consola.readLine();
        } while (ape_nom.equals(" "));
    }
    
    public void cargarNum_T(){
        do{
            System.out.print("Telefono: ");
            num_T = entrada.nextLong();
        } while (num_T < 0);
    }
}