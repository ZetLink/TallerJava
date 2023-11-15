package arbol;

import lista.NodoLista;

public class NodoArbol {
    private int dni;
    private NodoLista dato;
    private NodoArbol PI;
    private NodoArbol PD;
  
    public NodoArbol(int dni, NodoLista dato){
        this.dni = dni;
        this.dato = dato;
        PI = null;
        PD = null;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    
    public NodoLista getDato() {
        return dato;
    }

    public void setDato(NodoLista dato) {
        this.dato = dato;
    }

    public NodoArbol getPI() {
        return PI;
    }

    public void setPI(NodoArbol PI) {
        this.PI = PI;
    }

    public NodoArbol getPD() {
        return PD;
    }

    public void setPD(NodoArbol PD) {
        this.PD = PD;
    }
    
    public void imprimirDato(){
        String format = "| %10s | %20s | %12s |";
        Persona oTemp = getDato().getDato();
        System.out.println(String.format(format, oTemp.getDni(), oTemp.getNom(), oTemp.getTel()));
    }
    
}
