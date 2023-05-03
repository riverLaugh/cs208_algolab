import java.util.Random;

public class test {
    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 100; j++) {
                System.out.print(r.nextInt(100)+" ");
            }
            System.out.println();
        }
    }

}
