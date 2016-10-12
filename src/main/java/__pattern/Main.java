package __pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dawei on 10/11/2016.
 */
public class Main {
    public static boolean checkIP(String ip) {

        String zeroTo255 = "(\\d{1,2}|[0-1]\\d{2}|2[0-4]\\d|25[0-5])";
        //     String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
        String pattern = zeroTo255 + "." + zeroTo255 + "." +zeroTo255 + "." +zeroTo255;
        return ip.matches(pattern);
    }

    public static void testReference() {

    }

    /**
     * Difference between reluctant, greedy and possesive:
     * http://stackoverflow.com/questions/5319840/greedy-vs-reluctant-vs-possessive-quantifiers
     *
     */
    public static void testMatch() {
        String s = "xfooxxxxxfoo";
        // Default is greedy.
        Pattern p1 = Pattern.compile("(.*foo)");
        Matcher m1 = p1.matcher(s);
        System.out.println("Greedy:");
        while (m1.find()) {
            System.out.println("Found! started at " + m1.start() + " and end at " + m1.end());
        }

        // reluctant.
        Pattern p2 = Pattern.compile(".*?foo");
        Matcher m2 = p2.matcher(s);
        System.out.println("Reluctant:");
        while (m2.find()) {
            System.out.println("Found! started at " + m2.start() + " and end at " + m2.end());
        }

        //possessive
        Pattern p3 = Pattern.compile(".*+foo");
        Matcher m3 = p3.matcher(s);
        System.out.println("Possessive:");
        while (m3.find()) {
            System.out.println("Found! started at " + m3.start() + " and end at " + m3.end());
        }
    }

    public static void testBoundary() {
        String s1 = "This is a boundary test";
        String s2 = "test no-parameter - buasd-.";

        //\b并不是空格，而是一个0宽度的、夹在字符与非字符之间的位置。\B则是两侧都是字符或者都不是字符。
        Pattern p = Pattern.compile("(\\bis\\b)");
        Matcher m = p.matcher(s1);
        while(m.find()) {
            System.out.println(m.group(0));
            System.out.println(s1.replace(m.group(0), "#"));
        }
    }

    public static void main(String []args) {

//        String s = "000.12.12.034";
 //       System.out.println(checkIP(s));
 //       testBoundary();
        testMatch();

    }
}
