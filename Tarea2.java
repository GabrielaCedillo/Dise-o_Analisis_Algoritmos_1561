import java.util.Arrays;

public class Tarea2 {
    public static void main(String[] args) {
        int[] entrada = {1, 2, 3};

        int contador = 0;  // T(n) = 1

        int numDatos = entrada.length;  // T(n) = 1

        System.out.println("Entrada: " + Arrays.toString(entrada));  // T(n) = 1

        for (int i = 0; i < numDatos; i++) {  // T(n) = n
            for (int j = 0; j < numDatos; j++) {  // T(n) = n
                System.out.println(entrada[i] + " " + entrada[j]);  // T(n) = 1
                contador++;  // T(n) = 1
            }
        }

        System.out.println("Final: " + contador);  // T(n) = 1

        //Complejidad Temporal T(n): 2n^2+5

    }
}
