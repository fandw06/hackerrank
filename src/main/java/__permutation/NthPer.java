package __permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dawei on 10/24/2016.
 */
public class NthPer {
    /**
     *
     * @param n nth permutation
     * @param m 1, 2, 3, ..., m
     * @return
     */
    public static int[] getNth(int n, int m) {
        int facto[] = getFact(m-1);
        int res[] = new int[m];
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i<= m; i++)
            list.add(i);
        for (int i = 0; i<m-1; i++) {
            int r = n%facto[i];
            if (r == 0)
                r = facto[i];
            int index = (n-r)/facto[i];
            res[i] = list.get(index);
            list.remove(index);
            n = r;
        }
        res[m-1] = list.get(0);
        return res;
    }


    public static char[] getNth(int n, char[] ls) {
        int m = ls.length;
        int facto[] = getFact(m-1);
        char res[] = new char[m];
        List<Character> list = new ArrayList<>();
        for (int i = 1; i<= m; i++)
            list.add(ls[i-1]);
        for (int i = 0; i<m-1; i++) {
            int r = n%facto[i];
            if (r == 0)
                r = facto[i];
            int index = (n-r)/facto[i];
            res[i] = list.get(index);
            list.remove(index);
            n = r;
        }
        res[m-1] = list.get(0);
        return res;
    }

    public static int[] getNth2(int n, int m) {
        int a[] = new int[m];
        for (int i = 1; i<=m; i++)
            a[i-1] = i;

        for (int i = 1; i<n; i++)
            getNext(a);
        return a;
    }

    public static int[] getNext(int[] curr) {
        int n = curr.length;
        int first = -1;
        for (int i = n-2; i>=0; i--) {
            if (curr[i] < curr[i+1]) {
                first = i;
                break;
            }
        }
        int second = first + 1;
        int min = Integer.MAX_VALUE;
        for (int i = first + 1; i<n; i++) {
            if (curr[i] > curr[first] && curr[i] <min) {
                min = curr[i];
                second = i;
            }
        }
        int temp = curr[first];
        curr[first] = curr[second];
        curr[second] = temp;
        Arrays.sort(curr, first + 1, n);
        return curr;
    }


    public static int[] getFact(int n) {
        int res[] = new int[n];
        res[n-1] = 1;
        for (int i = n-2; i>=0; i--)
            res[i] = res[i+1] * (n-i);
        return res;
    }

    public static void main(String[] args) {
        int n = 93;
        int m = 6;
        char ls[] = {'a', 'b', 'c'};

        int[] nthi = getNth(n, m);
        System.out.println(Arrays.toString(nthi));
        int nthi2[] = getNth2(n, m);
        System.out.println("By next: " + Arrays.toString(nthi2));
        char[] nthc = getNth(5, ls);
        System.out.println(Arrays.toString(nthc));
    }
}
