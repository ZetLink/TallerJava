package principal;

import estructura.*;
import consola.Consola;
import datos.*;

public class Principal {
        
    Cola colaEspera = new Cola();
    Cola clientes = new Cola();
    Lista mesas = new Lista();
    
    public void cargarCliente(){
        boolean b = false;
        while (b == false){
            Cliente oTemp = new Cliente();
            oTemp.cargarDatos();
            asignarMesa(oTemp);
            b = !Consola.deseaContinuar();
        }
    }
    
    public void asignarMesa(Cliente oTemp){
        NodoLista p = mesas.inicio();
        int band = 0;
        while (p != null && band != 1){
            if (oTemp.getCantComensales() <= p.getDato().getMaxComensales() && !p.getDato().isOcupada()){
                p.getDato().setOcupada(true);
                oTemp.setNumMesa(p.getDato().getNumeroMesa());
                clientes.insertar(oTemp);
                band = 1;  
            }
            p = p.getPs();
        }
        if (oTemp.getNumMesa() == 0){
            colaEspera.insertar(oTemp);
        }
    }
    
    public void mostrarCcM(){
        if (!clientes.colaVacia()){
            Cola aux = new Cola();
            System.out.format("%20s\n", "Clientes Con Mesa");
            String formatoTabla = "%-16s%-20s%-10s\n";
            System.out.format(formatoTabla, "Apellido", "Cant. Comensales", "Num. Mesa");
            System.out.format(formatoTabla, "---------------", "----------------", "---------");
            while (!clientes.colaVacia()){
                NodoCola x = clientes.quitar();
                System.out.format(formatoTabla, x.getDato().getApellido(), x.getDato().getCantComensales(), x.getDato().getNumMesa());
                aux.insertar(x);
            }
            retornar(aux, clientes);
        } else {
            Consola.prtRed("Cola Vacia");
        }
    }
    
    public void mostrarCeE(){
        if (!clientes.colaVacia()){
            Cola aux = new Cola();
            System.out.format("%20s\n", "Clientes En Espera");
            String formatoTabla = "%-16s%-20s%-10s\n";
            System.out.format(formatoTabla, "Apellido", "Cant. Comensales", "Num. Mesa");
            System.out.format(formatoTabla, "---------------", "----------------", "---------");
            while (!colaEspera.colaVacia()){
                NodoCola x = colaEspera.quitar();
                System.out.format(formatoTabla, x.getDato().getApellido(), x.getDato().getCantComensales(), x.getDato().getNumMesa());
                aux.insertar(x);
            }
            retornar(aux, colaEspera);
        } else {
            Consola.prtRed("Cola Vacia");
        }
    }
    
    public void mostrarMesas(){
        NodoLista p = mesas.inicio();
        System.out.format("%18s\n", "Mesas");
        String formatoTabla = "%-12s%-20s%-15s\n";
        System.out.format(formatoTabla, "Codigo", "Max Comensales", "Ocupada");
        System.out.format(formatoTabla, "------", "--------------", "-------");  
        while (p != null){
            p.getDato().imprimir(formatoTabla);
            p = p.getPs();
        }
    }
    
    public void liberarMesa(){
        int cod = Consola.cargarInt(0, "Codigo de Mesa: ");
        if (mesas.buscar(cod)){
            NodoLista p = mesas.inicio();
            while (p != null){
                if (cod == p.getDato().getNumeroMesa()){
                    p.getDato().setOcupada(false);
                    actualizarCliente(cod);
                    asignarEnEspera();
                }
                p = p.getPs();
            }
        } else {
            Consola.prtRed("Mesa Inexistente");
        }
    }
    
    public void asignarEnEspera(){
        Cola aux = new Cola();
        while (!colaEspera.colaVacia()){
            NodoCola x = colaEspera.quitar();
            asignarMesa(x.getDato());
        }
    }
    
    public void actualizarCliente(int cod){
        Cola aux = new Cola();
        while (!clientes.colaVacia()){
            NodoCola x = clientes.quitar();
            if (x.getDato().getNumMesa() != cod){
                aux.insertar(x);
            }
        }
        retornar(aux, clientes);
    }
    
    public void retornar(Cola A, Cola B){
        NodoCola x;
        while (!A.colaVacia()) {
            x = A.quitar();
            B.insertar(x);
        }
    }
    
    public void cargarMesas(){
        Mesa m1 = new Mesa(6, 8, false);
        Mesa m2 = new Mesa(5, 4, false);
        Mesa m3 = new Mesa(4, 2, false);
        Mesa m4 = new Mesa(3, 2, false);
        Mesa m5 = new Mesa(2, 6, false);
        Mesa m6 = new Mesa(1, 8, false);
        mesas.insertar(m1);
        mesas.insertar(m2);
        mesas.insertar(m3);
        mesas.insertar(m4);
        mesas.insertar(m5);
        mesas.insertar(m6);
    }
    
    public void menuDeOpciones() {
        int op;
        do {
            System.out.println("\n---Restaurante---");
            System.out.println("1. Asiganar Mesas");
            System.out.println("2. Mostrar Clientes c/Mesa");
            System.out.println("3. Mostrar Clientes en Espera");
            System.out.println("4. Mostrar Mesas");
            System.out.println("5. Liberar Mesa");
            System.out.println("0. Salir");
            op = Consola.cargarInt(0,"-->");
            System.out.println("");
            switch (op) {
                case 1: cargarCliente();
                        break;
                case 2: mostrarCcM();
                        break;
                case 3: mostrarCeE();
                        break;
                case 4: mostrarMesas();
                        break;
                case 5: liberarMesa();
                        break;
                case 0: break;
            }
        } while (op != 0);
    }
    
    public static void main(String[] args) {
        Principal app = new Principal();
        app.cargarMesas();
        app.menuDeOpciones();
    }
    
}
