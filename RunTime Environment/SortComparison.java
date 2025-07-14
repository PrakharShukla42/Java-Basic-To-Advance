import java.util.*;

public class SortComparison {
    public static void main(String[] args) {
        int N = 10_000;
        Random rand = new Random();
        int[] original = rand.ints(N, 0, N).toArray();

        // Bubble Sort (Don't run for >10k)
        int[] arr = Arrays.copyOf(original, original.length);
        long start = System.nanoTime();
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        long bubbleTime = System.nanoTime() - start;

        // Merge Sort
        arr = Arrays.copyOf(original, original.length);
        start = System.nanoTime();
        Arrays.sort(arr); // Default is Dual-Pivot QuickSort in Java, behaves like MergeSort for timing
        long mergeTime = System.nanoTime() - start;

        System.out.println("Bubble Sort Time: " + bubbleTime / 1_000_000.0 + " ms");
        System.out.println("Merge/Quick Sort Time: " + mergeTime / 1_000_000.0 + " ms");
    }
}
