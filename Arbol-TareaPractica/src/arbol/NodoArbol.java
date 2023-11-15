package arbol;

public class NodoArbol {
    private Palabra dato;
    private NodoArbol PI;
    private NodoArbol PD;
  
    public NodoArbol(Palabra dato){
        this.dato = dato;
        PI = null;
        PD = null;
    }

    public Palabra getDato() {
        return dato;
    }

    public void setDato(Palabra dato) {
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
        String format = "| %-4s | %20s | %-4s | %-4s | %-10s |";
        Palabra oTemp = (Palabra) getDato();
        System.out.println(String.format(format, oTemp.getCod(), oTemp.getPalabra(), oTemp.getLetra(), oTemp.getPag(), oTemp.getSector()));
    }
    
}
