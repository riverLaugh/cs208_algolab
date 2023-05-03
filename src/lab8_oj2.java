import java.util.Arrays;
import java.util.Scanner;

public class lab8_oj2 {
    static int[] arr;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
//        for (int z = 0; z < 10000; z++) {
//            int n = 100;
        arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            sum += arr[i];
        }
        int bd = getMedian(0, n - 1);
        recur(0, n - 1, bd);
        System.out.println((-1) + " " + (-1));
//            for (int i = 0; i < n; i++) {
//                System.out.print(arr[i] + " ");
//            }
//            System.out.println(isSorted());
        System.out.println();
//        }
    }

    public static boolean isSorted() {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void recur(int l, int r, int bd) {
        if (r <= l) {
            return;
        }
        int bound = merge(l, r, bd);
        if (l + bound - 1 >= r) {
            return;
        }
        int r1 = l + bound - 1;
        int l1 = l + bound;
        int lmid = (getMedian(l, r1) + getmin(l, r1)) / 2;
        int rmid = (getMedian(l1, r) + getmin(l1, r)) / 2;
        recur(l, r1, lmid);
        recur(l1, r, rmid);
    }


    public static int merge(int l, int r, int bd) {
        int mid = (l + r) / 2;
        if (r == l) {
            if (bd < arr[r]) {
                return 0;
            } else {
                return 1;
            }
        }
        int lbd = merge(l, mid, bd);
        int rbd = merge(mid + 1, r, bd);
        int a = l + lbd;
        int b = mid + rbd;
        if (a <= mid && rbd > 0) {
            reverse(l + lbd, mid + rbd);
            System.out.println((l + lbd + 1) + " " + (mid + rbd + 1));
        }
        bd = lbd + rbd;
        return bd;
    }

    public static int getmin(int l, int r) {
        int min = 100000;
        for (int i = l; i <= r; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int getMedian(int l, int r) {
        if (r <= l) {
            return arr[l];
        }
        int[] temp = Arrays.copyOfRange(arr, l, r + 1);
        Arrays.sort(temp); // 数组排序
        int n = temp.length;
        if (n % 2 == 0) {
            // 数组长度为偶数，取中间两个元素的平均值
            return (int) ((temp[n / 2] + temp[n / 2 - 1]) / 2);
        } else {
            // 数组长度为奇数，直接返回中间的元素
            return temp[n / 2];
        }
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
