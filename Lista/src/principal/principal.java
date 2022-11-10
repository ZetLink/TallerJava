package principal;

import Consola.Consola;
import Lista.*;

public class principal {

    Lista list = new Lista();
    
    /**
     * Cargar objetos de tipo Dato a una LSE
     */
    public void cargar(){
        do{
            int iTemp = cargarNum();
            String sTemp = cargarTexto();
            
            Dato aux = new Dato(iTemp, sTemp);
            list.insertar(aux);
            
        } while (Consola.deseaContinuar());
    }
    
    /**
     * Cargar un entero y verifica que no exista un objeto con el mismo entero
     * @return iTemp
     */
    public int cargarNum(){
        int iTemp = 0;
        do {
            System.out.print("Numero: ");
            iTemp = Consola.readInt();
            
            if (!list.listaVacia()){
                while (verificarExistencia(iTemp)){
                    System.out.println("\nNumero Existente");
                    System.out.print("Numero: ");
                    iTemp = Consola.readInt();
                }
            }
        } while (iTemp < 0);
        return iTemp;
    }
    
    /**
     * Carga un String y verifica que no este vacio
     * @return sTemp
     */
    public String cargarTexto(){
        String sTemp = "";
        do {
            System.out.print("Texto: ");
            sTemp = Consola.readLine();
        } while (sTemp.equals(""));
        return sTemp;
    }
    
    /**
     * Llama al al metodo {Lista.eliminarElemento} y le envia un entero
     */
    public void eliminar(){
        do {
            System.out.print("Numero del objeto: ");
            int iTemp = Consola.readInt();
            list.eliminarElemento(iTemp);
        } while (Consola.deseaContinuar());
    } 
    
    /**
     * Muestra los objetos de una LSE, siempre y cuando no este vacia
     */
    public void mostrarTodo(){
        if (!list.listaVacia()){
            Nodo p = list.inicio();
            System.out.println("\n------Objetos------");
            while (p != null){
                Dato oTemp = p.getDato();
                System.out.println(String.format("| %6d | %15s |", oTemp.getNum(), oTemp.getUwu()));
                p = p.getPs();
            }
        } else {
            System.out.println("Lista Vacia\n");
        } 
    }
    
    /**
     * Muestra un objeto buscando por su (Lista.Dato.num)
     */
    public void mostrarPD(){
        if (!list.listaVacia()){
            System.out.print("Numero que busca: ");
            int iTemp = Consola.readInt();
            boolean bTemp = false;
            Nodo p = list.inicio();
            
            while (p != null){
                Dato oTemp = p.getDato();
                if (oTemp.getNum() == iTemp){
                    System.out.println(String.format("| %6d | %-15s |", oTemp.getNum(), oTemp.getUwu()));
                    bTemp = true;
                }
                p = p.getPs();
            }
            
            if (!bTemp){
                System.out.println("Elemento inexistente");
            }
        } else {
            System.out.println("Lista Vacia");
        }
    }
    
    public void modificar(){
        if (!list.listaVacia()){
            System.out.print("Numero buscado: ");
            int iTemp = Consola.readInt();
            if (verificarExistencia(iTemp)){
                int op;
                do {
                    System.out.println("\n1. Modificar Numero");
                    System.out.println("2. Modificar Texto");
                    System.out.println("0. Salir");
                    System.out.print("--> ");
                    op = Consola.readInt();
                    switch (op){
                        case 1:
                            modificarNum(iTemp);
                            break;
                        case 2:
                            modificarText(iTemp);
                            break;
                    } 
                } while (op != 0);
            } else {
                System.out.println("Elemento Inexistente");
            }
        } else {
            System.out.println("Lista Vacia");
        }
        
    }
    
    public void modificarNum(int iTemp){
        Nodo p = list.inicio();
        while (p != null){
            Dato oTemp = p.getDato();
            if (oTemp.getNum() == iTemp){
                System.out.print("Nuevo Numero: ");
                int aux = Consola.readInt();
                while (verificarExistencia(aux)){
                    System.out.println("\nNumero Existente");
                    System.out.print("Nuevo Numero: ");
                    aux = Consola.readInt();
                }
                p.getDato().setNum(aux);
            }
            p = p.getPs();
        }
    }
    
    public void modificarText(int iTemp){
        Nodo p = list.inicio();
        while (p != null){
            Dato oTemp = p.getDato();
            if (oTemp.getNum() == iTemp){
                String aux = cargarTexto();
                p.getDato().setUwu(aux);
            }
            p = p.getPs();
        }
    }
    
    /**
     * Verifica si existe un objeto con un entero dato
     * @param iTemp
     * @return bTemp
     */
    public boolean verificarExistencia(int iTemp){
        boolean bTemp = false;
        Nodo p = list.inicio();  
        while (p != null){
            Dato oTemp = p.getDato();
            if (oTemp.getNum() == iTemp){
                bTemp = true;
            }
            p = p.getPs();
        }
        return bTemp;
    }
    
    /**
     * Un menu uwu
     */
    public void menu(){
        int op;

        do {
            System.out.println("----------------------------------------------------");
            System.out.println("                    MENU PRINCIPAL                  ");
            System.out.println("----------------------------------------------------");
            System.out.println("1. Cargar Objeto");
            System.out.println("2. Eliminar Objeto");
            System.out.println("3. Mostrar Objetos");
            System.out.println("4. Mostrar Objetos dado un dato");
            System.out.println("5. Modificar");
            System.out.println("0. Salir");
            System.out.print("--> ");
            op = Consola.readInt();
            switch (op) {
                case 1:
                    cargar();
                    break;
                case 2:
                    eliminar();
                    break;
                case 3:
                    mostrarTodo();
                    break;
                case 4:
                    mostrarPD();
                    break;
                case 5:
                    modificar();
                    break;
            }
        } while (op != 0);
    }
    
    public static void main(String[] args) {
        principal app = new principal();
        app.menu();
    }
    
}