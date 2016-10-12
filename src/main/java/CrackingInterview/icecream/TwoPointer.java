package CrackingInterview.icecream;

import java.util.Arrays;

/**
 * Created by Dawei on 10/7/2016.
 */
public class TwoPointer {

    public static int[] twoSum(int a[], int m) {

        int sorted[] = Arrays.copyOf(a, a.length);
        Arrays.sort(sorted);
        for (int p1 = 0, p2 = a.length -1; p1 < p2;) {
            if (sorted[p1] + sorted[p2] == m) {
                return index(a, sorted[p1], sorted[p2]);
            }
            else if (sorted[p1] + sorted[p2] < m)
                p1++;
            else
                p2--;
        }
        return null;
    }

    public static int[] index(int a[], int v1, int v2) {
        int p1 = -1, p2 = -1;
        for (int i = 0; i< a.length; i++) {
            if ((p1 != -1) &&a[i] == v1) {
                p1 = i;
            }
            else if (a[i] == v2) {
                p2 = i;
            }
            else if (p1 != -1 && p2 != -1) {
                break;
            }
        }
        return new int[]{Math.min(p1, p2), Math.max(p1, p2)};
    }

    public static void main(String[] args) {
        int a[] = {3, 2, 5, 7, 12};
        int m = 8;
        System.out.println(Arrays.toString(twoSum(a, m)));
    }

}
