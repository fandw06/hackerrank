package javaintro;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Dawei on 10/11/2016.
 */
public class BigDecTest {

    public static void sort(String s[]) {
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return new BigDecimal(o2).compareTo(new BigDecimal(o1));
            }
        });
    }

    public static void sort2(String s[]) {
        Arrays.sort(s, (o1, o2) -> new BigDecimal(o1).compareTo(new BigDecimal(o2)));
    }
    public static void main(String[] args) {
        String s[] = {"-100", "50", "0", "56.6", "90", "0.12", ".12", "02.34", "0000.00"};
        sort(s);
        System.out.println(Arrays.toString(s));
    }
}
