//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Scanner;
//import java.io.*;
//import java.util.StringTokenizer;
//
//public class lab4_oj2 {
//    static fru[] frus;
//    static ArrayList<ts> t;
//    static fru[] fo;
//    static HashMap<Integer, Integer> map = new HashMap<>();
//    public static void main(String[] args) {
//        QReader in = new QReader();
//        QWriter out = new QWriter();
//        int n = in.nextInt();
//        frus = new fru[n + 1];
//        fo = new fru[n + 1];
//        for (int i = 0; i < n + 1; i++) {
//            frus[i] = new fru();
//            frus[i].num = i;
//        }
//        for (int i = 1; i < n + 1; i++) {
//            int a = in.nextInt();
//            int b = in.nextInt();
//            int c = in.nextInt();
//            frus[i].start = a;
//            frus[i].termin = b;
//            frus[i].value = c;
//        }
//        System.arraycopy(frus, 0, fo, 0, frus.length);
//        long sum = 0;
//        t = findAT();
//        mergeSort2(frus);
//        for (int i = 0; i < t.size(); i++) {
//            map.put(t.get(i).slotnum, i);//key是原始坐标，i是在active里面的坐标
//        }
//        for (int i = 1; i < n + 1; i++) {
//            fru a = frus[i];
//            int index = map.get(a.start);
//            if (linearMatch(a, index)) {
//                sum += a.value;
//            }
//        }
//        out.println(sum);
//        out.close();
//    }
//
//    public static ArrayList<ts> findAT() {
//        ArrayList<ts> s = new ArrayList<>();
//        mergeSort1(frus);
//        int x = 0;
//        for (int i = 1; i < frus.length; i++) {
//            x = Math.max(x + 1, frus[i].start);
//            s.add(new ts(x));
//        }
//        return s;
//    }
//
//    public static boolean linearMatch(fru a, int index) {
//        if (index > t.size() - 1) {
//            return false;
//        }
//        ts sl = t.get(index);
//        if (sl.slotnum > a.termin) {
//            return false;
//        }
//        if (!sl.ismatched) {
//            sl.ismatched = true;
//            sl.frunum = a.num;
//            return true;
//        }
//        fru b = fo[sl.frunum];
//        if (a.termin > b.termin) {
//            return linearMatch(a, index + 1);
//        } else {
//            if (linearMatch(b, index + 1)) {
//                sl.ismatched = true;
//                sl.frunum = a.num;
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public static void mergeSort1(fru[] arr) {
//        fru[] temp = new fru[arr.length];
//        mergeSort1(arr, temp, 1, arr.length - 1);
//    }
//
//    public static void mergeSort1(fru[] arr, fru[] temp, int low, int high) {
//        if (low < high) {
//            int mid = (low + high) / 2;
//            mergeSort1(arr, temp, low, mid);
//            mergeSort1(arr, temp, mid + 1, high);
//            merge1(arr, temp, low, mid, high);
//        }
//    }
//
//    public static void merge1(fru[] arr, fru[] temp, int low, int mid, int high) {
//        int i = low;
//        int j = mid + 1;
//        int t = low;
//        while (i <= mid && j <= high) {
//            if (arr[i].start <= arr[j].start) {
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
//
//    public static void mergeSort2(fru[] arr) {
//        fru[] temp = new fru[arr.length];
//        mergeSort2(arr, temp, 1, arr.length - 1);
//    }
//
//    public static void mergeSort2(fru[] arr, fru[] temp, int low, int high) {
//        if (low < high) {
//            int mid = (low + high) / 2;
//            mergeSort2(arr, temp, low, mid);
//            mergeSort2(arr, temp, mid + 1, high);
//            merge2(arr, temp, low, mid, high);
//        }
//    }
//
//    public static void merge2(fru[] arr, fru[] temp, int low, int mid, int high) {
//        int i = low;
//        int j = mid + 1;
//        int t = low;
//        while (i <= mid && j <= high) {
//            if (arr[i].value >= arr[j].value) {
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
//class fru {
//    int num = 0;
//    int start = 0;
//    int termin = 0;
//    int value = 0;
//}
//
//class ts {
//    int slotnum = 0;
//    int frunum = -1;
//    boolean ismatched = false;
//
//    public ts(int i) {
//        this.slotnum = i;
//    }
//}
//
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
//
