package javaintro;

/**
 * Created by Dawei on 10/11/2016.
 */
public class NegSum {

    public static int negSum(int a[]) {
        return rec(a, 0);
    }

    public static int rec(int a[], int begin) {
        if (begin == a.length - 1) {
            if (a[begin] < 0)
                return 1;
            return 0;
        }
        if (begin > a.length - 1)
            return 0;
        int res = 0;
        int sum = 0;
        for (int i = begin; i< a.length; i++) {
            sum += a[i];
            if (sum < 0)
                res++;
        }
        return res + rec(a, begin + 1);
    }

    public static int neg(int a[]) {
        int last = 0;
        for (int i = a.length - 1; i >=0; i--) {
            int sum = 0;
            for (int j = i; j<a.length; j++) {
                sum += a[j];
                if (sum < 0)
                    last++;
            }
        }
        return last;
    }
    public static void main(String[] args) {
        int a[] = {1, -2, -3};
        int n = neg(a);
        System.out.println(n);
    }
}
