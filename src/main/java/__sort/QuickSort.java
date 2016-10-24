package __sort;

import java.util.Arrays;

/**
 * Created by Dawei on 10/14/2016.
 */
public class QuickSort {

    public static void sort(int a[]) {
        sort(a, 0, a.length);
    }
    public static void sort(int a[], int b, int e) {
        int pivot = a[b];

    }
    public static void main(String[] args) {
        int a[] = {4, 6, 9, 12, 5, 2, 0, 1, 3, 99, 7};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
