import java.util.ArrayList;
import java.util.List;

public class Monedas {
        public static List<Integer> findMinCoins(int[] coins, int target) {
            List<Integer> minCombination = new ArrayList<>();
            int minCount = Integer.MAX_VALUE;

            // Todas las combinaciones de monedas
            int totalCombinations = (int) Math.pow(2, coins.length);
            for (int i = 1; i < totalCombinations; i++) {
                List<Integer> currentCombination = new ArrayList<>();
                int sum = 0;

                // Generar combinación a partir del número binario
                for (int j = 0; j < coins.length; j++) {
                    if ((i & (1 << j)) != 0) {
                        currentCombination.add(coins[j]);
                        sum += coins[j];
                    }
                }

                // Verificar si la suma es igual al objetivo
                if (sum == target && currentCombination.size() < minCount) {
                    minCount = currentCombination.size();
                    minCombination = new ArrayList<>(currentCombination);
                }
            }

            // No se encontró ninguna combinación
            return minCombination.isEmpty() ? null : minCombination;
        }

        public static void main(String[] args) {
            int[] coins = {1, 2, 5,10};
            int target = 13;

            List<Integer> result = findMinCoins(coins, target);

            if (result != null) {
                System.out.println("La combinación de monedas para sumar " + target + " es: " + result);
            } else {
                System.out.println("Necesita billetes" + target);
            }
        }
}
