public class Fibonacci {
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 14;
        System.out.println("La serie Fibonnaci de  " + n + " es: " + fibonacci(n));
        for (int i = 0; i < n+1; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
}