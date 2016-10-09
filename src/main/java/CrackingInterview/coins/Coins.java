package CrackingInterview.coins;

/**
 * Created by Dawei on 10/8/2016.
 */
public class Coins {

    public static long dp(int a[], int m) {
        long ways[] = new long[m + 1];
        ways[0] = 1;
        for (int aa : a) {
            for (int i = aa; i< m+1; i++) {
                ways[i] += ways[i - aa];
            }
        }
        return ways[m];
    }

    public static void main(String[] args) {
        int a[] = {2, 3};
        int m = 4;
        System.out.println(dp(a, m));
    }
}
