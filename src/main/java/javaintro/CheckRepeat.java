package javaintro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dawei on 10/11/2016.
 */
public class CheckRepeat {
    public static String checkRepeat(String s) {
        String sp = "\\b(\\w+)(\\s+\\1\\b)*";
        Pattern p = Pattern.compile(sp);
        Matcher m = p.matcher(s);
        while (m.find()) {
            s = s.replace(m.group(), m.group(1));
        }
        return s;
    }

    public static void main(String[] args) {
        String s = "Rana is is the the best player in eye eye game";
        String sc = checkRepeat(s);
        System.out.println(sc);
    }
}
