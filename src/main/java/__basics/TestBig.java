package __basics;

import java.math.BigInteger;

/**
 * Created by Dawei on 10/22/2016.
 */
public class TestBig {

    public static void testBig() {
     //   BigInteger i = new BigInteger("846904072800239086");
        BigInteger i = new BigInteger("100000000");
        int idle = 78932;
        while (i.compareTo(BigInteger.ZERO) > 0) {
            idle = (int)(idle *Math.sqrt(idle) * Math.PI) % 655360;
            i = i.subtract(BigInteger.ONE);
        }
    }

    public static void testLong() {
        //   BigInteger i = new BigInteger("846904072800239086");
        long i = 84690407L;
        int idle = 78932;
        while (i > 0) {
            idle = (int)(idle *Math.sqrt(idle) * Math.PI) % 655360;
            i--;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        testBig();
     //   testLong();
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (double)(end-start)/1000.0);
        System.out.println(Math.pow(8, 9)*38.0/24.0/3600.0/365.0);
    }
}
