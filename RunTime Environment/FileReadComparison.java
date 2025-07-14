import java.io.*;

public class FileReadComparison {
    public static void main(String[] args) throws IOException {
        File file = new File("largefile.txt"); // Create a 100MB+ file manually for test

        // FileReader
        long start = System.nanoTime();
        try (FileReader fr = new FileReader(file)) {
            while (fr.read() != -1) ;
        }
        long fileReaderTime = System.nanoTime() - start;

        // InputStreamReader
        start = System.nanoTime();
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(file))) {
            while (isr.read() != -1) ;
        }
        long inputStreamTime = System.nanoTime() - start;

        System.out.println("FileReader Time: " + fileReaderTime / 1_000_000.0 + " ms");
        System.out.println("InputStreamReader Time: " + inputStreamTime / 1_000_000.0 + " ms");
    }
}
