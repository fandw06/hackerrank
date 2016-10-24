package datastructure.andxor;

import java.util.Scanner;

/**
 * Created by Dawei on 10/16/2016.
 */
public class Square {

    public static int xor(int a[]) {
        int max = 0;
        for (int i = 0; i<a.length; i++) {
            for (int j = i+1; j< a.length; j++) {
                if (isLarger(a, i+1, j-1, a[i], a[j])) {
                    max = Math.max(max, a[i] ^ a[j]);
                }
            }
        }
        return max;

    }

    public static boolean isLarger(int a[], int b, int e, int s1, int s2) {
        for (int i = b; i<=e; i++) {
            if (a[i] < s1 || a[i] < s2)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = new int[n];
        for (int i = 0; i< n; i++) {
            a[i] = scanner.nextInt();

        }
        System.out.println(xor(a));
    }
}
