package arbol;

import utilidades.Consola;

public class Palabra {
    private int cod;
    private String palabra;
    private char letra;
    private int pag;
    private String sector;

    public Palabra() {
        this.cod = 0;
        this.palabra = "";
        this.letra = ' ';
        this.pag = 0;
        this.sector = "";
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public int getPag() {
        return pag;
    }

    public void setPag(int pag) {
        this.pag = pag;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
    
    public void cargarDatos(){
        setCod(Consola.readInt(0, "Codigo: "));
        setPalabra(Consola.readString("Palabra: ").toLowerCase());
        setLetra(getPalabra().charAt(0));
        setPag(Consola.readInt(0, "Pagina: "));
        setSector(Consola.readString("Sector: "));
    }
    
    public void imprimirDato(){
        String format = "| %-4s | %20s | %-4s | %-4s | %-10s |";
        System.out.println(String.format(format, getCod(), getPalabra(), getLetra(), getPag(), getSector()));
    }
}
