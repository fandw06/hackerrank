package __backtracking;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by Dawei on 10/20/2016.
 */
public class DFSGeneral {
    public static void backtrack(Set<Object> initialSet) {
        for (Object e : initialSet) {
            dfs(new ArrayList<>(), initialSet);
        }
    }

    public static boolean dfs(List<Object> partialSolution, Set<Object> availableSet) {
        if (success()) {
            return true;
        }
        if (fail()) {
            return false;
        }
        boolean success = false;
        for (Object e : availableSet) {
            // Remove current element from available solution set.
            Set<Object> nset = new HashSet(availableSet);
            nset.remove(e);
            // Add current element to partial solution list.
            List<Object> nlist = new ArrayList<>(partialSolution);
            nlist.add(e);
            dfs(nlist, nset);
        }
        return success;
    }

    private static boolean success() {
        return true;
    }

    private static boolean fail() {
        return true;
    }

    public static void main(String[] args) {
        backtrack(null);
    }
}
