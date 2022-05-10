package app;

import java.util.Scanner;

public class Fecha {
    private int d;
    private int m;
    private int a;

    public Fecha(int d, int m, int a) {
        this.d = d;
        this.m = m;
        this.a = a;
    }
    
    public Fecha(){
        
    }
    
    public Fecha cargarFecha(){
        Scanner entrada = new Scanner(System.in);
        setD(entrada.nextInt());
        setM(entrada.nextInt());
        setA(entrada.nextInt());
        Fecha f = new Fecha(getD(),getM(),getA());
        return f;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
     
}
