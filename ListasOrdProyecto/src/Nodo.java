
public class Nodo {

    private int dato;
    private Nodo ps;

    public Nodo(int elem) {
        dato = elem;
        ps = null;
    }

    /**
     * @return el dato
     */
    public int getDato() {
        return dato;
    }

    /**
     * @param dato el dato a establecer
     */
    public void setDato(int dato) {
        this.dato = dato;
    }

    /**
     * @return el ps
     */
    public Nodo getPs() {
        return ps;
    }

    /**
     * @param ps el ps a establecer
     */
    public void setPs(Nodo ps) {
        this.ps = ps;
    }

}
