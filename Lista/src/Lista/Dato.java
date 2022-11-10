package Lista;


public class Dato {
    private int num;
    private String uwu;

    public Dato(int num, String uwu) {
        this.num = num;
        this.uwu = uwu;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getUwu() {
        return uwu;
    }

    public void setUwu(String uwu) {
        this.uwu = uwu;
    }
    
    public void mostrarDatos(){
        System.out.println(String.format("| %6d | %-15s |", num, uwu));
    }
}
