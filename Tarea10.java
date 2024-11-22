package Tarea10;

import java.util.*;

public class Tarea10 {
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
    //reutilizamos el codigo del laberinto.
    public static void pintarLaberinto(char[][] laberinto) {
        for (int i = 0; i < laberinto.length; i++) {
            System.out.printf("%2d %s%n", i, Arrays.toString(laberinto[i]));
        }
    }

    public static boolean verificarMovimiento(char[][] laberinto, int x, int y) {
        int filas = laberinto.length;
        int columnas = laberinto[0].length;
        return x >= 0 && x < filas && y >= 0 && y < columnas && laberinto[x][y] != 'p';
    }

    public static int[] buscarEntrada(char[][] laberinto, char entrada, char salida) {
        int[] resultado = new int[4]; // [entradaX, entradaY, salidaX, salidaY]
        Arrays.fill(resultado, -1);
        for (int x = 0; x < laberinto.length; x++) {
            for (int y = 0; y < laberinto[x].length; y++) {
                if (laberinto[x][y] == entrada) {
                    resultado[0] = x;
                    resultado[1] = y;
                }
                if (laberinto[x][y] == salida) {
                    resultado[2] = x;
                    resultado[3] = y;
                }
            }
        }
        return resultado;
    }

    public static int distanciaManhattan(int[] actual, int[] objetivo) {
        return Math.abs(actual[0] - objetivo[0]) + Math.abs(actual[1] - objetivo[1]);
    }

    public static void main(String[] args) {
        char entrada = 'E';
        char salida = 's';

        int[] ubicaciones = buscarEntrada(laberinto, entrada, salida);

        int entradaX = ubicaciones[0], entradaY = ubicaciones[1];
        int salidaX = ubicaciones[2], salidaY = ubicaciones[3];

        if (entradaX == -1 || salidaX == -1) {
            System.out.println("Laberinto inválido");
            return;
        }

        System.out.println("Laberinto:");
        pintarLaberinto(laberinto);

        PriorityQueue<int[]> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        colaPrioridad.add(new int[]{0, entradaX, entradaY});

        Set<String> visitados = new HashSet<>();
        visitados.add(entradaX + "," + entradaY);

        laberinto[entradaX][entradaY] = 'Y';

        boolean solucionEncontrada = false;
        int numMovimientos = 0;

        while (!colaPrioridad.isEmpty() && !solucionEncontrada) {
            int[] nodo = colaPrioridad.poll();
            int x = nodo[1], y = nodo[2];

            if (x == salidaX && y == salidaY) {
                laberinto[x][y] = 'O';
                solucionEncontrada = true;
                break;
            }

            int[][] movimientos = {
                    {x - 1, y}, {x + 1, y}, {x, y - 1}, {x, y + 1}
            };

            for (int[] mov : movimientos) {
                int movX = mov[0], movY = mov[1];
                String clave = movX + "," + movY;

                if (verificarMovimiento(laberinto, movX, movY) && !visitados.contains(clave)) {
                    int prioridad = distanciaManhattan(new int[]{movX, movY}, new int[]{salidaX, salidaY});
                    colaPrioridad.add(new int[]{prioridad, movX, movY});
                    visitados.add(clave);
                    laberinto[movX][movY] = 'Y';
                    numMovimientos++;
                }
            }
        }

        if (solucionEncontrada) {
            System.out.println("Solución encontrada:");
            pintarLaberinto(laberinto);
            System.out.printf("Número de movimientos: %d%n", numMovimientos);
        } else {
            System.out.println("No se encontró solución al Laberinto.");
        }
    }

}
