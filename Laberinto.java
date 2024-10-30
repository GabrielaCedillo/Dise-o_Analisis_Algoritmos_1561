package Tarea9;

public class Laberinto {
    static char[][] laberinto = {
            {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
            {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
            {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
            {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
            {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
            {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
            {'p', 'p', 'c', 'c', 'c', 'c', 'c', 'p'},
            {'p', 'p', 'c', 'p', 'p', 'p', 'c', 'p'},
            {'p', 'p', 'c', 'c', 'c', 'p', 'c', 'p'},
            {'p', 'p', 'p', 'p', 'c', 'p', 'c', 's'},
            {'p', 'p', 'X', 'p', 'c', 'p', 'p', 'p'},
            {'p', 'X', 'c', 'c', 'c', 'c', 'p', 'p'},
            {'p', 'p', 'c', 'p', 'p', 'p', 'p', 'p'},
            {'p', 'p', 'E', 'p', 'p', 'p', 'p', 'p'}
    };
    //importamos el laberinto proporcionado por el profesor

    static final int Filas = laberinto.length;
    static final int Columnas = laberinto[0].length;

    static int[] entrada = {13, 2};
    static int[] salida = {9, 7};

    static int[][] direcciones = {
            {-1, 0}, {0, -1}, {1, 0}, {0, 1}
    };

    public static boolean resolverLaberinto(int x, int y, java.util.List<int[]> camino) {
        if (x == salida[0] && y == salida[1]) {
            return true;
        }

        laberinto[x][y] = 'X';

        for (int[] dir : direcciones) {
            int x1 = x + dir[0];
            int y1 = y + dir[1];

            if (x1 >= 0 && x1 < Filas && y1 >= 0 && y1 < Columnas && (laberinto[x1][y1] == 'c' || laberinto[x1][y1] == 's')) {
                camino.add(new int[]{x1, y1});
                if (resolverLaberinto(x1, y1, camino)) {
                    return true;
                }
                camino.remove(camino.size() - 1);
            }
        }

        laberinto[x][y] = 'c';
        return false;
    }

    public static void main(String[] args) {
        java.util.List<int[]> camino = new java.util.ArrayList<>();
        camino.add(entrada);

        if (resolverLaberinto(entrada[0], entrada[1], camino)) {
            System.out.println("Camino sugerido:");
            for (int[] paso : camino) {
                System.out.println("(" + paso[0] + ", " + paso[1] + ")");
            }
        } else {
            System.out.println("No se encontró ningun camino posible");
        }
    }
}

