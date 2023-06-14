package principal;

public class Principal {
    
    Arreglo a1 = new Arreglo(5);

    public void menuDeOpciones() {
        int op;
        do {
            System.out.println("\n--------------------");
            System.out.println("| MENU DE OPCIONES |");
            System.out.println("--------------------");
            System.out.println("1- Cargar Arreglo");
            System.out.println("2- Mostrar menor elemento");
            System.out.println("3- Cantidad de numeros multiplos de k");
            System.out.println("0- Salir");
            op = Consola.cargarInt(0, "--> ");
            switch (op) {
                case 1: a1.cargar();
                        a1.mostrar(a1.getDim());
                        break;
                case 2: System.out.println("El menor elemento es: " + a1.menorElemento(a1, a1.getDim() - 1));
                        break;
                case 3: int k = Consola.cargarInt(0, "Numeros multiplo de: ");
                        System.out.println("La cantidad de numeros multiplo de " + k + " son: "
                        + a1.cantMultiplos(a1, a1.getDim() - 1, k));
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
