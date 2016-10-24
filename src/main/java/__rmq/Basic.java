package __rmq;

import java.util.Arrays;

/**
 * Created by Dawei on 10/19/2016.
 */
public class Basic {

    public static int[][] buildTable(int a[]) {
        int n = a.length;
        int m[][] = new int[n][n];
        for (int i = 0; i<n; i++) {
            m[i] = new int[n];
            m[i][i] = a[i];
        }
        for (int i = 0; i< n; i++) {
            for (int j = i+1; j<n; j++) {
                m[i][j] = Math.min(m[i][j-1], a[j]);
            }
        }
        return m;
    }

    public static int getMin(int m[][], int i, int j) {
        if (i>=0 && i<m.length && j>=0 && j<m.length)
            return m[i][j];
        return -1;
    }

    public static void main(String[] args) {
     //   int a[] = {2, 8, 5, 4, 3, 9, 0, 23, 67, 1, 789, 3, 45, 67, 9, 23};
        int b[] = {3, 2, 4, 1, 5};
        int m[][] = buildTable(b);
        for (int i = 0; i<m.length; i++)
            System.out.println(Arrays.toString(m[i]));
        System.out.println(getMin(m, 0, 4));
        System.out.println(getMin(m, 1, 2));
        System.out.println(getMin(m, 2, 3));
        System.out.println(getMin(m, 1, 4));
    }
}
