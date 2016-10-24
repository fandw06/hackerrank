package datastructure.maxmin;

import java.util.*;

/**
 * Created by Dawei on 10/18/2016.
 */
public class MaxMinQueue {

    public static int minMax(int a[], int d) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i< d; i++) {
            if (a[i] > max)
                max = a[i];
            queue.add(a[i]);
        }
        for (int i = d; i<a.length; i++) {
            queue.remove();
            queue.add(a[i]);
            min = Math.min(min, Collections.max(queue));
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("./testcase/truck1.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        */
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int a[] = new int[n];
        for (int i = 0; i< n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i<q; i++) {
            System.out.println(minMax(a, scanner.nextInt()));
        }
    }
}
