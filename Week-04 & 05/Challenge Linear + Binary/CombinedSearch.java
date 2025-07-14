import java.util.*;

public class CombinedSearch {
    public static int findFirstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) if (num > 0) set.add(num);
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) return i;
        }
        return nums.length + 1;
    }

    public static int binarySearch(int[] arr, int target) {
        Arrays.sort(arr);
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
}
