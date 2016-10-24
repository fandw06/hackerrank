package __permutation;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dawei on 10/14/2016.
 */
public class WordsPer {

    public static Set<String> getAllWords(char[] chars) {
        if (chars.length == 0)
            return new HashSet<>();
        if (chars.length == 1) {
            Set<String> set = new HashSet<String>();
            set.add(String.valueOf(chars[0]));
            return set;
        }
        Set<String> prev = new HashSet<>();
        Set<String> curr = new HashSet<>();
        prev.add(String.valueOf(chars[0]));
        for (int i = 1; i< chars.length; i++) {
            curr = new HashSet<>();
            for (String s : prev) {
                char cc = chars[i];
                for (int j = 0; j<= s.length(); j++) {
                    curr.add(s.substring(0, j) + cc + s.substring(j));
                }
            }
            prev = curr;
        }
        return curr;
    }

    public static void main(String[] args) {
        char chars[] = {'a', 'b', 'c', 'd', 'e'};
        System.out.println(getAllWords(chars));
    }
}
