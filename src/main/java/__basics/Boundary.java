package __basics;

/**
 * Created by Dawei on 10/20/2016.
 */
public class Boundary {

    public static void main(String[] args) {
        long d = (long)((long)Integer.MIN_VALUE + (long)Integer.MIN_VALUE);
        System.out.println(d);

        int a = Integer.MAX_VALUE;
        int b = Integer.MIN_VALUE+1;
        System.out.println(a-b);
    }
}
