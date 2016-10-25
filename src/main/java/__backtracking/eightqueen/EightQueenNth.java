package __backtracking.eightqueen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Dawei on 10/24/2016.
 */
public class EightQueenNth {
    public static List<Integer> sol = new ArrayList<>();
    public static int num;

    public static void getQueen(int n, int k) {
        EightQueenNth.num = k;
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
            num--;
            if (num == 0) {
                sol = ps;
                return true;
            }
            else
                return false;
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
                if (!succ)
                    succ = dfs(cl, cs);
            }
        }
        return succ;
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 8;
        getQueen(n, k);
        System.out.println(sol);
    }
}
