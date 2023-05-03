import java.util.Arrays;
import java.util.Scanner;

public class lab8_oj2 {
    static int[] arr;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            sum += arr[i];
        }
        int bd = sum / n;
        merge(0, n - 1, bd);

        System.out.println((-1) + " " + (-1));
        System.out.println();
    }


    public static boolean check(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void merge(int l, int r, int bd) {
        if (r > l) {
            int mid = (l + r) / 2;
            merge(l, mid, bd);
            merge(mid + 1, r, bd);
            mergeMethod(l, r, bd);
        }
    }

    public static void mergeMethod(int l, int r, int bd) {
        int mid = (l + r) / 2;
        int[] left = Arrays.copyOfRange(arr, l, mid);
        int[] right = Arrays.copyOfRange(arr, mid + 1, r);
        int lbd = find(left, bd);
        int rbd = find(right, bd);
        if (rbd >= lbd) {
            int a = l + lbd;
            int b = mid + rbd;
            if (a != b) {
                reverse(a, b);
                a++;
                b++;
                System.out.println(a + " " + b);
            }
        }
    }


    public static int find(int[] array, int target) {
        int l = 0;
        int r = array.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r + 1;
    }

    public static void reverse(int l, int r) {
        int len = (r - l + 1) / 2;
        int temp;
        for (int i = 0; i < len; i++) {
            temp = arr[l + i];
            arr[l + i] = arr[r - i];
            arr[r - i] = temp;
        }
    }
}
