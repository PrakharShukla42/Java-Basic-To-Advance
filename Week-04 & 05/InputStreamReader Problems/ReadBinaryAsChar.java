import java.io.*;

public class ReadBinaryAsChar {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(new FileInputStream("file.txt"), "UTF-8");
        BufferedReader br = new BufferedReader(reader);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}
