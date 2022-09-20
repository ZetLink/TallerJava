package datos;

import Consola.Consola;
import java.io.*;
import persistencia.*;

public class Libro implements Grabable {

    private int cod_Lib; //4
    private String titulo; //80
    private String autor; //60
    private int a_Edic; //4

    private static int TAMARCHIVO = 100; // cantidad de registros que tendra el archivo
    private static int TAMAREG = 148; // cantidad de bytes que tendrá el registro

    public Libro() {
        cod_Lib = 0;
        titulo = " ";
        autor = " ";
        a_Edic = 0;
    }

    //----------Getters and Setters-----------

    public int getCod_Lib() {
        return cod_Lib;
    }

    public void setCod_Lib(int cod_Lib) {
        this.cod_Lib = cod_Lib;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getA_Edic() {
        return a_Edic;
    }

    public void setA_Edic(int a_Edic) {
        this.a_Edic = a_Edic;
    }
    
    //---------------------------------------
    
    //-----------Metodos de Grabable---------
 
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
            file.writeInt(cod_Lib);
            Registro.writeString(file, titulo, 40);
            Registro.writeString(file, autor, 30);
            file.writeInt(a_Edic);
        } catch (IOException e) {
            System.out.println("Error al grabar el registro: " + e.getMessage());
            System.exit(1);
        }
    }

    @Override
    public void leer(RandomAccessFile file) {
        try {
            cod_Lib = file.readInt();
            titulo = Registro.readString(file, 40).trim();
            autor = Registro.readString(file, 30).trim();
            a_Edic = file.readInt();
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

        Libro file = (Libro) x;
        return (cod_Lib == file.cod_Lib);
    }

    @Override
    public int hashCode() {
        return cod_Lib;
    }

    @Override
    public void mostrarRegistro() {
        //https://www.javatpoint.com/java-string-format
        System.out.println(String.format("| %6d | %16s | %12s | %4d |", cod_Lib, titulo, autor, a_Edic));
    }

    @Override
    public void cargarDatos() {
        cargarTitulo();
        cargarAutor();
        cargarA_Edic();
    }
    
    public void cargarTitulo(){
        do {
            System.out.print("Titulo: ");
            titulo = Consola.readLine();
        } while (titulo.equals(""));
    }
    
    public void cargarAutor(){
        do {
            System.out.print("Autor: ");
            autor = Consola.readLine();
        } while (autor.equals(""));
    }
    
    public void cargarA_Edic(){
        do {
            System.out.print("Año de edicion del libro: ");
            a_Edic = Consola.readInt();
        } while (a_Edic < 0);
    }
}