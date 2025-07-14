public class StringConcatPerformance {
    public static void main(String[] args) {
        int N = 10_000;

        // String
        long start = System.nanoTime();
        String s = "";
        for (int i = 0; i < N; i++) s += "a";
        long stringTime = System.nanoTime() - start;

        // StringBuilder
        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append("a");
        long builderTime = System.nanoTime() - start;

        // StringBuffer
        start = System.nanoTime();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < N; i++) sf.append("a");
        long bufferTime = System.nanoTime() - start;

        System.out.println("String Time: " + stringTime / 1_000_000.0 + " ms");
        System.out.println("StringBuilder Time: " + builderTime / 1_000_000.0 + " ms");
        System.out.println("StringBuffer Time: " + bufferTime / 1_000_000.0 + " ms");
    }
}
