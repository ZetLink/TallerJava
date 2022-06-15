package herencia1;

import java.util.Scanner;

public class Alumno extends Persona{
 
    private String curso;
    
    public String getCurso() {
        return curso;
    }
 
 
    public void setCurso(String curso) {
        this.curso = curso;
    }
 
 
    @Override
    public void leer(){
        super.leer();
        Scanner sc = new Scanner(System.in);
        System.out.print("Curso: ");
        curso = sc.nextLine();
    }
}

