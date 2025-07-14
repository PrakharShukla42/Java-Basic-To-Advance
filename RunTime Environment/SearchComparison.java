import java.util.*;

public class SearchComparison {
    public static void main(String[] args) {
        int N = 1_000_000;
        int[] data = new int[N];
        for (int i = 0; i < N; i++) data[i] = i;
        int target = N - 1;

        // Linear Search
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            if (data[i] == target) break;
        }
        long linearTime = System.nanoTime() - start;

        // Binary Search
        start = System.nanoTime();
        Arrays.sort(data); // Already sorted, skip in real case
        Arrays.binarySearch(data, target);
        long binaryTime = System.nanoTime() - start;

        System.out.println("Linear Search Time: " + linearTime / 1_000_000.0 + " ms");
        System.out.println("Binary Search Time: " + binaryTime / 1_000_000.0 + " ms");
    }
}
