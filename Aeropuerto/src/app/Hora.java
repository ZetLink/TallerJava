package app;

import java.util.Scanner;

public class Hora {
    private int hh;
    private int mm;

    public Hora(int hh, int mm) {
        this.hh = hh;
        this.mm = mm;
    }
    
    public Hora(){
        
    }
    
    public Hora cargarHora(){
        Scanner entrada = new Scanner(System.in);
        setHH(entrada.nextInt());
        setMM(entrada.nextInt());
        Hora h = new Hora(getHH(),getMM());
        return h;
    }
    
    public int getHH() {
        return hh;
    }

    public void setHH(int hh) {
        this.hh = hh;
    }

    public int getMM() {
        return mm;
    }

    public void setMM(int mm) {
        this.mm = mm;
    }
    
    
}
