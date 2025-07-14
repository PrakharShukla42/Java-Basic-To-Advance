import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String input = "programming";
        StringBuilder sb = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (char ch : input.toCharArray()) {
            if (!seen.contains(ch)) {
                seen.add(ch);
                sb.append(ch);
            }
        }
        System.out.println("Without Duplicates: " + sb.toString());
    }
}
