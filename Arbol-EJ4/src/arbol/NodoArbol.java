package arbol;

public class NodoArbol{

    private int documento;
    private Object dato;
    private NodoArbol izdo;
    private NodoArbol dcho;

    public NodoArbol(int dni,Object valor) {
        documento = dni;
        dato = valor;
        izdo = dcho = null;
       
    }

    public NodoArbol(NodoArbol ramaIzdo, int dni, Object valor, NodoArbol ramaDcho) {
        documento = dni;
        dato = valor;
        izdo = ramaIzdo;
        dcho = ramaDcho;
      
    }
    //  operaciones de acceso

    public Object getDato() {
        return dato;
    }

    public NodoArbol getIzdo() {
        return izdo;
    }

    public NodoArbol getDcho() {
        return dcho;
    }

    public void setDato(Object d) {
        dato = d;
    }

    public void setIzdo(NodoArbol n) {
        izdo = n;
    }

    public void setDcho(NodoArbol n) {
        dcho = n;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }
    
    public void imprimirDato() {
        System.out.print(dato.toString() + "\n\n");
    }
    
   
}
