package principal;

import consola.Consola;

public class Principal {
    
    MetodosRecursivos mr = new MetodosRecursivos();
    
    public void act1A(){
        int num = Consola.cargarInt(0, "Numero: ");
        System.out.println(String.format("Resultado: %-10d", mr.sumarNaturales(num)));
    }
    
    public void act1B(){
        int x = Consola.cargarInt(0, "Base: ");
        int n = Consola.cargarInt(0, "Exponente: ");
        System.out.println(String.format("El resultado de %d^%d es: %-10d", x, n, mr.calcularPotencia(x, n)));
    }
    
    public void act1C(){
        int num;
        do {
            num = Consola.cargarInt(0, "Numero: ");
        } while (num < 100 || num >= 1000);
        System.out.println(String.format("Resultado: %-10d", mr.invertirNumero(num)));
    }
    
    public void act1D(){
        int num = Consola.cargarInt(0, "Numero: ");
        System.out.println(String.format("Resultado: %d", mr.sumarDigitos(num)));
    }
    
    public void act1E(){
        int num = Consola.cargarInt(0, "Numero: ");
        int d = Consola.cargarInt(0, "Digito Buscado: ");
        if (!mr.digitoAusente(d, num)){
            System.out.println("El digito " + d + " se encuentra en el numero: " + num);
        } else {
            System.out.println("El digito " + d + " no se encuentra en el numero: " + num);
        }
    }
    
    public void menuDeOpciones() {
        int op;
        do {
            System.out.println("\n---Actividades---");
            System.out.println("1. Sumar numeros naturales hasta un N");
            System.out.println("2. Calculo de X^n, para valores de X y n");
            System.out.println("3. Invertir numero de tres cifras");
            System.out.println("4. Sumar digitos de un numero");
            System.out.println("5. Determinar si un digito (X) existe en el numero (N)");
            System.out.println("0. Salir");
            op = Consola.cargarInt(0,"-->");
            System.out.println("");
            switch (op) {
                case 1: act1A();
                        break;
                case 2: act1B();
                        break;
                case 3: act1C();
                        break;
                case 4: act1D();
                        break;
                case 5: act1E();
                        break;
                case 0: break;
            }
        } while (op != 0);
    }
    
    public static void main(String[] args) {
        Principal app = new Principal();
        app.menuDeOpciones();
    }

}
