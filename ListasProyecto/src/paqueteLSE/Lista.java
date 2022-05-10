package paqueteLSE;

public class Lista {

    private Nodo list;

//	************************************* CONSTRUCTOR ******************************************************
    public Lista() {
        list = null;
    }

//	***************************************** INICIO *******************************************************
    public Nodo Inicio() {
        return list;
    }

//	***************************************** INICIO *******************************************************
    public boolean listaVacia() {
        return (list == null);
    }

//	********************************** INSERTAR AL PRINCIPIO ***********************************************
    public void insertarpri(int elem) {
        Nodo x = new Nodo(elem);
        if (list == null) {
            list = x;
        } else {
            x.setPs(list);
            list = x;
        }
    }

//	******************************************** QUITAR ****************************************************
    public Nodo quitar(Nodo p, Nodo ant) {
        Nodo x = p;

        if (p == list) {
            list = p.getPs();
        } else {
            ant.setPs(p.getPs());

        }
        return x;
    }

    public Nodo eliminar(int elem) {
        Nodo x = null;
        Nodo p = list;
        Nodo ant = null;
        if(list == null)
            return x;
        boolean band = false;
        while (p != null && !band) {
            if (p.getDato() == elem) {
                band = true;
            } else {
                ant = p;
                p = p.getPs();

            }
        }
        if (band == true) {
            quitar(p, ant);
            x = p;
        }
        return x;
    }
    
    public boolean buscarElem(int elem){
        Nodo x = null;
        Nodo p = list;
        Nodo ant = null;
        if(list == null)
            return false;
        while (p != null) {
            if (p.getDato() == elem) {
                return true;
            } else {
                ant = p;
                p = p.getPs();

            }
        }
        return false;
    }
}
