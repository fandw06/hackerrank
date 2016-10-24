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
public class DynamicBig2 {
    public static int[] getDistance(int n, BigInteger k) {
        if (n%2 == 0){
            if (k.compareTo(BigInteger.valueOf(2)) > 0)
                return new int[]{-1};
            if (k.equals(BigInteger.ONE)) {
                int curr[] = new int[n];
                for (int i = 0; i<n; i += 2) {
                    curr[i] = n/2 - i/2;
                    curr[i+1] = n - i/2;
                }
                return curr;
            }
            if (k.equals(BigInteger.valueOf(2))) {
                int curr[] = new int[n];
                for (int i = 0; i<n; i += 2) {
                    curr[i] = (n + i + 2)/2;
                    curr[i+1] = (i+2)/2;
                }
                return curr;
            }
        }
        // limit : 2^(n-1)(n+5)
        if (k.shiftRight(n-1).compareTo(BigInteger.valueOf(n+5))>0)
            return new int[]{-1};

        int curr[] = new int[n];
        for (int i = 0; i<n; i++) {
            curr[i] = i+1;
        }
        int max = n/2;
        int d = dist(curr);
        if (d == max) {
            System.out.println("ID: " + k + " " + Arrays.toString(curr));
            k = k.subtract(BigInteger.ONE);
            if (k.compareTo(BigInteger.ZERO) == 0) {
                return curr;
            }
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
            if (d == max) {
                System.out.println("ID: " + k + " " + Arrays.toString(curr));
                k = k.subtract(BigInteger.ONE);
                if (k.compareTo(BigInteger.ZERO) == 0) {
                    return curr;
                }
            }

        }
        if (k.compareTo(BigInteger.ZERO) > 0)
            return new int[]{-1};
        return null;
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
            scanner = new Scanner(new File("./testcase/perm5.txt"));
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
