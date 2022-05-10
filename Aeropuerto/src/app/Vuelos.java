package app;

class Vuelos {
    private int cod_vuelo;
    private String destino;
    private Hora hora;
    private Fecha fecha;

    public Vuelos(int cod_vuelo, String destino, Hora hora, Fecha fecha) {
        this.cod_vuelo = cod_vuelo;
        this.destino = destino;
        this.hora = hora;
        this.fecha = fecha;
    }
    
    public Vuelos(){
        
    }
    
    /*public Vuelos cargarVuelo(){
        System.out.println("Ingrese el codigo de vuelo");
        setCod_vuelo(Consola.leerInt());
        
        System.out.println("Ingrese el destino");
        setDestino(Consola.leerDatoString());
        
        Hora h = new Hora();
        System.out.println("Ingrese la hora y minutos");
        setHora(h.cargarHora());
        
        Fecha f = new Fecha();
        System.out.println("Ingrese la fecha (D/M/A)");
        setFecha(f.cargarFecha());
        
        Vuelos v = new Vuelos(getCod_vuelo(),getDestino(),getHora(),getFecha());
        return v;
    }*/
    
    public int getCod_vuelo() {
        return cod_vuelo;
    }

    public void setCod_vuelo(int cod_vuelo) {
        this.cod_vuelo = cod_vuelo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }
    
}
