import java.util.Arrays;

public class Tarea5 {
    //Codigo BUSQUEDA LINEAL
    public static int busquedaLineal(int[]lista, int dato){
        int n = lista.length;
        int i = 0;
        while (i < n && dato != lista[i]){
            i++;
        }
        if (n == i) {
            return -1;
        } else {
            return i;
        }
    }
    // Codigo BUSQUEDA LINEAL CON CENTINELA
    public static int busquedaLinealCentinela(int[] lista, int dato) {
        int ultimoTmp = lista[lista.length - 1];
        lista[lista.length - 1] = dato;
        int i = 0;
        while (lista[i] != dato) {
            i++;
        }

        lista[lista.length - 1] = ultimoTmp;

        if (i < lista.length - 1 || lista[lista.length - 1] == dato) {
            return i;
        } else {
            return -1;
        }
    }
    // BUSQUEDA BINARIA
    public static int busquedaBinaria(int[] lista, int dato, int inicio, int fin) {
        if (inicio > fin) {
            return -1;
        }

        int mid = inicio + (fin - inicio) / 2;

        if (lista[mid] == dato) {
            return mid;
        } else if (dato < lista[mid]) {
            return busquedaBinaria(lista, dato, inicio, mid - 1);
        } else {
            return busquedaBinaria(lista, dato, mid + 1, fin);
        }
    }

    public static void main(String[] args) {
        // Lineal
        int[] listaNoOrd = {8,3,6,4,2,1,10,5,7,12,0};
        int datoABuscar = 11;
        int resultadoLineal = busquedaLineal(listaNoOrd, datoABuscar);

        System.out.println("-----***********    Búsqueda Lineal    *********** -----");
        System.out.println("Lista: " + Arrays.toString(listaNoOrd) + " , Dato a buscar: " + datoABuscar);

        if (resultadoLineal != -1) {
            System.out.println("Se encontró el numero " + datoABuscar + " en la posición: " + resultadoLineal);
        } else {
            System.out.println("No se encontró el numero " + datoABuscar + " en la lista");
        }

        // Lineal con Centinela
        int[] listaCentinela = {0,1,4,5,6,8,10,11,13,15,16,17,18,20,24};
        int datoBusCent = 3;

        System.out.println("\n-----***********    Búsqueda Lineal con Centinela   *********** -----");
        System.out.println("Lista: " + Arrays.toString(listaCentinela) + " , Dato a buscar: " + datoBusCent);

        int resultadoCentinela = busquedaLinealCentinela(listaCentinela, datoBusCent);

        if (resultadoCentinela != -1) {
            System.out.println("Se encontró el numero " + datoBusCent + " en la posición: " + resultadoCentinela);
        } else {
            System.out.println("No se encontró el numero " + datoBusCent + " en la lista");
        }

        // Binaria
        int[] listaOrd = {1, 2, 4, 5, 6, 8, 9,11,12,14,20};
        int datoBusBin = 7;

        System.out.println("\n-----***********    Búsqueda Binaria   *********** -----");
        System.out.println("Lista: " + Arrays.toString(listaOrd) + " , Dato a buscar: " + datoBusBin);

        int resultadoBinaria = busquedaBinaria(listaOrd, datoBusBin, 0, listaOrd.length - 1);

        if (resultadoBinaria != -1) {
            System.out.println("Se encontró el numero " + datoBusBin + " en la posición: " + resultadoBinaria);
        } else {
            System.out.println("No se encontró el numero " + datoBusBin + " en la lista");
        }
    }
}


