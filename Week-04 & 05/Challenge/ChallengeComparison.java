import java.io.*;

public class ChallengeComparison {
    public static void main(String[] args) throws IOException {
        int N = 1_000_000;

        // StringBuilder
        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append("hello");
        long builderTime = System.nanoTime() - start;

        // StringBuffer
        start = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < N; i++) sbf.append("hello");
        long bufferTime = System.nanoTime() - start;

        System.out.println("StringBuilder Time: " + builderTime / 1_000_000.0 + " ms");
        System.out.println("StringBuffer Time : " + bufferTime / 1_000_000.0 + " ms");

        // FileReader word count
        BufferedReader fr = new BufferedReader(new FileReader("bigfile.txt"));
        int words = 0;
        String line;
        start = System.nanoTime();
        while ((line = fr.readLine()) != null) {
            words += line.split("\\s+").length;
        }
        long frTime = System.nanoTime() - start;
        fr.close();

        // InputStreamReader word count
        BufferedReader isr = new BufferedReader(new InputStreamReader(new FileInputStream("bigfile.txt")));
        int words2 = 0;
        start = System.nanoTime();
        while ((line = isr.readLine()) != null) {
            words2 += line.split("\\s+").length;
        }
        long isrTime = System.nanoTime() - start;
        isr.close();

        System.out.println("FileReader Word Count: " + words + " in " + frTime / 1_000_000.0 + " ms");
        System.out.println("InputStreamReader Word Count: " + words2 + " in " + isrTime / 1_000_000.0 + " ms");
    }
}
