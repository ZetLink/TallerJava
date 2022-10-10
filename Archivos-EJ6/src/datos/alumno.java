package datos;

import consola.Consola;
import java.io.*;
import persistencia.*;
import principal.CursoMenu;

public class alumno implements Grabable {

    private int cod_A; // 4
    private int cod_C; // 4
    private String ape_nom; // 60 [30]
    private float monto; // 4 

    private static int TAMARCHIVO = 100; // Cantidad de registros en el archivo
    private static int TAMAREG = 72; // Bytes por Registro

    public alumno() {
        this.cod_A = 0;
        this.cod_C = 0;
        this.ape_nom = " ";
        this.monto = 0;
    }

    //--------------------Getters and Setters------------------------

    public int getCod_A() {
        return cod_A;
    }

    public void setCod_A(int cod_A) {
        this.cod_A = cod_A;
    }

    public int getCod_C() {
        return cod_C;
    }

    public void setCod_C(int cod_C) {
        this.cod_C = cod_C;
    }

    public String getApe_nom() {
        return ape_nom;
    }

    public void setApe_nom(String ape_nom) {
        this.ape_nom = ape_nom;
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
            file.writeInt(cod_A);
            file.writeInt(cod_C);
            Registro.writeString(file, ape_nom, 30);
            file.writeFloat(monto);
        } catch (IOException e) {
            System.out.println("Error al grabar el registro: " + e.getMessage());
            System.exit(1);
        }
    }

    @Override
    public void leer(RandomAccessFile file) {
        try {
            cod_A = file.readInt();
            cod_C = file.readInt();
            ape_nom = Registro.readString(file, 30).trim();
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

        alumno file = (alumno) x;
        return (cod_A == file.cod_A);
    }

    @Override
    public int hashCode() {
        return cod_A;
    }

    @Override
    public void mostrarRegistro() {
        // https://www.javatpoint.com/java-string-format
        System.out.println(String.format("| %6d | %6d | %20s | $%8.2f |", cod_A, cod_C, ape_nom, monto));
    }

    @Override
    public void cargarDatos() {
        cargarCod_C();
        cargarApe_Nom();
        cargarMonto();
    }

    public void cargarCod_C(){
        do{
            System.out.print("Codigo del Curso: ");
            int aux = Consola.readInt();
            if (CursoMenu.verificarExistencia(aux)){
                cod_C = aux;
            }
        } while (cod_C < 0);
        if (cod_C == 0){
            System.out.println("Curso Inexistente");
        }
    }
        
    public void cargarApe_Nom(){
        do{
            System.out.print("Apellido y Nombre: ");
            ape_nom = Consola.readLine();
        } while (ape_nom.equals(" "));
    }
    
    public void cargarMonto(){
        do{
            System.out.print("Monto: ");
            monto = Consola.readFloat();
        } while (monto < 0);
    }
}