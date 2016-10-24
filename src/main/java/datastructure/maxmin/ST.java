package datastructure.maxmin;

import java.util.Scanner;

/**
 * Created by Dawei on 10/19/2016.
 */
public class ST {

    public static int minMax(int[][] table, int d) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i<=table.length-d; i++) {
            min = Math.min(min, getMax(table, i, i+d-1));
        }
        return min;
    }

    public static int getMax(int m[][], int i, int j) {
        if (i>=0 && i<m.length && j>=0 && j<m.length) {
            int k = (int)(Math.log(j-i+1)/Math.log(2));
            return Math.max(m[i][k], m[j-(1<<k)+1][k]);
        }
        return -1;
    }

    public static int[][] buildTable(int a[]) {
        int n = a.length;
        int p = (int)(Math.log(n)/Math.log(2));
        int m[][] = new int[n][p+1];
        for (int i = 0; i<n; i++) {
            m[i] = new int[p+1];
            m[i][0] = a[i];
        }
        for (int j = 1; j <= p; j++) {
            for (int i = 0; i + (1<<j) -1 < n; i++) {
                m[i][j] = Math.max(m[i][j-1], m[i+(1<<(j-1))][j-1]);
            }
        }
        return m;
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

        int[][] table = buildTable(a);
        for (int i = 0; i<q; i++) {
            System.out.println(minMax(table, scanner.nextInt()));
        }
    }
}
