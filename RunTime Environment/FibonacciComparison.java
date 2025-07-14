public class FibonacciComparison {
    public static int fibRecursive(int n) {
        if (n <= 1) return n;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    public static int fibIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int N = 30;

        long start = System.nanoTime();
        int r = fibRecursive(N);
        long recursiveTime = System.nanoTime() - start;

        start = System.nanoTime();
        int i = fibIterative(N);
        long iterativeTime = System.nanoTime() - start;

        System.out.println("Recursive Time: " + recursiveTime / 1_000_000.0 + " ms");
        System.out.println("Iterative Time: " + iterativeTime / 1_000_000.0 + " ms");
        System.out.println("Both returned: " + r + " and " + i);
    }
}
