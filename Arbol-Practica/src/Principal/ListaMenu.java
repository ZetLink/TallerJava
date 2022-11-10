package Principal;

import Consola.Consola;
import LSE.*;

public class ListaMenu {
    
    Lista list = new Lista();
    
    //-----Insertar-----
    public void cargar(){
        do{
            int dni = cargarNum();
            String an = Consola.cargarString("Apellido y Nombre: ");
            String pais = Consola.cargarString("Pais: ");
            String direc = Consola.cargarString("Direccion: ");
            char fdp = Consola.cargarChar("Forma de Pago", 'E', 'T');
            char tds = Consola.cargarChar("Tipo de Suscripcion", 'M', 'A');
            float costo = Consola.cargarFloat(0, "Costo: ");
            
            Informacion aux = new Informacion(dni, an, pais, direc, fdp, tds, costo);
            list.insertar(aux);
            
//            Informacion aux1 = new Informacion(44069123, "asd", "asd", "asd", 'M', 'A', (float) 1200.0);
//            Informacion aux2 = new Informacion(44069124, "asd", "asd", "asd", 'M', 'A', (float) 1200.0);
//            Informacion aux3 = new Informacion(44069125, "asd", "asd", "asd", 'M', 'A', (float) 1200.0);
//            list.insertar(aux1);
//            list.insertar(aux2);
//            list.insertar(aux3);
            
        } while (Consola.deseaContinuar());
    }
    
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
    
    public boolean verificarExistencia(int iTemp){
        boolean bTemp = false;
        Nodo p = list.inicio();  
        while (p != null){
            Informacion oTemp = p.getDato();
            if (oTemp.getDni() == iTemp){
                bTemp = true;
            }
            p = p.getPs();
        }
        return bTemp;
    }
    //------------------
    
    
    //-----Mostrar-----
    public void mostrar(){
        if (!list.listaVacia()){
            Nodo p = list.inicio();
            while (p != null){
                Informacion oTemp = p.getDato();
                System.out.println(String.format("| %10d | %20s | %15s | %15s | %1c | %1c | %8.1f |", + 
                        oTemp.getDni(), oTemp.getApe_nom(), oTemp.getPais(), oTemp.getDireccion(), oTemp.getFdp(), oTemp.getTds(), oTemp.getCosto()));

                p = p.getPs();
                
            }
        } else {
            System.out.println("Lista Vacia\n");
        }
    }
    //-----------------
    
    
    
    public void menu(){
        int op;

        do {
            System.out.println("\n----------------------------------------------------");
            System.out.println("                      LISTA MENU                    ");
            System.out.println("----------------------------------------------------");
            System.out.println("1. Cargar Lista");
            System.out.println("2. Mostrar Lista");
            System.out.println("0. Salir");
            System.out.print("--> ");
            op = Consola.readInt();
            switch (op) {
                case 1:
                    cargar();
                    break;
                case 2:
                    mostrar();
                    break;
            }
        } while (op != 0);
    }
    
}
