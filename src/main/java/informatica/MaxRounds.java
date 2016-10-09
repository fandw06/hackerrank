package informatica;

/**
 * Created by Dawei on 10/6/2016.
 */

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dawei on 10/6/2016.
 */
public class MaxRounds {

    static int maxRounds(String s, String t) {

        if (t.length() > s.length() || s.length() == 0)
            return 0;
        Pattern p = Pattern.compile(t);
        Matcher m = p.matcher(s);

        int found = 0;
        int index = 0;
        Set<String> set = new HashSet<>();
        while (m.find(index)) {
            int curr = m.start();
            set.add(s.substring(0, curr) + s.substring(curr + t.length()));
            index = curr + 1;
            found = 1;
        }

        int max = 0;
        for (String n : set)
            max = Math.max(max, maxRounds(n, t));
        return max+found;
    }


    public static void main(String[] args) {
        String s = "abc";
        String t = "ab";
        String s1 = "ababaa";
        String t1 = "aba";
        String s2 = "abababababababababababab";
        String t2 = "ab";
        System.out.println(maxRounds(s2, t2));
    }

}
