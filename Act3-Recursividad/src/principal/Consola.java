package principal;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Consola {

    private static Scanner scanner = new Scanner(System.in);

    public static String readLine() {
        return scanner.nextLine();
    }

    public static int readInt() {
        int x = 0;
        while (true) {
            try {
                x = Integer.parseInt(readLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return x;
    }


    public static double readDouble() {
        double x = 0;
        while (true) {
            try {
                x = Double.parseDouble(readLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return x;
    }

    public static float readFloat() {
        float x = 0;
        while (true) {
            try {
                x = Float.parseFloat(readLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return x;
    }

    public static boolean deseaContinuar() {
        boolean continuar = false;
        char respuesta = ' ';
        do {
            System.out.print("¿Desea continuar? (S/N): ");
            respuesta = Character.toLowerCase(readLine().charAt(0));
        } while (respuesta != 's' && respuesta != 'n');
            continuar = respuesta == 's';
        return continuar;
    }
    
    public static boolean preguntar(String mensaje) {
        boolean continuar = false;
        char respuesta = ' ';
        do {
            System.out.print(mensaje);
            respuesta = Character.toLowerCase(readLine().charAt(0));
        } while (respuesta != 's' && respuesta != 'n');
            continuar = respuesta == 's';
        return continuar;
    }

    public static void pausa() {
        System.out.println("Pulse ENTER para continuar");
        readLine();
    }
    
    public static char readChar() {
        while (true) {
            try {
                return (char) readDato().charAt(0);
            } catch (NumberFormatException e) {
                System.out.println("No es un char. Por favor, pruebe otra vez!");
            }
        }
    }
    
    public static String readDato() {
        String sdato = "";
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader flujoE = new BufferedReader(isr);

        try {
            sdato = flujoE.readLine();
        } catch (IOException e) {
            System.err.println("Error " + e.getMessage());
        }

        return sdato;
    }
    
    public static long readLong() {
        long x = 0;
        while (true) {
            try {
                x = Long.parseLong(readLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return x;
    }
    
    public static int cargarInt(int min, String mensaje){
        int iTemp = 0;
        do {
            System.out.print(mensaje);
            iTemp = readInt();
        } while (iTemp < min);
        return iTemp;
    }
    
    public static long cargarLong(int min, String mensaje){
        long lTemp = 0;
        do {
            System.out.print(mensaje);
            lTemp = readLong();
        } while (lTemp < min);
        return lTemp;
    }
    
    public static String cargarString(String mensaje){
        String sTemp = "";
        do {
            System.out.print(mensaje);
            sTemp = readLine();
        } while (sTemp.equals(""));
        return sTemp;
    }
    
    public static char cargarChar(String mensaje, char op1, char op2){
        char cTemp = ' ';
        do{
            System.out.print(mensaje + " (" + op1 + "/" + op2 +")" + ": ");
            cTemp = Character.toUpperCase(readChar());
        } while (Character.compare(cTemp, op1) != 0 && Character.compare(cTemp, op2) != 0);
        return cTemp;
    }
    
    public static float cargarFloat(int min, String mensaje){
        float fTemp = 0;
        do{
            System.out.print(mensaje);
            fTemp = readFloat();
        } while (fTemp < min);
        return fTemp;
    }
    
    public static void prtRed(String mensaje){
        System.out.print("\u001B[31m" + mensaje + "\u001B[0m\n");
    }
    
    public static void prtYellow(String mensaje){
        System.out.print("\u001B[33m" + mensaje + "\u001B[0m\n");
    }
    
    public static void prtGreen(String mensaje){
        System.out.print("\u001B[32m" + mensaje + "\u001B[0m\n");
    }
    
    public static void prtBlue(String mensaje){
        System.out.print("\u001B[44m" + mensaje + "\u001B[0m\n");
    }
    
    /*
    String.format: 
    System.out.println(String.format("| %10d | %20d | %15s | %15s | %15s |", + 
    aux2.getDocumento(), aux2.getNroTele(), aux2.getNom(), aux2.getCorreoElectronico(), aux2.getDomicilio()));
    
    Tables: 
    ╔═══════════════╤═══════════════╗
    ║ Left          │ Right         ║
    ╠═══════════════╪═══════════════╣
    ║ ╔═════╤═════╗ │ ╔═════╤═════╗ ║
    ║ ║ One │ Two ║ │ ║ One │ Two ║ ║
    ║ ╠═════╪═════╣ │ ╠═════╪═════╣ ║
    ║ ║ 1   │ 2   ║ │ ║ 1   │ 2   ║ ║
    ║ ╚═════╧═════╝ │ ╚═════╧═════╝ ║
    ╚═══════════════╧═══════════════╝
    */
}