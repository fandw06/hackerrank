package javaintro.jumpwin;

/**
 * Created by Dawei on 10/11/2016.
 */
public class JumpGame {

    public static boolean win(int a[], int m) {
        return rec(a, m, 0);
    }

    public static boolean rec(int a[], int m, int curr) {
        if (curr < 0 || a[curr] != 0)
            return false;
        if (curr == a.length - 1 || curr + m >=a.length)
            return true;

        return rec(a, m, curr + 1) || rec(a, m, curr - 1)|| rec(a, m, curr + m);
    }

    public static void main(String[] args) {

    }
}
