import java.util.*;

public class SetToSortedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter integers for the Set (space-separated):");
        Set<Integer> set = new HashSet<>();
        for (String s : sc.nextLine().split(" ")) {
            set.add(Integer.parseInt(s));
        }

        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);

        System.out.println("Sorted List: " + sortedList);
    }
}
