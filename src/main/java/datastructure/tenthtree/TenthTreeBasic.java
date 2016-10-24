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
public class TenthTreeBasic {

    public static List<BigInteger[]> segment(String leftString, String rightString) {

        List<BigInteger[]> list = new ArrayList<>();
        BigInteger left = new BigInteger(leftString);
        BigInteger right = new BigInteger(rightString);

        int level = -1;
        BigInteger steps;
        BigInteger base;
        int lastLevel = -1;
        BigInteger curr = left;
        while (curr.compareTo(right) <= 0) {
            lastLevel = level;
            steps = BigInteger.ZERO;
            level = 0;

            base = BigInteger.ONE;
            while (curr.subtract(BigInteger.ONE).mod(nextBase(base)).compareTo(BigInteger.ZERO) == 0
                    && curr.add(nextBase(base)).subtract(right).subtract(BigInteger.ONE).compareTo(BigInteger.ZERO) <=0 ) {
                level ++;
                base = nextBase(base);
            }

            curr = curr.add(base);
            steps = steps.add(BigInteger.ONE);
            while (curr.add(base).subtract(right).subtract(BigInteger.ONE).compareTo(BigInteger.ZERO) <=0 &&
                    ((curr.subtract(BigInteger.ONE)).mod(nextBase(base)).compareTo(BigInteger.ZERO) != 0  && lastLevel < level || lastLevel > level)) {
                steps = steps.add(BigInteger.ONE);
                curr = curr.add(base);
            }
            list.add(new BigInteger[]{BigInteger.valueOf(level), steps});
        }
        return list;
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
            scanner = new Scanner(new File("./testcase/tenthtree1.txt"));
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
        List<BigInteger[]> list = segment(l, r);
        System.out.println(list.size());
        for (int i = 0; i<list.size(); i++)
            System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
    }
}
