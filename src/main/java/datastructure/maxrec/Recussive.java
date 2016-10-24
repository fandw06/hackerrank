package datastructure.maxrec;

/**
 * Created by Dawei on 10/13/2016.
 */

/**
 * 这种方法虽然是递归的，但是复杂度是O(n)，因为每次的范围都缩小的，而且总和是N。
 *
 *
 */
public class Recussive {
    public static int[] min(int a[], int b, int e) {
        int v = Integer.MAX_VALUE;
        int index = -1;
        for (int i = b; i <= e; i++) {
            if (a[i] < v) {
                index = i;
                v = a[i];
            }
        }
        return new int[]{index, v};
    }
    public static int mr(int a[], int b, int e) {
        if (e<b)
            return 0;
        int mind[] = min(a, b, e);
        return Math.max((e-b+1)*mind[1], Math.max(mr(a, b, mind[0]-1), mr(a, mind[0]+1, e)));
    }
}
