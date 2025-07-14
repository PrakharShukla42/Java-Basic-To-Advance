public class ReverseString {
    public static void main(String[] args) {
        String input = "hello";
        StringBuilder sb = new StringBuilder(input);
        String reversed = sb.reverse().toString();
        System.out.println("Reversed: " + reversed);
    }
}
