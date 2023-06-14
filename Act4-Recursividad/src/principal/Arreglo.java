package principal;

public class Arreglo {
    private int dim;
    private int a[];
    
    public Arreglo(int dim) {
        this.dim = dim;
        a = new int[dim];
    }
    
    public int getDim() {
        return dim;
    }
 
    public void setDim(int dim) {
        this.dim = dim;
    }
    
    public int[] getA() {
        return a;
    }
    
    public void setA(int[] a) {
        this.a = a;
    }
    
    public int cargar() {
        int i = 0;
        System.out.println("Ingrese un numero (Menor o Igual que 999)");
        while (i < dim) {
            int elem = Consola.cargarInt(0, "Ingresar elemento: ");
            a[i] = elem;
            i++;
        }
        return i;
    }
    
    public void mostrar(int dim) {
        System.out.println();
        for (int i = 0; i < dim; i++) {
            System.out.print(" " + retornarElemento(i));
        }
    }
    
    public int retornarElemento(int i) {
        int elemento = a[i];
        return elemento;
    }
 
    public void guardarElemento(int i, int elemento) {
        a[i] = elemento;
    }
    
    public void Ocurrencia(Arreglo v, int d,int x){
        if(d <= 0){
            System.out.println("No existe");
        } else {
            if(v.retornarElemento(d) == x){
                System.out.println("Existe");
            } else {
                Ocurrencia(v,d-1,x);
            }
        }
    }
}