package __basics;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by Dawei on 10/15/2016.
 */
public class Function {

    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public String toString() {
            return "x = " + x + ", y = " + y;
        }
    }
    public static void modify(int value, int a[]) {
        value = value * 10;
        a[0] = 908;
    }

    public static void modify(BigInteger b) {
        b = new BigInteger("132451");
    }

    public static void modify(Point p) {
        p = new Point(-1, -1);
      //  p.x = 908771;
    }

    public static void main(String[] args) {
        int v = 100;
        int a[] = {1, 2, 3, 4, 5, 6, 7};
        modify(v, a);
        System.out.println(v);
        System.out.println(Arrays.toString(a));

        BigInteger b = BigInteger.valueOf(1029);
        modify(b);
        System.out.println(b);

        Point p = new Point(1, 7);
        modify(p);
        System.out.println(p);
    }
}
