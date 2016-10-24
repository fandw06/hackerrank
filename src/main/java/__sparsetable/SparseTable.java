package __sparsetable;

import java.util.Arrays;

/**
 * Created by Dawei on 10/19/2016.
 */
public class SparseTable {


    public static int[][] buildST(int a[]) {
        int n = a.length;
        int p = (int)(Math.log(n)/Math.log(2));
        int m[][] = new int[n][p+1];
        for (int i = 0; i<n; i++) {
            m[i] = new int[p+1];
            m[i][0] = a[i];
        }
        for (int j = 1; j <= p; j++) {
            for (int i = 0; i + (1<<j) -1 < n; i++) {
                m[i][j] = Math.min(m[i][j-1], m[i+(1<<(j-1))][j-1]);
            }
        }
        return m;
    }

    public static int getMin(int m[][], int i, int j) {
        if (i>=0 && i<m.length && j>=0 && j<m.length) {
            int k = (int)(Math.log(j-i+1)/Math.log(2));
            return Math.min(m[i][k], m[j-(1<<k)+1][k]);
        }

        return -1;
    }

    public static void main(String[] args) {
        int a[] = {2, 8, 5, 4, 3, 9, 3, 23, 67, 1, 789, 3, 45, 67, 9, 23};
    //    int a[] = {3, 2, 4, 1, 5};
        int m[][] = buildST(a);
        for (int i = 0; i< m.length; i++)
            System.out.println(Arrays.toString(m[i]));
        System.out.println(getMin(m, 0, 4));
        System.out.println(getMin(m, 1, 2));
        System.out.println(getMin(m, 1, 3));
        System.out.println(getMin(m, 2, 4));
        System.out.println(getMin(m, 4, 4));
    }
}
