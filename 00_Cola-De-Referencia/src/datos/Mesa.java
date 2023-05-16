package datos;

public class Mesa {
    private int numeroMesa;
    private int maxComensales;
    private boolean ocupada;

    public Mesa(int numeroMesa, int maxComensales, boolean ocupada) {
        this.numeroMesa = numeroMesa;
        this.maxComensales = maxComensales;
        this.ocupada = ocupada;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public int getMaxComensales() {
        return maxComensales;
    }

    public void setMaxComensales(int maxComensales) {
        this.maxComensales = maxComensales;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public void imprimir(String cant) {
        System.out.format(cant, getNumeroMesa(), getMaxComensales(), isOcupada());
    }
}
