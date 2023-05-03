import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        node[] nodes = new node[n];
        for (int t = 0; t < n; t++) {
            int l = input.nextInt();
            nodes[t] = new node(l, input.nextInt(), input.nextInt());
        }
        nodes = mergesortL(nodes, 0, n - 1);
        int[] time = new int[n];//时隙对应的原始坐标
        int t = 0;//当前分配的下标
        int num = 1;
        while (t < n) {
            if (t == 0) {
                num = nodes[t].l;
                time[t] = num;
                t++;
            }
            while (t < n && nodes[t].l == num) {
                time[t] = Math.max(time[t - 1] + 1, num);
                t++;
            }
            if (t < n) {
                num = nodes[t].l;
            }
        }
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            if (nodes[i].l == time[j]) {
                nodes[i++].index = j;
                continue;
            }
            j++;
        }
        nodes = mergesortP(nodes, 0, n - 1);
        for (int x = 0; x < n; x++) {
            nodes[x].distance = x;
        }
        int[] after = new int[n];//存分配的节点
        for (int x = 0; x < n; x++) {
            after[x] = -1;
        }
        long result = 0;
        for (int x = 0; x < n; x++) {
            if (linear(nodes, nodes[x], after, time, nodes[x].index)) {
                result += nodes[x].v;
            }
        }
        System.out.println(result);
    }

    //time 时隙对应原始坐标
    //after 分配节点
    //place 当前想分配的时隙下标
    static boolean linear(node[] nodes, node current, int[] after, int[] time, int place) {
        if (place >= time.length || time[place] > current.r) {
            return false;
        }
        if (after[place] == -1) {
            after[place] = current.distance;
            return true;
        }
        node change = nodes[after[place]];
        if (current.r > change.r) {
            return linear(nodes, current, after, time, place + 1);
        } else {
            if (linear(nodes, change, after, time, place + 1)) {
                after[place] = current.distance;
                return true;
            }
        }
        return false;
    }

    static node[] mergesortL(node[] a, int left, int right) {
        if (left == right) {
            return new node[]{a[left]};
        }
        int mid = (left + right) / 2;
        node[] leftNode = mergesortL(a, left, mid);
        node[] rightNode = mergesortL(a, mid + 1, right);
        int leftLength = leftNode.length;
        int rightLength = rightNode.length;
        node[] newNode = new node[leftLength + rightLength];
        int i = 0, j = 0, x = 0;
        while (i < leftLength && j < rightLength) {
            if (leftNode[i].l < rightNode[j].l) {
                newNode[x++] = leftNode[i++];
            } else {
                newNode[x++] = rightNode[j++];
            }
        }
        while (i < leftLength) {
            newNode[x++] = leftNode[i++];
        }
        while (j < rightLength) {
            newNode[x++] = rightNode[j++];
        }
        return newNode;
    }

    static node[] mergesortP(node[] a, int left, int right) {
        if (left == right) {
            return new node[]{a[left]};
        }
        int mid = (left + right) / 2;
        node[] leftNode = mergesortP(a, left, mid);
        node[] rightNode = mergesortP(a, mid + 1, right);
        int leftLength = leftNode.length;
        int rightLength = rightNode.length;
        node[] newNode = new node[leftLength + rightLength];
        int i = 0, j = 0, x = 0;
        while (i < leftLength && j < rightLength) {
            if (leftNode[i].v > rightNode[j].v) {
                newNode[x++] = leftNode[i++];
            } else {
                newNode[x++] = rightNode[j++];
            }
        }
        while (i < leftLength) {
            newNode[x++] = leftNode[i++];
        }
        while (j < rightLength) {
            newNode[x++] = rightNode[j++];
        }
        return newNode;
    }
}

class node {
    int l;
    int r;
    int v;
    int distance;
    int index;

    public node(int l, int r, int v) {
        this.l = l;
        this.r = r;
        this.v = v;
    }
}
