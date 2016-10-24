package __recursion;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dawei on 10/14/2016.
 */
public class Neighbor {

    public static Set<String> neighbor(String s) {
        Set<String> last = new HashSet<>();
        Set<String> curr = new HashSet<>();
        last.add(s);
        for (int i = 0; i< s.length(); i++) {
            curr = new HashSet();
            for (String word : last) {
                for (char c : similar(word.charAt(i))) {
                    curr.add(word.substring(0, i) + c + word.substring(i+1));
                }
            }
            last = curr;
        }
        return curr;
    }

    public static boolean isWord(String s) {
        return true;
    }

    public static Set<Character> similar(char c) {
        Set<Character> set = new HashSet();
        if (c =='h') {
            set.add('g');
            set.add('j');
            return set;
        }
        else if (c == 'd') {
            set.add('s');
            set.add('f');
            return set;
        }
        else if (c == 'f') {
            set.add('d');
            set.add('g');
            set.add('c');
            return set;
        }
        else if (c == 'e') {
            set.add('w');
            set.add('r');
            return set;
        }
        else if (c == 'i') {
            set.add('u');
            set.add('o');
            set.add('k');
            return set;
        }

        return null;
    }
    public static void main(String[] args) {
        String w = "efi";
        Set<String> set = neighbor(w);
        System.out.println(set);
    }
}
