/*
-Cada conductor cobra un sueldo fijo de $2500 al que hay que sumar $75 por cada hora conducida en cualquier
tipo de transporte. 

-Transporte de personas: extra de $25 por hora si se trata de transporte de colectivo (el número de
personas transportadas es mayor de 9) y $10 si no es transporte colectivo
*/
package Cola;

public class TPersonas extends Transporte {

    public TPersonas(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public int calcularMonto(float fijo, int horas){
        int monto = (75 * horas) + (int)fijo;
        if (cantidad > 9){
            monto = monto + (25 * horas);
        } else {
            monto = monto + (10 * horas);
        }
        return monto;
    }
    
}
