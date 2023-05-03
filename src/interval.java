

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class interval {
  static int[][] nums;

  public static void main(String[] args) {
    QReader in = new QReader();
    int n = in.nextInt();
    if (n == 1) {
      System.out.println(1);
      return;
    }
    int[] num = new int[n];
    for (int i = 0; i < n; i++) {
      num[i] = in.nextInt();
    }
    int log = log(n - 1);
    nums = new int[log + 1][n];
    for (int i = 1; i < n; i++) {
      nums[0][i] = Math.abs(num[i - 1] - num[i]);
    }
    int len = n - 1;
    for (int iii = 1; iii <= log; iii++) {
      int di = (int) (Math.pow(2,iii - 1));
      len -= di;
      for (int i = 1; i <= len; i++) {
        nums[iii][i] = fac(nums[iii - 1][i], nums[iii - 1][i + di]);
      }
    }
    int max = 1;
    for (int i = 1; i < n; i++) {
      int l = i, r = n - 1;
      while (r >= l) {
        int m = l + (r - l) / 2;
        int q = query(i, m);
        if (q == 1) {
          r = m - 1;
        } else {
          l = m + 1;
        }
      }
      max = Math.max(max, l - i + 1);
    }
    System.out.println(max);
  }

  static int query(int l, int r) {
    int s = log(r - l + 1);
    return fac(nums[s][l], nums[s][(int) (r - Math.pow(2, s) + 1)]);
  }

  static int fac(int u, int v) {
    while (v != 0) {
      int tmp = u % v;
      u = v;
      v = tmp;
    }
    return u;
  }

  public static int log(int n) {
    int i = 0;
    while (n >= 2) {
      n /= 2;
      i++;
    }
    return i;
  }
}

class QReader {
  private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  private StringTokenizer tokenizer = new StringTokenizer("");

  private String innerNextLine() {
    try {
      return reader.readLine();
    } catch (IOException e) {
      return null;
    }
  }

  public boolean hasNext() {
    while (!tokenizer.hasMoreTokens()) {
      String nextLine = innerNextLine();
      if (nextLine == null) {
        return false;
      }
      tokenizer = new StringTokenizer(nextLine);
    }
    return true;
  }

  public String nextLine() {
    tokenizer = new StringTokenizer("");
    return innerNextLine();
  }

  public String next() {
    hasNext();
    return tokenizer.nextToken();
  }

  public int nextInt() {
    return Integer.parseInt(next());
  }

  public long nextLong() {
    return Long.parseLong(next());
  }
}