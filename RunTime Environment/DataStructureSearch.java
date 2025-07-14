import java.util.*;

public class DataStructureSearch {
    public static void main(String[] args) {
        int N = 1_000_000;
        int target = N - 1;

        // Array
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = i;

        long start = System.nanoTime();
        for (int val : arr) {
            if (val == target) break;
        }
        long arrayTime = System.nanoTime() - start;

        // HashSet
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < N; i++) hashSet.add(i);
        start = System.nanoTime();
        hashSet.contains(target);
        long hashTime = System.nanoTime() - start;

        // TreeSet
        Set<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < N; i++) treeSet.add(i);
        start = System.nanoTime();
        treeSet.contains(target);
        long treeTime = System.nanoTime() - start;

        System.out.println("Array Search: " + arrayTime / 1_000_000.0 + " ms");
        System.out.println("HashSet Search: " + hashTime / 1_000_000.0 + " ms");
        System.out.println("TreeSet Search: " + treeTime / 1_000_000.0 + " ms");
    }
}
