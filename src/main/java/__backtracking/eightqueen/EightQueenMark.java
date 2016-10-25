package __backtracking.eightqueen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Dawei on 10/24/2016.
 */
public class EightQueenMark {
    public static List<List<Integer>> sol = new ArrayList<>();
    public static boolean visited[][];

    public static void getQueen(int n) {

        visited = new boolean[n][n];
        for (int i = 0; i<n; i++)
            visited[i] = new boolean[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i<=n; i++)
            set.add(i);

        for (int i = 1; i <= n; i++) {
            List<Integer> ps = new ArrayList<>();
            ps.add(i);
            visited[0][i-1] = true;
            dfs(ps);
            visited[0][i-1] = true;
        }
    }

    public static boolean dfs(List<Integer> ps) {
        // Success
        if (ps.size() == visited.length) {
            sol.add(ps);
            return true;
        }

        boolean succ = false;
        for (int i = 1; i<=visited.length; i++) {
            boolean has = true;
            for (int j = 0; j<ps.size(); j++) {
                if ((ps.get(j) == i) || (Math.abs(i-ps.get(j)) == ps.size() - j))
                    has = false;
            }
            if (has) {
                List<Integer> cl = new ArrayList<>(ps);
                cl.add(i);
                visited[ps.size()][i-1] = true;
                succ = dfs(cl);
                visited[ps.size()][i-1] = false;
            }
        }
        return succ;
    }

    public static void main(String[] args) {
        int n = 4;
        getQueen(n);
        for (List<Integer> l : sol)
            System.out.println(l);
    }
}
