package utilidades;

import java.util.Scanner;

public class Consola {
    
    private static Scanner scanner = new Scanner(System.in);
    
    /**
    * Lee una línea de texto desde la entrada del usuario utilizando un objeto Scanner.
    * @return La línea de texto ingresada por el usuario.
    */
    public static String readLine(){
        return scanner.nextLine();
    }

    /**
    * Lee una cadena de texto desde la entrada del usuario después de mostrar un mensaje.
    * Se ejecuta en un bucle hasta que se ingresa una cadena no vacía.
    *
    * @param mensaje El mensaje que se muestra para indicar al usuario qué tipo de entrada se espera.
    * @return La cadena de texto ingresada por el usuario.
    */
    public static String readString(String mensaje){
        String sTemp = "";
        do {
            System.out.print(mensaje);
            sTemp = readLine();
        } while (sTemp.equals(""));
        return sTemp;
    }
    
    /**
    * Lee un entero desde la entrada del usuario después de mostrar un mensaje.
    * Se ejecuta en un bucle hasta que se ingresa un entero válido mayor o igual al valor mínimo especificado.
    *
    * @param min El valor mínimo que debe tener el entero ingresado.
    * @param mensaje El mensaje que se muestra para indicar al usuario qué tipo de entrada se espera.
    * @return El entero ingresado por el usuario.
    */
    public static int readInt(int min, String mensaje){
        int iTemp = 0;
        while (true){
            try {
                do {
                    System.out.print(mensaje);
                    iTemp = Integer.parseInt(readLine());
                } while (iTemp < min);
                break;
            } catch (NumberFormatException e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        return iTemp;
    }
    
    /**
    * Lee un número largo desde la entrada del usuario después de mostrar un mensaje.
    * Se ejecuta en un bucle hasta que se ingresa un número largo válido mayor o igual al valor mínimo especificado.
    *
    * @param min El valor mínimo que debe tener el número largo ingresado.
    * @param mensaje El mensaje que se muestra para indicar al usuario qué tipo de entrada se espera.
    * @return El número largo ingresado por el usuario.
    */
    public static long readLong(int min, String mensaje){
        long iTemp = 0;
        while (true){
            try {
                do {
                    System.out.print(mensaje);
                    iTemp = Long.parseLong(readLine());
                } while (iTemp < min);
                break;
            } catch (NumberFormatException e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        return iTemp;
    }
    
    /**
    * Lee un número de punto flotante desde la entrada del usuario después de mostrar un mensaje.
    * Se ejecuta en un bucle hasta que se ingresa un número de punto flotante válido mayor o igual al valor mínimo especificado.
    *
    * @param min El valor mínimo que debe tener el número de punto flotante ingresado.
    * @param mensaje El mensaje que se muestra para indicar al usuario qué tipo de entrada se espera.
    * @return El número de punto flotante ingresado por el usuario.
    */
    public static float readFloat(int min, String mensaje){
        float iTemp = 0;
        while (true){
            try {
                do {
                    System.out.print(mensaje);
                    iTemp = Float.parseFloat(readLine());
                } while (iTemp < min);
                break;
            } catch (NumberFormatException e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        return iTemp;
    }
    
    /**
    * Lee un único carácter desde la entrada del usuario después de mostrar un mensaje.
    * Se ejecuta en un bucle hasta que se ingresa un único carácter.
    *
    * @param mensaje El mensaje que se muestra para indicar al usuario qué tipo de entrada se espera.
    * @return El carácter ingresado por el usuario.
    */
    public static char readChar(String mensaje) {
        char cTemp = ' ';
        while (true) {
            try {
                System.out.print(mensaje);
                String input = readLine();
                if (input.length() == 1) {
                    cTemp = input.charAt(0);
                    break;
                } else {
                    System.out.println("Debes ingresar un único carácter.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage()); //Modificar avisando que no se cargo un char
            }
        }
        return cTemp;
    }
    
    /**
    * Lee un único carácter desde la entrada del usuario.
    * Se ejecuta en un bucle hasta que se ingresa un único carácter.
    *
    * @return El carácter ingresado por el usuario.
    */
    public static char readChar() {
        char cTemp = ' ';
        while (true) {
            try {
                String input = readLine();
                if (input.length() == 1) {
                    cTemp = input.charAt(0);
                    break;
                } else {
                    System.out.println("Debes ingresar un único carácter.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return cTemp;
    }
    
    /**
    * Solicita al usuario que ingrese una respuesta (S/N) para determinar si desea continuar.
    * Devuelve true si la respuesta es 's' (para continuar) y false si es 'n' (para detenerse).
    * Se ejecutará en un bucle hasta que el usuario proporcione una respuesta válida.
    * @return true si el usuario elige continuar, false si elige detenerse.
    */
    public static boolean continuar() {
        boolean continuar = false;
        char respuesta = ' ';
        do {
            System.out.print("¿Desea continuar? (S/N): ");
            respuesta = Character.toLowerCase(readLine().charAt(0));
        } while (respuesta != 's' && respuesta != 'n');
            continuar = respuesta == 's';
        return continuar;
    }
    
    /**
    * Imprime un mensaje indicando al usuario que debe presionar ENTER para continuar.
    * Espera a que el usuario presione ENTER antes de continuar.
    */
    public static void pausa() {
        System.out.println("Pulse ENTER para continuar");
        readLine();
    }
    
    /**
    * Imprime un mensaje en color rojo en la consola.
    * @param mensaje El mensaje que se imprimirá.
    */
    public static void prtRed(String mensaje){
        System.out.print("\u001B[41m" + mensaje + "\u001B[0m\n");
    }
    
    /**
    * Imprime un mensaje en color amarillo en la consola.
    * @param mensaje El mensaje que se imprimirá.
    */
    public static void prtYellow(String mensaje){
        System.out.print("\u001B[33m" + mensaje + "\u001B[0m\n");
    }
    
    /**
    * Imprime un mensaje en color verde en la consola.
    * @param mensaje El mensaje que se imprimirá.
    */
    public static void prtGreen(String mensaje){
        System.out.print("\u001B[32m" + mensaje + "\u001B[0m\n");
    }
    
    /**
    * Imprime un mensaje en color azul en la consola.
    * @param mensaje El mensaje que se imprimirá.
    */
    public static void prtBlue(String mensaje){
        System.out.print("\u001B[44m" + mensaje + "\u001B[0m\n");
    }
}
