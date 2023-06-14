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
            System.out.println(" " + retornarElemento(i));
        }
    }
    
    public int retornarElemento(int i) {
        int elemento = a[i];
        return elemento;
    }
 
    public void guardarElemento(int i, int elemento) {
        a[i] = elemento;
    }
    
    public void Ocurrencia(Arreglo v, int dim,int x){
        if(dim <= 0){
            System.out.println("No existe");
        } else {
            if(v.retornarElemento(dim) == x){
                System.out.println("Existe");
            } else {
                Ocurrencia(v,dim-1,x);
            }
        }
    }
    
    public int menorElemento(Arreglo v, int dim){
        if (dim == 0){
            return v.retornarElemento(dim);
        } else {
            int menor = menorElemento(v, dim - 1);
            if (v.retornarElemento(dim) < menor){
                return v.retornarElemento(dim);
            } else {
                return menor;
            }
        }
    }
    
    public int cantMultiplos(Arreglo v, int dim, int k){
        if (dim < 0){
            return 0;
        } else {
            int cant = cantMultiplos(v, dim - 1, k);
            if (v.retornarElemento(dim) % k == 0){
                return cant + 1;
            } else {
                return cant;
            }
        }
    }
    
}