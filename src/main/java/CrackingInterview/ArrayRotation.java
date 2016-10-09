package CrackingInterview;

import java.util.Arrays;

/**
 * Created by Dawei on 10/6/2016.
 */
public class ArrayRotation {
    public static int[] arrayLeftRotation(int[] a, int n, int k) {
        if (n <= 1)
            return a;
        k = k%n;
        if (k == 0)
            return a;

        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            int index = i - k;
            if (index < 0)
                index += n;
            res[index] = a[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5};
        int p = 4;
        System.out.println(Arrays.toString(arrayLeftRotation(a, 5, 4)));
    }
}
