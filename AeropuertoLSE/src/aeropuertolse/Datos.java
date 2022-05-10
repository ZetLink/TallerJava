package aeropuertolse;

public class Datos {
    private int cod_vuelo;
    private Hora hora;

    public Datos(int cod_vuelo, Hora hora) {
        this.cod_vuelo = cod_vuelo;
        this.hora = hora;
    }

    public int getCod_vuelo() {
        return cod_vuelo;
    }

    public void setCod_vuelo(int cod_vuelo) {
        this.cod_vuelo = cod_vuelo;
    }

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }
    
    
}
