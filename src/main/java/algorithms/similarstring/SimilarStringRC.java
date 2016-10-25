package algorithms.similarstring;

import java.util.Scanner;

/**
 * Created by Dawei on 10/24/2016.
 */
public class SimilarStringRC {

    public static int ss(char[] str, int l, int r) {
        if (l == r)
            return str.length;

        int num = 0;
        for (int i = 0; i<str.length-(r-l); i++) {
            // [i, i + r-l] <-> [l, r]
            if (isSimilar(str, i, i+r-l, l, r))
                num++;
        }
        return num;
    }

    public static boolean isSimilar(char str[], int i, int j, int l, int r) {

        if (j == i)
            return true;
        boolean succ = isSimilar(str, i, j-1, l, r-1);
        if (!succ)
            return false;
        for (int k = 0; k<r-l+1;k++) {
            if (!((str[i+k] == str[j] && str[l+k] == str[r]) || (str[i+k] != str[j] && str[l+k] != str[r]))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        char[] str = scanner.next().toCharArray();
        for (int i = 0; i< q; i++) {
            System.out.println(ss(str, scanner.nextInt()-1, scanner.nextInt()-1));
        }

    }
}
