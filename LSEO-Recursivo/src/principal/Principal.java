package principal;

public class Principal {
    
    ListaOrdenada l1 = new ListaOrdenada();
    
    private void cargarLista(){
        boolean b = false;
        while (b == false){
            int num = Consola.cargarInt(0, "Numero: ");
            if (!l1.buscar(num)){
                l1.insertar(num);
            } else {
                System.out.println("Numero Existente");
            }
            b = !Consola.deseaContinuar();
        }
    }
    
    private void reversa(Nodo temp){
        if (temp != null){
            reversa(temp.getPs());
            System.out.println(temp.getDato());
        }
    }
    
    private void imprimirReversa(){
        if (!l1.listaVacia()){
            reversa(l1.inicio());
        } else {
            Consola.prtRed("Lista Vacia");
        }
    }
    
    /* Imprime de forma ordenada
    private void reversa(Nodo temp){
        if (temp.getPs() != null){
            System.out.println(temp.getDato());
            reversa(temp.getPs());
        } else {
            System.out.println(temp.getDato());
        }
    }
    */
    
    private void imprimir(){
        if (!l1.listaVacia()){
            Nodo p = l1.inicio();
            while (p != null){
                System.out.println(p.getDato());
                p = p.getPs();
            }   
        } else {
            Consola.prtRed("Lista Vacia");
        }
    }
    
    private void borrarElemento(){
        if (!l1.listaVacia()){
            boolean b = false;
            while (b == false){
                int num = Consola.cargarInt(0, "Numero: ");
                if (l1.buscar(num)){
                    l1.eliminar(num);
                } else {
                    System.out.println("Numero Inexistente");
                }
                b = !Consola.deseaContinuar();
            }
        } else {
            Consola.prtRed("Lista Vacia");
        }
    }
    
    public void menuDeOpciones() {
        int op;
        do {
            System.out.println("\n--------------------");
            System.out.println("| MENU DE OPCIONES |");
            System.out.println("--------------------");
            System.out.println("1- Cargar");
            System.out.println("2- Imprimir");
            System.out.println("3- Imprimir inverso");
            System.out.println("4- Borrar");
            System.out.println("0- Salir");
            op = Consola.cargarInt(0, "--> ");
            switch (op) {
                case 1: cargarLista();
                    break;
                case 2: imprimir();
                    break;
                case 3: imprimirReversa();
                    break;
                case 4: borrarElemento();
                    break;
                case 0:
                        break;
            }
        } while (op != 0);
    }
    
    public static void main(String[] args) {
        Principal app = new Principal();
        app.menuDeOpciones();
    }

}
