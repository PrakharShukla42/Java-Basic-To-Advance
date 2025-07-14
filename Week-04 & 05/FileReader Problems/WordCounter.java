import java.io.*;

public class WordCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("file.txt"));
        String word = "Java";
        int count = 0;
        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String w : words) {
                if (w.equalsIgnoreCase(word)) count++;
            }
        }
        br.close();
        System.out.println("Occurrences of '" + word + "': " + count);
    }
}
