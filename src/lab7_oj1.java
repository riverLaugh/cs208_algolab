import java.util.Scanner;

public class lab7_oj1 {
    static int col = 0;
    static long[][] table;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long l = in.nextLong();
        long r = in.nextLong();
        col = (int) (Math.log(n) / Math.log(2));
        long len = (long) Math.pow(2, col + 1);
        table = new long[3][col];
        long a = n;
        long b = len - 1;
        for (int i = 0; i < col; i++) {
            table[2][i] = a % 2;
            a = a / 2;
            table[0][i] = a;
        }
        for (int i = 0; i < col; i++) {
            b = b / 2;
            table[1][i] = b;
        }
        System.out.println(find(r) - find(l - 1));
    }

    public static long find(long index) {
        if (index <= 0) {
            return 0;
        }
        int point = 0;
        long sum = 0;
        for (int i = 0; i < col; i++) {
            if (index > table[1][i]) {
                point = i;
                sum = table[0][point] + table[2][point];
                break;
            } else if (index == table[1][i]) {
                point = i;
                sum = table[0][point];
                break;
            }
        }
        return sum + find(index - table[1][point] - 1);
    }

}
