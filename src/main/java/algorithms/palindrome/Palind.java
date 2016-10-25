package algorithms.palindrome;

import java.util.Scanner;

/**
 * Created by Dawei on 10/24/2016.
 */
public class Palind {

    public static String pal(String s1, String s2) {
        int dp[][] = new int[s1.length()][s2.length()];
        int max = 0;
        int wmax = 0;
        String res = "";
        int iS2 = 0;
        int iS1 = 0;
        for (int i = 0; i< s2.length(); i++) {
            if (s2.charAt(i) == s1.charAt(s1.length() - 1))
                dp[0][i] = 1;
        }
        for (int i = 0; i< s1.length(); i++) {
            if (s2.charAt(0) == s1.charAt(s1.length() - 1-i))
                dp[i][0] = 1;
        }
        for (int i = 1; i< s2.length(); i++) {
            for (int j = 1; j< s1.length(); j++) {
                if (s1.charAt(s1.length() -1 - j) == s2.charAt(i)) {
                    dp[j][i] = dp[j-1][i-1] + 1;
                    if (dp[j][i] >= max) {
                        max = dp[j][i];
                        iS2 = i;
                        iS1 = j;
                        if (s1.length() -1-iS1 + max < s1.length()) {
                            int cmax = 2 * max + 1;
                            String cs = s1.substring(s1.length() - 1 - iS1, s1.length() - iS1 + max) + s2.substring(iS2 - max + 1, iS2 + 1);
                            if (cmax == wmax) {
                                if (cs.compareTo(res) < 0)
                                    res = cs;
                            }
                            else if (cmax > wmax) {
                                wmax = cmax;
                                res = cs;
                            }
                        }
                        if (iS2 - max + 1 > 0) {
                            int cmax = 2 * max + 1;
                            String cs = s1.substring(s1.length() - 1 - iS1, s1.length() -1 - iS1 + max) + s2.substring(iS2-max, iS2+1);
                            if (cmax == wmax) {
                                if (cs.compareTo(res) < 0)
                                    res = cs;
                            }
                            else if (cmax > wmax) {
                                wmax = cmax;
                                res = cs;
                            }
                        }
                        if (s1.length() -1-iS1 + max >= s1.length() && iS2 - max + 1 <= 0) {
                            int cmax = 2 * max;
                            String cs = s1.substring(s1.length() - 1 - iS1, s1.length() - 1- iS1 + max) + s2.substring(iS2-max+1, iS2+1);
                            if (cmax == wmax) {
                                if (cs.compareTo(res) < 0)
                                    res = cs;
                            }
                            else if (cmax > wmax) {
                                wmax = cmax;
                                res = cs;
                            }
                        }
                    }
                } else {
                    dp[j][i] = 0;
                }
            }
        }
    //    System.out.println(iS1 + " " + iS2);
        // S1:[s1.length-1-j, s1.length-1-j+max)
        // S2:[i-max+1, i+1)
        if (max == 0)
            return "-1";
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        for (int i = 0; i< q; i++) {
            System.out.println(pal(scanner.next(), scanner.next()));
        }
    }
}
