//
//import java.io.*;
//import java.util.Scanner;
//import java.util.StringTokenizer;
//
//public class lab7_oj2 {
//    static int[][] f;
//
//    public static void main(String[] args) {
//        QReader in = new QReader();
//        QWriter out = new QWriter();
//        int n = in.nextInt();
//        int[] array = new int[n + 1];
//        for (int i = 1; i < n + 1; i++) {
//            array[i] = in.nextInt();
//        }
//        int row = (int) (Math.log(n) / Math.log(2));
//        f = new int[row +1 ][n];
//        int len = n - 1;
//        for (int i = 1; i < n; i++) {
//            f[0][i] = Math.abs(array[i + 1] - array[i]);
//        }
//        for (int i = 1; i < row; i++) {
//            int step = (int) (Math.pow(2, i - 1));
//            len -= step;
//            for (int j = 1; j <= len; j++) {
//                f[i][j] = gcd(f[i - 1][j], f[i - 1][j + step]);
//            }
//        }
//        int maxlength = 0;
//        for (int i = 1; i < n; i++) {
//            int l = i;
//            int r = n - 1;
//            while (l <= r) {
//                int mid = (l + r) / 2;
//                if (check(i, mid)) {
//                    l = mid + 1;
//                } else {
//                    r = mid - 1;
//                }
//            }
//            maxlength = Math.max(r - i + 2, maxlength);
//        }
//        out.println(maxlength);
//        out.close();
//    }
//
//    public static boolean check(int l, int r) {
//        int s = (int) (Math.log(r - l + 1) / Math.log(2));
//        int a = r - (int) Math.pow(2, s) + 1;
//        int gcdL = f[s][l];
//        int gcdR = f[s][a];
//        int gcd = gcd(gcdR, gcdL);
//        return gcd > 1;
//    }
//
//    public static int gcd(int a, int b) {
//        return b == 0 ? a : gcd(b, a % b);
//    }
//
//
//}
//
//class QReader {
//    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//    private StringTokenizer tokenizer = new StringTokenizer("");
//
//    private String innerNextLine() {
//        try {
//            return reader.readLine();
//        } catch (IOException e) {
//            return null;
//        }
//    }
//
//    public boolean hasNext() {
//        while (!tokenizer.hasMoreTokens()) {
//            String nextLine = innerNextLine();
//            if (nextLine == null) {
//                return false;
//            }
//            tokenizer = new StringTokenizer(nextLine);
//        }
//        return true;
//    }
//
//    public String nextLine() {
//        tokenizer = new StringTokenizer("");
//        return innerNextLine();
//    }
//
//    public String next() {
//        hasNext();
//        return tokenizer.nextToken();
//    }
//
//    public int nextInt() {
//        return Integer.parseInt(next());
//    }
//
//    public long nextLong() {
//        return Long.parseLong(next());
//    }
//}
//
//class QWriter implements Closeable {
//    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//
//    public void print(Object object) {
//        try {
//            writer.write(object.toString());
//        } catch (IOException e) {
//            return;
//        }
//    }
//
//    public void println(Object object) {
//        try {
//            writer.write(object.toString());
//            writer.write("\n");
//        } catch (IOException e) {
//            return;
//        }
//    }
//
//    @Override
//    public void close() {
//        try {
//            writer.close();
//        } catch (IOException e) {
//            return;
//        }
//    }
//}
