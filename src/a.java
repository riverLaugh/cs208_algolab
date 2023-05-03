import java.util.ArrayList;
import java.util.Scanner;

public class a {
    static ArrayList<timeSlot> active = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        fruit[] arr = new fruit[n];
        fruit[] temp = new fruit[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new fruit();
        }
        for (int i = 0; i < n; i++) {
            arr[i].left = in.nextLong();
            arr[i].right = in.nextLong();
            arr[i].value = in.nextLong();
            temp[i] = new fruit();
        }
        mergesort(arr, 0, n - 1, temp);
        long x = 0;
        for (int i = 0; i < n; i++) {
            x = Math.max(x + 1, arr[i].left);
            timeSlot a = new timeSlot();
            a.isEmpty = true;
            a.activeSlot = x;
            active.add(a);
        }
        for (int i = 0; i < n; i++) {
            temp[i] = new fruit();
        }
        mergesort1(arr, 0, n - 1, temp);
        ArrayList<fruit> re = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (match(arr[i], active.get(i))) {
                re.add(arr[i]);
            }
        }
        long sum = 0;
        for (int i = 0; i < re.size(); i++) {
            sum += re.get(i).value;
        }
        System.out.println(sum);
    }

    public static boolean match(fruit a, timeSlot l) {
        if (l.activeSlot > a.right) return false;
        if (l.isEmpty) {
            l.fruit = a;
            l.isEmpty = false;
            return true;
        }
        fruit b = l.fruit;
        int x = active.indexOf(l);
        if (a.right > b.right) {
            return match(a, active.get(x + 1));
        } else {
            if (match(b, active.get(x + 1))) {
                active.get(x + 1).isEmpty = false;
                active.get(x + 1).fruit = a;
                return true;
            }
        }
        return false;
    }

    private static void mergesort(fruit[] a, int left, int right, fruit[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergesort(a, left, mid, temp);
            mergesort(a, mid + 1, right, temp);
            merge(a, left, right, mid, temp);
        }
    }

    private static void merge1(fruit[] a, int left, int right, int mid, fruit[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right) {
            if (a[i].value <= a[j].value) {
                temp[t] = a[i];
                t++;
                i++;
            } else {
                temp[t] = a[j];
                t++;
                j++;
            }
        }
        while (i <= mid) {
            temp[t] = a[i];
            t++;
            i++;
        }
        while (j <= right) {
            temp[t] = a[j];
            t++;
            j++;
        }
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            a[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }

    private static void mergesort1(fruit[] a, int left, int right, fruit[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergesort1(a, left, mid, temp);
            mergesort(a, mid + 1, right, temp);
            merge1(a, left, right, mid, temp);
        }
    }

    private static void merge(fruit[] a, int left, int right, int mid, fruit[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right) {
            if (a[i].left <= a[j].left) {
                temp[t] = a[i];
                t++;
                i++;
            } else {
                temp[t] = a[j];
                t++;
                j++;
            }
        }
        while (i <= mid) {
            temp[t] = a[i];
            t++;
            i++;
        }
        while (j <= right) {
            temp[t] = a[j];
            t++;
            j++;
        }
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            a[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}

class fruit {
    long left;
    long right;
    long value;
}

class timeSlot {
    boolean isEmpty;
    fruit fruit;
    long activeSlot;
}
