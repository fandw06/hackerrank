package __permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dawei on 10/24/2016.
 */
public class NumberPer {

    public static List<List<Integer>> getPermutation(int n) {
        List<List<Integer>> last = new ArrayList<>();
        List<List<Integer>> curr = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        one.add(1);
        last.add(one);
        for (int i = 2; i <= n; i++) {
            curr = new ArrayList<>();
            for (int k = 0; k<last.size(); k++) {
                ArrayList<Integer> l = new ArrayList<>(last.get(k));
                for (int j = 0; j <= l.size(); j++) {
                    ArrayList<Integer> nl = new ArrayList<>(l);
                    nl.add(j, i);
                    curr.add(nl);
                }
            }
            last = curr;
        }
        return curr;
    }

    public static void main(String[] args) {
        int n = 3;
        List<List<Integer>> list = getPermutation(n);
        for (List<Integer> l : list)
            System.out.println(l);
    }
}
