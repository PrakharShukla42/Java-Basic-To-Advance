public class PerformanceComparison {
    public static void main(String[] args) {
        int N = 1_000_000;

        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append("hello");
        long builderTime = System.nanoTime() - start;

        start = System.nanoTime();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < N; i++) sf.append("hello");
        long bufferTime = System.nanoTime() - start;

        System.out.println("StringBuilder: " + builderTime / 1_000_000.0 + " ms");
        System.out.println("StringBuffer : " + bufferTime / 1_000_000.0 + " ms");
    }
}
