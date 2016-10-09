package CrackingInterview;

/**
 * Created by Dawei on 10/7/2016.
 */
public class MergeSort {

    public static long mergeSort(int a[]) {
        return sort(a, 0, a.length);
    }

    public static long sort(int a[], int begin, int end) {
        if (end <= begin + 1)
            return 0;
        long sum = 0;
        sum += sort(a, begin, (begin + end)/2);
        sum += sort(a, (begin + end)/2, end);
        sum += merge(a, begin, (begin + end)/2, end);
        return sum;
    }

    public static long merge(int a[], int begin, int middle, int end) {
        int ps = 0, p1 = begin, p2 = middle;
        long inversions = 0;
        int sorted[] = new int[end - begin];
        for (;ps < end-begin; ps++) {
            if (p2 >= end || (p1 < middle && p2 < end && a[p1] <= a[p2])) {
                sorted[ps] = a[p1++];
            }
            else{
                if (p1 < middle) {
                    inversions += (middle - p1);
                }
                sorted[ps] = a[p2++];
            }
        }
        for (int i = begin; i<end; i++) {
            a[i] = sorted[i - begin];
        }
        return inversions;
    }

    public static void main(String[] args) {
        int a[] = {5, 4, 3, 2, 1};
        long n = mergeSort(a);
        System.out.println(n);
    }
}
