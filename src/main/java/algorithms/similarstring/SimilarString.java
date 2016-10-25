package algorithms.similarstring;

import java.util.Scanner;

/**
 * Created by Dawei on 10/24/2016.
 */
public class SimilarString {

    public static int ss(char[] str, int l, int r) {
        if (l == r)
            return str.length;

        int num = 0;
        for (int i = 0; i<str.length-(r-l); i++) {
            // [i, i + r-l] <-> [l, r]
            if (isSimilar(str, i, l, r))
                num++;
        }
        return num;
    }

    public static boolean isSimilar(char str[], int i, int l, int r) {

        for (int j = i; j<i+r-l; j++) {
            for (int k = j+1; k<=i+r-l; k++) {
                if (!((str[j] == str[k] && str[j+l-i] == str[k+l-i]) || (str[j] != str[k] && str[j+l-i] != str[k+l-i]))) {
                    return false;
                }
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
