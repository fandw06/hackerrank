package __backtracking.eightqueen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Dawei on 10/24/2016.
 */
public class EightQueen {
    public static List<List<Integer>> sol = new ArrayList<>();

    public static void getQueen(int n) {

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i<=n; i++)
            set.add(i);
        for (int i = 1; i <= n; i++) {
            List<Integer> ps = new ArrayList<>();
            ps.add(i);
            Set<Integer> as = new HashSet<>(set);
            as.remove(i);
            dfs(ps, as);
        }
    }

    public static boolean dfs(List<Integer> ps, Set<Integer> as) {
        // Success
        if (as.size() == 0) {
            sol.add(ps);
            return true;
        }

        boolean succ = false;
        for (int i : as) {
            boolean has = true;
            for (int j = 0; j<ps.size(); j++) {
                if ((Math.abs(i-ps.get(j)) == ps.size() - j))
                    has = false;
            }
            if (has) {
                List<Integer> cl = new ArrayList<>(ps);
                cl.add(i);
                Set<Integer> cs = new HashSet(as);
                cs.remove(i);
                succ = dfs(cl, cs);
            }
        }
        return succ;
    }

    public static void main(String[] args) {
        int n = 8;
        getQueen(n);
        for (List<Integer> l : sol)
            System.out.println(l);
    }
}
