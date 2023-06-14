package principal;

public class MetodosRecursivos {
    
    public int sumarNaturales(int num){
        return num == 0 ? 0 : num + sumarNaturales(num - 1);
    }
    
    public int calcularPotencia(int x, int n){
        return n == 0 ? 1 : x * calcularPotencia(x,n - 1);
    }
    
    public int invertirNumero(int numero) {
        if (numero < 10) {
            return numero;
        } else {
            int ultimo = numero % 10;
            int resto = numero / 10;
            int longitudResto = String.valueOf(resto).length();
            return (ultimo * calcularPotencia(10, longitudResto)) + invertirNumero(resto);
        }
    }
    
    public int sumarDigitos(int num){
        if (num < 10){
            return num;
        } else {
            int ultimo = num % 10;
            int resto = num / 10;
            return ultimo + sumarDigitos(resto);
        }
    }
    
    public boolean digitoAusente(int d, int num){
        if (num == 0){
            return true;
        } else if(num % 10 == d) {
            return false;
        } else {
            return digitoAusente(d, num / 10);
        }
    }
}
