package icecream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Dawei on 10/8/2016.
 */
public class BS {

    public static int[] twoSum(int a[], int m) {
        int sorted[] = Arrays.copyOf(a, a.length);
        Arrays.sort(sorted);
        for (int i = 0; i< sorted.length; i++) {
            int t = Arrays.binarySearch(sorted, m - sorted[i]);
            if (t >= 0 && t != i) {
                return index(a, sorted[i], sorted[t]);
            }
        }
        return null;
    }

    public static int[] index(int a[], int v1, int v2) {
        int p1 = -1, p2 = -1;
        for (int i = 0; i< a.length; i++) {
            if ((p1 == -1) &&a[i] == v1) {
                p1 = i;
            }
            else if (a[i] == v2) {
                p2 = i;
            }
            else if (p1 != -1 && p2 != -1) {
                break;
            }
        }
        return new int[]{Math.min(p1, p2) + 1, Math.max(p1, p2) + 1};
    }

    public static void main(String[] args) {
        int a[] = {3, 2, 5, 7, 12};
        int m = 8;
        System.out.println(Arrays.toString(twoSum(a, m)));
    }
}
