package javaintro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dawei on 10/11/2016.
 */
public class ExtractTag {

    public static void extractTag(String s) {
        Pattern p = Pattern.compile("<(.+?)>([^<>]+)</\\1>");
        Matcher m = p.matcher(s);
        boolean found = false;
        while (m.find()) {
            found = true;
            System.out.println(m.group(2));
        }
        if (!found)
            System.out.println("None");
    }

    public static void main(String[] args) {
        String s = "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>";
        extractTag(s);
    }
}
