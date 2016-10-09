package CrackingInterview.coins;

import java.util.Arrays;

/**
 * Created by Dawei on 10/8/2016.
 */
public class CoinsDP {

    public static long dpr(int a[], int m, int begin) {
        if (m == 0)
            return 1;
        if (begin >= a.length)
            return 0;
        if (begin == a.length - 1) {
            if (m % a[begin] == 0) return 1;
            return 0;
        }

        long res = 0;
        for (int i = 0; m - i * a[begin] >= 0; i++) {
            if (m - i * a[begin] == 0 || m - i * a[begin] >= a[begin + 1])
                res += dpr(a, m - i * a[begin], begin + 1);
        }
        return res;
    }
    public static long dp(int a[], int m) {
        return dpr(a, m, 0);
    }

    public static void main(String[] args) {
        int a[] = {2, 3};
        int m = 4;
        System.out.println(dp(a, m));
    }
}
