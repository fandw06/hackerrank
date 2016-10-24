package datastructure.tenthtree;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Dawei on 10/15/2016.
 */

/**
 * Bignumber处理稍微麻烦一些，另外，steps太大不能线性遍历
 */
public class TenthTree2 {

    public static List<BigInteger[]> segment(String leftString, String rightString) {

        List<BigInteger[]> list = new ArrayList<>();
        BigInteger left = new BigInteger(leftString);
        BigInteger right = new BigInteger(rightString);
        BigInteger curr = left;

        while (curr.compareTo(right) <= 0) {
            int level = getLevelBegin(curr, right);
            BigInteger next = getNext(curr, right, level);
            list.add(new BigInteger[]{BigInteger.valueOf(level), next.subtract(curr).divide(getBase(level))});
            curr = next;
        }
        return list;
    }

    public static BigInteger getBase(int level) {
        if (level == 0)
            return BigInteger.ONE;
        BigInteger base = BigInteger.TEN;
        while (level-- > 1)
            base = base.multiply(base);
        return base;
    }

    // begin from 0.
    public static BigInteger getLevelIndex(BigInteger data, int level) {
        BigInteger index = data.subtract(BigInteger.ONE).divide(getBase(level));
        return index;
    }

    public static BigInteger getBegin(int level, BigInteger index) {
        if (level == 0)
            return index.add(BigInteger.ONE);
        BigInteger base = BigInteger.TEN;
        while (level-- > 1)
            base = base.multiply(base);
        return base.multiply(index).add(BigInteger.ONE);
    }

    public static int getLevelBegin(BigInteger data, BigInteger limit) {
        int level = 0;
        BigInteger base = BigInteger.ONE;
        while (data.subtract(BigInteger.ONE).mod(nextBase(base)).compareTo(BigInteger.ZERO) == 0
                && data.add(nextBase(base)).subtract(limit).subtract(BigInteger.ONE).compareTo(BigInteger.ZERO) <=0 ) {
            level ++;
            base = nextBase(base);
        }
        return level;
    }

    public static BigInteger getNext(BigInteger curr, BigInteger limit, int level) {
        BigInteger index = getLevelIndex(curr, level + 1);
        BigInteger next = getBegin(level+1, index.add(BigInteger.ONE));
        if (next.compareTo(limit) <= 0)
            return next;
        else {
            BigInteger ind = getLevelIndex(limit.add(BigInteger.ONE), level);
            return getBegin(level, ind);
        }

    }

    public static BigInteger getEnd(int level, BigInteger index) {
        if (level == 0)
            return index.add(BigInteger.ONE);
        BigInteger base = BigInteger.TEN;
        while (level-- > 1)
            base = base.multiply(base);
        return base.multiply(index.add(BigInteger.ONE));
    }

    public static BigInteger nextBase(BigInteger base) {
        if (base.compareTo(BigInteger.valueOf(1)) == 0)
            return BigInteger.valueOf(10);
        return base.multiply(base);
    }

    public static void main(String[] args) {
    //    Scanner scanner = new Scanner(System.in);
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("./testcase/tenthtree3.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String l = scanner.next();
        String r = scanner.next();
   //     segment(l, r);


     //   segment(42, 1024);
    //    segment("1", "1000");
    //    segment(31, 59);
    //    segment("31", "59");

        /*
        List<BigInteger[]> list = segment(l, r);
        System.out.println(list.size());
        for (int i = 0; i<list.size(); i++)
            System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
        */

        List<BigInteger[]> list = segment("42", "1091");
        for (int i = 0; i<list.size(); i++)
            System.out.println(list.get(i)[0] + " " + list.get(i)[1]);

    //    System.out.println(getLevelIndex(BigInteger.valueOf(42), 1));
        System.out.println(getNext(BigInteger.valueOf(1091), BigInteger.valueOf(1091), 0));
    //    System.out.println(getNext(BigInteger.valueOf(1001), BigInteger.valueOf(1020), 1));

    }
}
