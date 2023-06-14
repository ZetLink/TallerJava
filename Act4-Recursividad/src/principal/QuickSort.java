package principal;

public class QuickSort {
    private Arreglo arreglo;
    private int n = 10;
    
    public QuickSort() {
        arreglo = new Arreglo(n);
    }
 
    public QuickSort(int m) {
        arreglo = new Arreglo(m);
        n = m;
    }
 
    public void cargar() {
        arreglo.cargar();
        System.out.print("\nArreglo Sin Ordenar");
        arreglo.mostrar(n);
        quicksort(0, n - 1);
    }
 
    public void mostrar() {
        System.out.print("\nArreglo Ordenado");
        arreglo.mostrar(n);
    }

    public void quicksort(int primero, int ultimo) {
        int i, j, central;
        int pivote;
        central = (primero + ultimo) / 2;
        pivote = arreglo.retornarElemento(central);
        i = primero;
        j = ultimo;
        do {
            while (arreglo.retornarElemento(i) < pivote) {
                i = i + 1;
            }
            while (arreglo.retornarElemento(j) > pivote) {
                j = j - 1;
            }
            if (i <= j) {
                int temp;
                temp = arreglo.retornarElemento(i);
                arreglo.guardarElemento(i, arreglo.retornarElemento(j));
                arreglo.guardarElemento(j, temp);
                i = i + 1;
                j = j - 1;
            }
        } while (i <= j);
        if (primero < j) {
            quicksort(primero, j);
        }
        if (i < ultimo) {
            quicksort(i, ultimo);
        }
    }
}