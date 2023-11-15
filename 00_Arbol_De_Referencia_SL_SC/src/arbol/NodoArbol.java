package arbol;

public class NodoArbol {
    private Persona dato;
    private NodoArbol PI;
    private NodoArbol PD;
  
    public NodoArbol(Persona dato){
        this.dato = dato;
        PI = null;
        PD = null;
    }

    public Persona getDato() {
        return dato;
    }

    public void setDato(Persona dato) {
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
        Persona oTemp = getDato();
        System.out.println(String.format(format, oTemp.getDni(), oTemp.getNom(), oTemp.getTel()));
    }
    
}
