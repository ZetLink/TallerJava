package arbol;

import lista.NodoL;

public class NodoA {
    private NodoA PI;
    private int dni;
    private NodoL dir;
    private NodoA PD;
    
    public NodoA(int dni){
        PI = null;
        this.dni = dni;
        PD = null;
    }
    
    public NodoA(int dni, NodoL dir){
        PI = null;
        this.dni = dni;
        this.dir = dir;
        PD = null;
    }

    public NodoA getPI() {
        return PI;
    }

    public void setPI(NodoA PI) {
        this.PI = PI;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public NodoL getDir() {
        return dir;
    }

    public void setDir(NodoL dir) {
        this.dir = dir;
    }

    public NodoA getPD() {
        return PD;
    }

    public void setPD(NodoA PD) {
        this.PD = PD;
    }
}
