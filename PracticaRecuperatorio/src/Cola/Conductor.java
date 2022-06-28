package Cola;

import EntradaSalida.Consola;

public class Conductor {
    private int dni;
    private float sueldo;
    private int cantHoras;
    private Transporte transporte;
    private float fijo;

    public Conductor(int dni, int cantHoras) {
        this.dni = dni;
        this.cantHoras = cantHoras;
        this.fijo = 2500;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public int getCantHoras() {
        return cantHoras;
    }

    public void setCantHoras(int cantHoras) {
        this.cantHoras = cantHoras;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public float getFijo() {
        return fijo;
    }

    public void setFijo(float fijo) {
        this.fijo = fijo;
    }
    
    public void asignarTransporte(){
        int monto = 0;
            System.out.println("Asginar transporte");
            System.out.println("1) Personas");
            System.out.println("2) Mercaderia");
            System.out.println("3) Mercaderia Peligrosa");
            System.out.println("Opcion: ");
            int opcion = Consola.leerInt();
             
            switch (opcion) {
                case 1:
                    System.out.print("Cantidad de Personas: ");
                    int cant_p = Consola.leerInt();
                    TPersonas tp = new TPersonas(cant_p);
                    monto = tp.calcularMonto(fijo, cantHoras);
                    transporte = tp;
                    System.out.println(" ");
                    break;
                case 2:
                    System.out.print("Peso en Toneladas: ");
                    int peso = Consola.leerInt();
                    TMercaderia tm = new TMercaderia(peso);
                    monto = tm.calcularMonto(fijo, cantHoras);
                    transporte = tm;
                    System.out.println(" ");
                    break;
                case 3:
                    System.out.print("Cantidad de Personas: ");
                    int cant = Consola.leerInt();
                    System.out.print("Peso en Toneladas: ");
                    int p = Consola.leerInt();
                    TMercaderiaPeligrosa tmp = new TMercaderiaPeligrosa(cant,p);
                    monto = tmp.calcularMonto(fijo,cantHoras);
                    transporte = tmp;
                    System.out.println(" ");
                    break;
            }
            sueldo = monto;
    }
}
