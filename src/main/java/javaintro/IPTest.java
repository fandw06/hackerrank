package javaintro;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Dawei on 10/11/2016.
 */
public class IPTest {


    public static boolean checkIP(String ip) {

        //注意，括号是为了“|”操作的优先级，否则是一堆或并列
        String zeroTo255 = "(\\d{1,2}|[0-1]\\d{2}|2[0-4]\\d|25[0-5])";
        //     String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
        String pattern = zeroTo255 + "." + zeroTo255 + "." +zeroTo255 + "." +zeroTo255;
        return ip.matches(pattern);
    }
    public static void main(String []args) {

        String s = "000.12.12.034";
        System.out.println(checkIP(s));

    }
}