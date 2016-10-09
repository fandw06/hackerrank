package CrackingInterview;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dawei on 10/6/2016.
 */
public class RansomNote {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;

    public RansomNote(String magazine, String note) {
        magazineMap = new HashMap<>();
        noteMap = new HashMap<>();

        String wordsM[] = magazine.split(" ");
        String wordsN[] = note.split(" ");
        for (String w : wordsM) {
            if (magazineMap.containsKey(w)) {
                int original = magazineMap.get(w);
                magazineMap.put(w, original + 1);
            }
            else
                magazineMap.put(w, 1);
        }
        for (String w : wordsN) {
            if (noteMap.containsKey(w)) {
                int original = noteMap.get(w);
                noteMap.put(w, original + 1);
            }
            else
                noteMap.put(w, 1);
        }
    }

    public boolean solve() {
        for (Map.Entry<String, Integer> e : noteMap.entrySet()) {
            if (!magazineMap.containsKey(e.getKey()) || (magazineMap.get(e.getKey()) < e.getValue())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
