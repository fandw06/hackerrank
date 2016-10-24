package datastructure.permutation;

import java.math.BigInteger;

/**
 * Created by Dawei on 10/21/2016.
 */
public class Limit {

    public static boolean valid(BigInteger k, int n) {
        if (n == 1 && k.compareTo(BigInteger.ONE) > 0)
            return false;
        int nn = (n-1)/2;
        BigInteger limit = BigInteger.valueOf(nn+5).multiply(BigInteger.ONE.shiftLeft(nn-1));
        System.out.println(limit);
        return k.compareTo(limit) <= 0;
    }

    public static void main(String[] args) {
        System.out.println(valid(new BigInteger("628611547525677890"), 17));
    }
}
