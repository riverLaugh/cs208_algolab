

import java.util.Random;

public class generation {
  public static void main(String[] args) {
    Random r = new Random();
    int n = r.nextInt(10000) + 1;
    System.out.println(n);
    for (int i = 0; i < n; i++) {
      System.out.print((r.nextInt(1000) + 1)+ " ");
    }
  }
}
