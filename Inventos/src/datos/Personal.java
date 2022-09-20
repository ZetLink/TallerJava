package datos;

import entradaDatos.Consola;
import java.io.*;
import persistencia.*;

public class Personal implements Grabable {

    private int codPersonal; // 4
    private String Ape_Nom; // 40 [20]

    private static int TAMARCHIVO = 100; // cantidad de registros que tendra el archivo
    private static int TAMAREG = 44; // cantidad de bytes que tendrá el registro

    public Personal() {
        this.codPersonal = 0;
        this.Ape_Nom = "";
    }

    //------------Getters and Setters--------------

    public int getCodPersonal() {
        return codPersonal;
    }

    public void setCodPersonal(int codPersonal) {
        this.codPersonal = codPersonal;
    }

    public String getApe_Nom() {
        return Ape_Nom;
    }

    public void setApe_Nom(String Ape_Nom) {
        this.Ape_Nom = Ape_Nom;
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
            file.writeInt(codPersonal);
            Registro.writeString(file, Ape_Nom, 20);
        } catch (IOException e) {
            System.out.println("Error al grabar el registro: " + e.getMessage());
            System.exit(1);
        }
    }

    @Override
    public void leer(RandomAccessFile file) {
        try {
            codPersonal = file.readInt();
            Ape_Nom = Registro.readString(file, 20).trim();
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

        Personal file = (Personal) x;
        return (codPersonal == file.codPersonal);
    }

    @Override
    public int hashCode() {
        return codPersonal;
    }

    @Override
    public void mostrarRegistro() {
        // https://www.javatpoint.com/java-string-format
        System.out.println(String.format("| %6d | %20s |", codPersonal, Ape_Nom));
    }

    @Override
    public void cargarDatos() {
        cargarApe_Nom();
    }
    
    public void cargarApe_Nom(){
        do{
            System.out.print("Apellido y Nombre: ");
            Ape_Nom = Consola.readLine();
        } while (Ape_Nom.equals(" "));
    }
}