package CrackingInterview;

/**
 * Created by Dawei on 10/8/2016.
 */
public class LonelyNumber {

    public static int xor(int a[]) {
        int res = 0;
        for (int i : a)
            res ^=i;
        return res;
    }
}
