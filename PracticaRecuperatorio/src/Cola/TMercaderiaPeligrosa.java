/*
-Cada conductor cobra un sueldo fijo de $2500 al que hay que sumar $75 por cada hora conducida en cualquier
tipo de transporte.

-Transporte de mercadería peligrosa: igual que el transporte de mercadería más un fijo extra de $200 por
cada transporte realizado.
*/

package Cola;

public class TMercaderiaPeligrosa extends Transporte {
    
    private int extra;
    
    public TMercaderiaPeligrosa(int peso, int cantidad) {
        this.peso = peso;
        this.cantidad = cantidad;
    }

    public int getExtra() {
        return extra;
    }

    public void setExtra(int extra) {
        this.extra = extra;
    }
    
    public int calcularMonto(float fijo, int horas){
        int monto = (75 * horas) + (int)fijo;
        monto = monto + (200 * peso);
        return monto;
    }
    
}
