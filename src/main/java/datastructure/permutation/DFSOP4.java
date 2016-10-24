package datastructure.permutation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Dawei on 10/20/2016.
 */
/*
    prune the second number.
    second = first +n/2, or first+n/2+1

    添加新的判断：n个数字，如果前n-2个中有1和n，但是没有n/2，那么直接false，因为n/2不能安放。

    提速不大，最多计算到21。
    测试(21 100) OP3: 64, OP4: 17
 */
public class DFSOP4 {

    public static BigInteger k;
    public static int[] res;
    public static boolean[] visited;
    public static int num;
    // All possible steps, +-n/2, +-(n/2+1), ..., +-(n-1)
    public static List<Integer> step;

    public static int[] getPermutation(int n, BigInteger k) {
        if (n == 1){
            if (k.compareTo(BigInteger.ONE) > 0)
                return new int[]{-1};
            else
                return new int[]{1};
        }
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

        int nn = (n-1)/2;
        if (k.compareTo(BigInteger.valueOf(nn+5).multiply(BigInteger.ONE.shiftLeft(nn-1)))>0)
            return new int[]{-1};

        DFSOP4.k = k;
        DFSOP4.num = n;
        //DFS
        DFSOP4.visited = new boolean[n];
        // All possible steps, +-n/2, +-(n/2+1), ..., +-(n-1)
        DFSOP4.step = new ArrayList<>();
        for (int i = -n+1; i<= -n/2; i++)
            step.add(i);
        for (int i = n/2; i<=n-1; i++)
            step.add(i);

        boolean succ = false;
        int d1 = n/2;
        int d2 = n/2+1;
        for (int i = 1; i<= num; i++) {
            visited[i-1] = true;

            if (i <= n/2) {
                List<Integer> nlist = new ArrayList<>();
                nlist.add(i);
                visited[i+d1-1] = true;
                nlist.add(i+d1);
                if (!succ) {
                    succ = dfs(nlist);
                }
                visited[i+d1-1] = false;

                nlist = new ArrayList<>();
                nlist.add(i);
                visited[i+d2-1] = true;
                nlist.add(i+d2);
                if (!succ) {
                    succ = dfs(nlist);
                }
                visited[i+d2-1] = false;
            }
            else if ( i == n/2+1) {
                List<Integer> nlist = new ArrayList<>();
                nlist.add(i);
                visited[i-d1-1] = true;
                nlist.add(i-d1);
                if (!succ) {
                    succ = dfs(nlist);
                }
                visited[i-d1-1] = false;

                nlist = new ArrayList<>();
                nlist.add(i);
                visited[i+d1-1] = true;
                nlist.add(i+d1);
                if (!succ) {
                    succ = dfs(nlist);
                }
                visited[i+d1-1] = false;
            }
            else {
                List<Integer> nlist = new ArrayList<>();
                nlist.add(i);
                visited[i-d2-1] = true;
                nlist.add(i-d2);
                if (!succ) {
                    succ = dfs(nlist);
                }
                visited[i-d2-1] = false;

                nlist = new ArrayList<>();
                nlist.add(i);
                visited[i-d1-1] = true;
                nlist.add(i-d1);
                if (!succ) {
                    succ = dfs(nlist);
                }
                visited[i-d1-1] = false;
            }
            visited[i-1] = false;
        }
        return res;
    }

    public static boolean dfs(List<Integer> list) {
        if (list.size() == num) {
       //     System.out.println(k + " " +list);
            k = k.subtract(BigInteger.ONE);
            if (k.equals(BigInteger.ZERO)) {
                res = new int[list.size()];
                for (int i = 0; i< list.size(); i++)
                    res[i] = list.get(i);
                return true;
            }
            return false;
        }
        if (list.size() < num-1
                && visited[0] == true && visited[num-1] == true && visited[num/2] == false) {
            return false;
        }
        int last = list.get(list.size() - 1);
        boolean succ = false;
        for (int s : step) {
            if ((last+s)>=1 && (last+s)<=num && !visited[last+s-1]) {
                visited[last + s -1] = true;
                List<Integer> nlist = new ArrayList<>(list);
                nlist.add(last + s);
                if (!succ)
                    succ = dfs(nlist);
                visited[last + s -1] = false;
            }
        }
        return succ;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("./testcase/perm18.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
*/
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
