package Tarea8;

public class Mochila {
    public static int mochila(int[] pesos, int[] valores, int capacidad, int indice) {
        // Caso base
        if (indice == 0 || capacidad == 0) {
            return 0;
        }

        // Si el peso del objeto en el índice actual excede la capacidad
        if (pesos[indice - 1] > capacidad) {
            return mochila(pesos, valores, capacidad, indice - 1);
        }

        // No incluir el objeto actual
        int opcion_1 = mochila(pesos, valores, capacidad, indice - 1);

        // Incluir el objeto actual
        int opcion_2 = valores[indice - 1] + mochila(pesos, valores, capacidad - pesos[indice - 1], indice - 1);

        // Devolver el mayor valor entre las dos opciones
        return Math.max(opcion_2, opcion_1);
    }

    public static void main(String[] args) {
        int[] pesos = {1, 2, 3, 5, 6};
        int[] valores = {3, 4, 5, 10,11};
        int capacidad = 7;
        int indice = pesos.length;

        int maximo = mochila(pesos, valores, capacidad, indice);

        System.out.println("Pesos : " + java.util.Arrays.toString(pesos));
        System.out.println("Valores : " + java.util.Arrays.toString(valores));
        System.out.println("El valor máximo que se puede obtener es: " + maximo);
    }
}
