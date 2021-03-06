package datastructure.permutation;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Dawei on 10/20/2016.
 */
public class DynamicBig {
    public static int[] getDistance(int n, BigInteger k) {
        List<int[]> m = new ArrayList<>();
        int curr[] = new int[n];
        for (int i = 0; i<n; i++) {
            curr[i] = i+1;
        }
        int max = -1;
        int d = dist(curr);
        if (d > max) {
            m.clear();
            m.add(Arrays.copyOf(curr, curr.length));
            max = d;
        }
        else if (d == max) {
            m.add(Arrays.copyOf(curr, curr.length));
        }
        while (true) {
            int first = 0;
            int second = -1;
            for (int i = n-2; i>=0; i--) {
                if (curr[i] < curr[i+1]) {
                    first = i;
                    break;
                }
            }
            int min = Integer.MAX_VALUE;
            for (int i = first + 1; i<n; i++) {
                if (curr[i] > curr[first] && curr[i] < min) {
                    second = i;
                    min = curr[i];
                }
            }
            if (second == -1)
                break;

            int temp = curr[first];
            curr[first] = curr[second];
            curr[second] = temp;
            Arrays.sort(curr, first+1, curr.length);

            //process distance
            d = dist(curr);
            if (d > max) {
                m.clear();
                m.add(Arrays.copyOf(curr, curr.length));
                max = d;
            }
            else if (d == max) {
                m.add(Arrays.copyOf(curr, curr.length));
            }
        }
        if (k.subtract(BigInteger.valueOf(m.size())).compareTo(BigInteger.ZERO) > 0)
            return new int[]{-1};
        return m.get(k.subtract(BigInteger.ONE).intValue());
    }

    public static int dist(int a[]) {
        if (a.length == 1)
            return 0;
        int min = a.length;
        for (int i = 1; i< a.length; i++)
            min = Math.min(min, Math.abs(a[i] - a[i-1]));
        return min;
    }

    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
        /*
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("./testcase/perm4.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        */
        int q = scanner.nextInt();
        for (int i = 0; i<q; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int res[] = getDistance(n, BigInteger.valueOf(k));
            if (res[0] == -1)
                System.out.println(-1);
            else {
                for (int j = 0; j<res.length; j++)
                    System.out.print(res[j] + " ");
                System.out.println();
            }
        }
    }
}
