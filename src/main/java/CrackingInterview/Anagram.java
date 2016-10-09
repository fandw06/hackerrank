package CrackingInterview;

/**
 * Created by Dawei on 10/6/2016.
 */
public class Anagram {
    public static int numberNeeded(String first, String second) {
        int vol1[] = new int[26];
        int vol2[] = new int[26];

        for (char c : first.toCharArray()) {
            vol1[c - 'a']++;
        }
        for (char c : second.toCharArray()) {
            vol2[c - 'a']++;
        }
        int sum = 0;
        for (int i = 0; i< 26; i++) {
            sum += Math.abs(vol1[i] - vol2[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        String first = "abc";
        String second = "cde";
        System.out.println(numberNeeded(first, second));
    }
}
