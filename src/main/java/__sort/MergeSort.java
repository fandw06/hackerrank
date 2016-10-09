package __sort;

import java.util.Arrays;

/**
 * Created by Dawei on 10/7/2016.
 */
public class MergeSort {

    public static void mergeSort(int a[]) {
        sort(a, 0, a.length);
    }

    public static void sort(int a[], int begin, int end) {
        if (end <= begin + 1)
            return;
        sort(a, begin, (begin + end)/2);
        sort(a, (begin + end)/2, end);
        merge(a, begin, (begin + end)/2, end);
    }

    public static void merge(int a[], int begin, int middle, int end) {
        int ps = 0, p1 = begin, p2 = middle;
        int sorted[] = new int[end - begin];
        for (;ps < end-begin; ps++) {
            if (p2 >= end || (p1 < middle && p2 < end && a[p1] < a[p2])) {
                sorted[ps] = a[p1++];
            }
            else
                sorted[ps] = a[p2++];
        }
        for (int i = begin; i<end; i++) {
            a[i] = sorted[i - begin];
        }
    }

    public static void main(String[] args) {
        int array[] = {3, 6, 9, 1, 5, 8, 0};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
