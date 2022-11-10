package Arbol;

import Interfaces.Comparador;
import java.util.Scanner;

public class Contacto implements Comparador {
    
    private long numero;
    private String nom_Contacto;
    private int estado;

    public Contacto() {
        numero = 0;
        nom_Contacto = " ";
        estado = 0;
    }

    //-----Getters and Setters-----

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getNom_Contacto() {
        return nom_Contacto;
    }

    public void setNom_Contacto(String nom_Contacto) {
        this.nom_Contacto = nom_Contacto;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    //-----------------------------

    public void cargarValor() {
        System.out.println("Ingrese un número de 3 cifras: ");
        boolean terminar = true;
        while (terminar) {
            numero = leerInt();
            if (numero > 99 && numero < 1000) {
                terminar = false;
            } else {
                System.out.println("Debe ingresar un número de 3 cifras... ");
            }
        }
    }

    private int leerInt() {
        Scanner entra = new Scanner(System.in);
        while (true) {
            try {
                return entra.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("No es un entero. Por favor, pruebe otra vez!");
            }
        }
    }

    @Override
    public String toString() {
        return " " + this.getNumero() + " ";
    }

    @Override
    public boolean igualQue(Object op2) {
        Contacto x = (Contacto) op2;
        return (getNumero() == x.getNumero());
    }

    @Override
    public boolean menorQue(Object op2) {
        Contacto x = (Contacto) op2;
        return (getNumero() < x.getNumero());
    }

    @Override
    public boolean menorIgualQue(Object op2) {
        Contacto x = (Contacto) op2;
        return (getNumero() <= x.getNumero());
    }

    @Override
    public boolean mayorQue(Object op2) {
        Contacto x = (Contacto) op2;
        return (getNumero() > x.getNumero());
    }

    @Override
    public boolean mayorIgualQue(Object op2) {
        Contacto x = (Contacto) op2;
        return (getNumero() >= x.getNumero());
    }

}
