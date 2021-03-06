package datastructure.permutation;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by Dawei on 10/20/2016.
 */
/*
    This passed 17 tests, got 62.2.

 */
public class DFS {
    public static BigInteger k;
    public static int[] res;

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
        if (n == 1 && k.compareTo(BigInteger.ONE) > 0)
            return new int[]{-1};
        int nn = (n-1)/2;
        if (n> 1 && k.compareTo(BigInteger.valueOf(nn+5).multiply(BigInteger.ONE.shiftLeft(nn-1)))>0)
            return new int[]{-1};

        DFS.k = k;
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
        boolean succ = false;
        for (int i : set) {
            Set<Integer> nset = new HashSet(set);
            nset.remove(i);
            List<Integer> nlist = new ArrayList<>();
            nlist.add(i);
            if (!succ) {
                succ = dfs(nlist, nset, step);
            }
        }
        return res;
    }

    public static boolean dfs(List<Integer> list, Set<Integer> set, List<Integer> step) {
        if (set.size() == 0) {
        //    System.out.println(k + " " +list);
            k = k.subtract(BigInteger.ONE);
            if (k.equals(BigInteger.ZERO)) {
                res = new int[list.size()];
                for (int i = 0; i< list.size(); i++)
                    res[i] = list.get(i);
                return true;
            }
        }
        int last = list.get(list.size() - 1);
        boolean succ = false;
        for (int s : step) {
            if (set.contains(last + s)) {
                Set<Integer> nset = new HashSet(set);
                nset.remove(last + s);
                List<Integer> nlist = new ArrayList<>(list);
                nlist.add(last + s);
                if (!succ) {
                    succ = dfs(nlist, nset, step);
                }
            }
        }
        return succ;
    }

    public static void main(String[] args) {
   //     Scanner scanner = new Scanner(System.in);

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("./testcase/perm18.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int q = scanner.nextInt();
        for (int i = 0; i<q; i++) {
            int n = scanner.nextInt();
            String k = scanner.next();
            int res[] = getPermutation(n, new BigInteger(k));
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
