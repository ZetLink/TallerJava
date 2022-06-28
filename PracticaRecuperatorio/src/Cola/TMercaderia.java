/*
-Cada conductor cobra un sueldo fijo de $2500 al que hay que sumar $75 por cada hora conducida en cualquier
tipo de transporte. 

-Transporte de mercadería: extra de $5 por tonelada transportada
*/

package Cola;

public class TMercaderia extends Transporte {

    public TMercaderia(int peso) {
        this.peso = peso;
    }
    
    public int calcularMonto(float fijo, int horas){
        int monto = (75 * horas) + (int)fijo;
        monto = monto + (5 * peso);
        return monto;
    }
    
}
