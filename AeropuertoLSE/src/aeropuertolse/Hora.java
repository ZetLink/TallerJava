package aeropuertolse;


public class Hora {
    private int HH;
    private int MM;

    public Hora(int HH, int MM) {
        this.HH = HH;
        this.MM = MM;
    }

    public Hora() {
        
    }

    public int getHH() {
        return HH;
    }

    public void setHH(int HH) {
        this.HH = HH;
    }

    public int getMM() {
        return MM;
    }

    public void setMM(int MM) {
        this.MM = MM;
    }
    
    
}
