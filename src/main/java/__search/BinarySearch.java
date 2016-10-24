package __search;

/**
 * Created by Dawei on 10/14/2016.
 */
public class BinarySearch {

    public static int search(int a[], int m) {
        if(a.length == 0)
            return -1;
        if (m < a[0] || m>a[a.length - 1])
            return -1;
        int left = 0, right = a.length;
        int middle;
        while (left <=right) {
            middle = (right + left)/2;
            if (a[middle] == m)
                return middle;
            else if (a[middle] > m) {
                right = middle -1;
            }
            else {
                left = middle + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int a[] = {1, 4, 7, 9, 13, 19};
        int m = 8;
        System.out.println(search(a, m));

    }
}
