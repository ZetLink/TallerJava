public class Lista {

    private Nodo list;

//	************************************* CONSTRUCTOR ******************************************************
    public Lista() {
        list = null;
    }

//	***************************************** INICIO *******************************************************
    public Nodo inicio() {
        return list;
    }

//	***************************************** INICIO *******************************************************
    public boolean listaVacia() {
        return (list == null);
    }

//	********************************** INSERTAR AL PRINCIPIO ***********************************************
    public void insertarPri(int elem) {
        Nodo x = new Nodo(elem);
        if (list == null) {
            list = x;
        } else {
            x.setPs(list);
            list = x;
        }
    }

//	********************************** INSERTAR AL MEDIO ***********************************************
    public void insertarUlt(int elem, Nodo a) {
        Nodo x = new Nodo(elem);
        a.setPs(x);

    }

//	***************************************** INSERTAR *************************************************

    public void insertar(int entrada) {
        Nodo p = inicio();
        Nodo ant = null;
        int b = 0;

        while (p != null && b == 0) {
            if (p.getDato() > entrada) {
                b = 1;
            } else {
                ant = p;
                p = p.getPs();
            }
        }
        Nodo x = new Nodo(entrada);
        if (b == 1) {
            if (p == list) {
                insertarPri(entrada);
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

    public void prt(String s) {
        System.out.println(s);
    }

//	******************************************** QUITAR ****************************************************
    public Nodo quitar(Nodo p, Nodo ant) {
        Nodo x = p;

        if (p == inicio()) {
            list = p.getPs();
        } else {
            ant.setPs(p.getPs());
        }
        return x;
    }

    public Nodo eliminar(int elem) {
        Nodo x = null;
        Nodo p = inicio();
        Nodo ant = null;
        if (listaVacia()) {
            System.out.println("Lista Vacía!!!");
            return x;
        }
        boolean band = false;
        while (p != null && !band) {
            if (p.getDato() >= elem) {
                if (p.getDato() == elem) {
                    x = quitar(p, ant);
                    band = true;
                } else {
                    p = null;
                }
            } else {
                ant = p;
                p = p.getPs();
            }
        }
        if (band == true) {

            System.out.println("Elemento eliminado!");
        } else {
            System.out.println("Elemento inexistente!!!");
        }
        return x;
    }

    
    /*----------------------------Insertar al medio-------------------------*/
    public void insertarMedio(Nodo p, Nodo ant, Nodo x) {
        x.setPs(p);
        ant.setPs(x);
    }
    
    /*---------------------------Insertar al final-------------------------*/
    public void insertarFin(Nodo ant, Nodo p, Nodo x) {
        if (p == null) {
            x.setPs(null);
            ant.setPs(x);
        }
    }


}
