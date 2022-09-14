package datos;

import Consola.Consola;
import java.io.*;
import persistencia.*;

public class Medicamento implements Grabable {

    private int codM;
    private String descripcion;
    private float precio;
    private int cant_S;
    private String fecha_Venc;
    private char tipo;

    private static int TAMARCHIVO = 100; // cantidad de registros que tendra el archivo
    private static int TAMAREG = 134; // cantidad de bytes que tendrá el registro

    public Medicamento() {
        codM = 0;
        descripcion = "";
        precio = 0;
        cant_S = 0;
        fecha_Venc = "";
        tipo = ' ';
    }

    public int getCodM() {
        return codM;
    }

    public void setCodM(int codM) {
        this.codM = codM;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCant_S() {
        return cant_S;
    }

    public void setCant_S(int cant_S) {
        this.cant_S = cant_S;
    }

    public String getFecha_Venc() {
        return fecha_Venc;
    }

    public void setFecha_Venc(String fecha_Venc) {
        this.fecha_Venc = fecha_Venc;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
 
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
            file.writeInt(codM);
            Registro.writeString(file, descripcion, 50);
            file.writeFloat(precio);
            file.writeInt(cant_S);
            Registro.writeString(file, fecha_Venc, 10);
            file.writeChar(tipo);
        } catch (IOException e) {
            System.out.println("Error al grabar el registro: " + e.getMessage());
            System.exit(1);
        }
    }

    @Override
    public void leer(RandomAccessFile file) {
        try {
            codM = file.readInt();
            descripcion = Registro.readString(file, 50).trim();
            precio = file.readFloat();
            cant_S = file.readInt();
            fecha_Venc = Registro.readString(file, 10).trim();
            tipo = file.readChar();
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

        Medicamento file = (Medicamento) x;
        return (codM == file.codM);
    }

    @Override
    public int hashCode() {
        return codM;
    }

    @Override
    public void mostrarRegistro() {
        //https://www.javatpoint.com/java-string-format
        System.out.println(String.format("| %6d | %-15s | $%8.2f | %5d | %-11s | %4c |", codM, descripcion, precio, cant_S, fecha_Venc, tipo));
    }

    @Override
    public void cargarDatos() {
        cargarDescripcion();
        cargarPrecio();
        cargarStock();
        cargarFechaVenc();
        cargarTipo();
    }
    
    public void cargarDescripcion(){
        do {
            System.out.print("Descripcion: ");
            descripcion = Consola.readLine();
        } while (descripcion.equals(""));
    }
    
    public void cargarPrecio(){
        do {
            System.out.print("Precio: ");
            precio = Consola.readFloat();
        } while (precio <= 0);
    }
    
    public void cargarStock(){
        do {
            System.out.print("Cantidad en Stock: ");
            cant_S = Consola.readInt();
        } while (cant_S < 0);
    }
    
    public void cargarFechaVenc(){
        do {
            System.out.print("Fecha de Vencimiento: ");
            fecha_Venc = Consola.readLine();
        } while (fecha_Venc.equals(""));
    }
    
    public void cargarTipo(){
        do{
            System.out.print("Tipo: ");
            tipo = Character.toUpperCase(Consola.leerChar());
        } while (Character.compare(tipo, 'P') != 0 && Character.compare(tipo, 'J') != 0);
    }
}