package __backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Dawei on 10/20/2016.
 */
public class DFSMark {

    public static boolean visited[][];
    public static Set<Object> total;

    public static void backtrack(Set<Object> initialSet) {
        boolean succ = false;
        for (Object e : initialSet) {
            if (!succ)
                succ = dfs(new ArrayList<>());
        }
    }

    public static boolean dfs(List<Object> partialSolution) {
        if (success()) {
            return true;
        }
        if (fail()) {
            return false;
        }
        boolean succ = false;

        int currRow = 0;
        int currCol = 0;
        for (Object e : total) {
            if (visited[currRow][currCol])
                continue;
            // Add current element to partial solution list.
            List<Object> nlist = new ArrayList<>(partialSolution);
            nlist.add(e);
            // Mark current element
            visited[currRow][currCol] = false;
            if (!succ)
                succ = dfs(nlist);
            // Unmark it after dfs;
            visited[currRow][currCol] = true;
        }
        return succ;
    }

    private static boolean success() {
        return true;
    }

    private static boolean fail() {
        return true;
    }
}
