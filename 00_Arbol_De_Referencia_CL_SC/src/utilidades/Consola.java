package utilidades;

import java.util.Scanner;

public class Consola {
    
    private static Scanner scanner = new Scanner(System.in);
    
    public static String readLine(){
        return scanner.nextLine();
    }
    
    //-----String-----
    public static String readString(String mensaje){
        String sTemp = "";
        do {
            System.out.print(mensaje);
            sTemp = readLine();
        } while (sTemp.equals(""));
        return sTemp;
    }
    
    //-----Int-----
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
    
    //-----Long-----
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
    
    //-----Float-----
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
    
    //-----Char-----
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
                System.out.println("Error: " + e.getMessage()); //Modificar avisando que no se cargo un char?
            }
        }
        return cTemp;
    }
    
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
    
    //-----Extras-----
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
    
    public static void pausa() {
        System.out.println("Pulse ENTER para continuar");
        readLine();
    }
    
    public static void prtRed(String mensaje){
        System.out.print("\u001B[41m" + mensaje + "\u001B[0m\n");
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
}
