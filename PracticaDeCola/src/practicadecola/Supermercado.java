package practicadecola;

public class Supermercado {
    private int cant_prod;
    private float monto_reca;
    private char t_pago;

    public Supermercado(int cant_prod, float monto_reca, char t_pago) {
        this.cant_prod = cant_prod;
        this.monto_reca = monto_reca;
        this.t_pago = t_pago;
    }

    public int getCant_prod() {
        return cant_prod;
    }

    public void setCant_prod(int cant_prod) {
        this.cant_prod = cant_prod;
    }

    public float getMonto_reca() {
        return monto_reca;
    }

    public void setMonto_reca(float monto_reca) {
        this.monto_reca = monto_reca;
    }

    public char getT_pago() {
        return t_pago;
    }

    public void setT_pago(char t_pago) {
        this.t_pago = t_pago;
    }
    
    
}
