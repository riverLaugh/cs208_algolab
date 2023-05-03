//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class lab2_oj1 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int rd = sc.nextInt();
//        int cur = sc.nextInt();
//        int qr = sc.nextInt();
//        int[] level = new int[n];
//        node[] arr = new node[n + 1];
//        for (int i = 0; i < n + 1; i++) {
//            arr[i] = new node();
//        }
//        for (int i = 0; i < rd; i++) {
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//            arr[a].child.add(b);
//            arr[b].child.add(a);
//        }
//        int[] query = new int[qr];
//        for (int i = 0; i < qr; i++) {
//            query[i] = sc.nextInt();
//        }
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(cur);
//        arr[cur].level = 0;
//        for (int i = 0; i < n; i++) {
//            level[i]++;
//        }
//        arr[cur].isvisited = true;
//
//        while (!queue.isEmpty()) {
//            int cr = queue.poll();
//            for (int i = 0; i < arr[cr].child.size(); i++) {
//                int child = arr[cr].child.get(i);
//                if (!arr[child].isvisited) {
//                    arr[child].isvisited = true;
//                    arr[child].level = arr[cr].level + 1;
//                    for (int j = arr[child].level ; j < n; j++) {
//                        level[j]++;
//                    }
//                    queue.add(child);
//                }
//            }
//        }
//
//        for (int i = 0; i < qr; i++) {
//            int c = query[i];
//            if(c>=n){
//                System.out.print(level[n-1]+" ");
//            }else{
//                System.out.print(level[c]+" ");
//            }
//        }
//
//    }
//
//    static class node {
//        boolean isvisited = false;
//        int level;
//        ArrayList<Integer> child = new ArrayList<>();
//    }
//}
