package tallerpractica;

public class Lista {
    private Nodo list;
    
    public Lista(){
        list = null;
    }
    
    public Nodo inicio(){
        return list;
    }
    
    //verificar vacia
    public boolean listaVacia() {
        return (list == null);
    }
    
    /*ActA: Agregar empleados: ingresar los datos de los empleados, hasta que el operador decida no
    continuar, no puede haber documentos iguales en la lista.*/
    public void insertarPrim(Informacion e){
        Nodo N = new Nodo(e);
        if (list != null){
            N.setPs(list);
        }
        list = N;
    }
    
    public void insertarMedio(Nodo p, Nodo ant, Nodo x) {
        x.setPs(p);
        ant.setPs(x);
    }
    
    public void insertarFin(Nodo ant, Nodo p, Nodo x) {
        if (p == null) {
            x.setPs(null);
            ant.setPs(x);
        }
    }
    
    public void insertar(Informacion entrada) {
        Nodo p = inicio();
        Nodo ant = null;
        int b = 0;
        
        while (p != null && b == 0) {
            if (p.getDatos().getDNI() >= entrada.getDNI()) {
                b = 1;
            } else {
                ant = p;
                p = p.getPs();
            }
        }
        Nodo x = new Nodo(entrada);
        if (b == 1) {
            if (p == list) {
                insertarPrim(entrada);
            } else {
                insertarMedio(p, ant, x);
            }
        } else {
            if (ant == null) {
                list = x;
            } else {
                insertarFin(ant, p, x);
            }
        }
    }
    
    /*ActB: Actualizar sueldo: se ingresa la categoría del empleado y se actualizan los sueldos de acuerdo
    a un incremento ingresado en la variable Inc para dicha categoría.*/
    
    public void actualizarSueldo(char entrada, int Inc) {
        Nodo p = inicio();
        while (p != null) {
            if (p.getDatos().getCat() == entrada){
                float num = p.getDatos().getSueldo();
                float num2 = (num * Inc) / 100;
                p.getDatos().setSueldo(num + num2);
            }
            p = p.getPs();
        }
    }
    
    /*ActC: Baja de empleados: ingresar el documento del empleado, buscar en la lista y eliminarlo de la
    misma. Este método se realiza hasta que el operador decida no continuar.*/
    public Nodo eliminarElemento(int entrada){
        Nodo x = null;
        Nodo p = list;
        Nodo ant = null;
        boolean band = false;
        while(p!= null & !band){
            Informacion info = p.getDatos();
            if (info.getDNI() >= entrada) {
                if (info.getDNI() == entrada) {
                    band = true;
                }else{
                    p = null;
                }
            } else {
                ant = p;
                p = p.getPs();
            }
        }
        if(band == true){
           x = quitar(p,ant);
        }
        return x;
    }
    public Nodo quitar(Nodo p,Nodo a){
    Nodo x = p;
    if(p == list){
        list=p.getPs();
       
    } else
        a.setPs(p.getPs());
        return x;
    }
}
