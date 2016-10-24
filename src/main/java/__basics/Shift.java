package __basics;

/**
 * Created by Dawei on 10/19/2016.
 */

/**
 * Shift is lower than +-, higher than <>
 */
public class Shift {

    public static void main(String[] args) {
        int i = 1 + 4<<2;
        System.out.println(i);
        int k = 0;
        i = (8<<k);
        System.out.println(i);
    }
}
