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
            System.out.println("2- Mostrar Arreglo");
            System.out.println("3- Ocurrencia de un numero");
            System.out.println("0- Salir");
            op = Consola.cargarInt(0, "--> ");
            switch (op) {
                case 1: a1.cargar();
                    break;
                case 2: a1.mostrar(a1.getDim());
                    break;
                case 3: int temp = Consola.cargarInt(0, "Elemento Buscado: ");
                        a1.Ocurrencia(a1, a1.getDim() - 1, temp);
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
