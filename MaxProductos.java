public class MaxProductos {

    public static void main(String[] args) {
        int[] A = {-2,1,0,9,-9,5,6,7,-6,8,10};

        int maxProducto = Integer.MIN_VALUE;
        int[] parNumeros = new int[2];

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int producto = A[i] * A[j];
                if (producto > maxProducto) {
                        maxProducto = producto;
                        parNumeros[0] = A[i];
                        parNumeros[1] = A[j];
                }
            }
        }

            System.out.printf("El producto máximo es %d, obtenido por el par [%d, %d]%n", maxProducto, parNumeros[0], parNumeros[1]);
    }
}

