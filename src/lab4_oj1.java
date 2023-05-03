//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class lab4_oj1 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String str = in.next();
//        int n = in.nextInt();
//        String[] pats = new String[n];
//        for (int i = 0; i < n; i++) {
//            pats[i] = in.next();
//        }
//        ArrayList<ltr> ltrlist = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            ArrayList<Integer> sublists = new ArrayList<>();
//            sublists = KMP(str, pats[i]);
//            for (int j = 0; j < sublists.size(); j++) {
//                ltr a = new ltr();
//                a.st_point = sublists.get(j);
//                a.tr_point = a.st_point + pats[i].length() - 1;
//                ltrlist.add(a);
//            }
//        }
//        ltr[] ltrs = new ltr[ltrlist.size()];
//        for (int i = 0; i < ltrs.length; i++) {
//            ltrs[i] = ltrlist.get(i);
//        }
//        System.out.println(point(ltrs));
//    }
//
//    public static int point(ltr[] ltrs) {
//        mergeSort(ltrs);
//        int p = -1;
//        int count = 0;
//        for (int i = 0; i < ltrs.length; i++) {
//            if (ltrs[i].st_point > p) {
//                count++;
//                p = ltrs[i].tr_point;
//            }
//        }
//        return count;
//    }
//
//    public static ArrayList<Integer> KMP(String str, String ps) {
//        ArrayList<Integer> a = new ArrayList<>();
//        char[] charstr = str.toCharArray();
//        char[] p = ps.toCharArray();
//        int i = 0;
//        int j = 0;
//        int[] next = getNext(ps);
//        while (i < charstr.length) {
//            if (j == -1 || charstr[i] == p[j]) {
//                i++;
//                j++;
//            } else {
//                j = next[j];
//            }
//            if (j == p.length) {
//                a.add(i - j);
//                i--;
//                j = next[next.length-1];
//            }
//        }
//        return a;
//    }
//
//    public static int[] getNext(String ps) {
//        char[] p = ps.toCharArray();
//        int[] next = new int[p.length];
//        next[0] = -1;
//        int j = 0;
//        int k = -1;
//        while (j < p.length - 1) {
//            if (k == -1 || p[j] == p[k]) {
//                next[++j] = ++k;
//            } else {
//                k = next[k];
//            }
//        }
//        return next;
//    }
//
//    public static void mergeSort(ltr[] arr) {
//        ltr[] temp = new ltr[arr.length];
//        mergeSort(arr, temp, 0, arr.length - 1);
//    }
//
//    public static void mergeSort(ltr[] arr, ltr[] temp, int low, int high) {
//        if (low < high) {
//            int mid = (low + high) / 2;
//            mergeSort(arr, temp, low, mid);
//            mergeSort(arr, temp, mid + 1, high);
//            merge(arr, temp, low, mid, high);
//        }
//    }
//
//    public static void merge(ltr[] arr, ltr[] temp, int low, int mid, int high) {
//        int i = low;
//        int j = mid + 1;
//        int t = low;
//        while (i <= mid && j <= high) {
//            if (arr[i].tr_point <= arr[j].tr_point) {
//                temp[t++] = arr[i++];
//            } else {
//                temp[t++] = arr[j++];
//            }
//        }
//        while (i <= mid) {
//            temp[t++] = arr[i++];
//        }
//        while (j <= high) {
//            temp[t++] = arr[j++];
//        }
//        System.arraycopy(temp, low, arr, low, high - low + 1);
//    }
//}
//
//class ltr {
//    int st_point;
//    int tr_point;
//}