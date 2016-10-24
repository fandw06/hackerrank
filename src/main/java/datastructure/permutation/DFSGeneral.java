package datastructure.permutation;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by Dawei on 10/20/2016.
 */
public class DFSGeneral {
    public static int[] getPermutation(int n, BigInteger k) {
        if (n%2 == 0){
            if (k.compareTo(BigInteger.valueOf(2)) > 0)
                return new int[]{-1};
            if (k.equals(BigInteger.ONE)) {
                int curr[] = new int[n];
                for (int i = 0; i<n; i += 2) {
                    curr[i] = n/2 - i/2;
                    curr[i+1] = n - i/2;
                }
                return curr;
            }
            if (k.equals(BigInteger.valueOf(2))) {
                int curr[] = new int[n];
                for (int i = 0; i<n; i += 2) {
                    curr[i] = (n + i + 2)/2;
                    curr[i+1] = (i+2)/2;
                }
                return curr;
            }
        }
        // limit : 2^(n-1)(n+5)
        if (k.shiftRight(n-1).compareTo(BigInteger.valueOf(n+5))>0)
            return new int[]{-1};

        //DFS
        // All remaining numbers
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i<= n; i++)
            set.add(i);
        // All possible steps, +-n/2, +-(n/2+1), ..., +-(n-1)
        List<Integer> step = new ArrayList<>();
        for (int i = -n+1; i<= -n/2; i++)
            step.add(i);        for (int i = n/2; i<=n-1; i++)
            step.add(i);
        for (int i : set) {
            Set<Integer> nset = new HashSet(set);
            nset.remove(i);
            List<Integer> nlist = new ArrayList<>();
            nlist.add(i);
            dfs(nlist, nset, step);
        }
        return new int[]{-1};
    }

    public static void dfs(List<Integer> list, Set<Integer> set, List<Integer> step) {
        if (set.size() == 0) {
            System.out.println(list);
            return;
        }
        int last = list.get(list.size() - 1);
        for (int s : step) {
            if (set.contains(last + s)) {
                Set<Integer> nset = new HashSet(set);
                nset.remove(last + s);
                List<Integer> nlist = new ArrayList<>(list);
                nlist.add(last + s);
                dfs(nlist, nset, step);
            }
        }
        return;
    }

    public static void main(String[] args) {
    //    Scanner scanner = new Scanner(System.in);

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("./testcase/perm0.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int q = scanner.nextInt();
        for (int i = 0; i<q; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int res[] = getPermutation(n, BigInteger.valueOf(k));
            if (res[0] == -1)
                System.out.println(-1);
            else {
                for (int j = 0; j<res.length; j++)
                    System.out.print(res[j] + " ");
                System.out.println();
            }
        }
    }
}
