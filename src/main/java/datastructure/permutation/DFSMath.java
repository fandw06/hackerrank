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

/**
 * 开始找到的通项公式是不对的，修改通项。
 *
 *
 * (25, 23) 十秒钟左右
 */
public class DFSMath {
    public static BigInteger k;
    public static int[] res;
    public static boolean[] visited;
    public static int num;

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

        DFSMath.k = k;
        DFSMath.num = n;
        //DFS
        DFSMath.visited = new boolean[n];

        boolean succ = false;
        int first = getFirst(num);
        int d1 = n/2;
        int d2 = n/2+1;

        visited[first-1] = true;
        if (first <= n/2) {
            List<Integer> nlist = new ArrayList<>();
            nlist.add(first);
            visited[first+d1-1] = true;
            nlist.add(first+d1);
            if (!succ) {
                succ = dfs(nlist);
            }
            visited[first+d1-1] = false;
            nlist = new ArrayList<>();
            nlist.add(first);
            visited[first+d2-1] = true;
            nlist.add(first+d2);
            if (!succ) {
                succ = dfs(nlist);
            }
            visited[first+d2-1] = false;
        }
        else if ( first == n/2+1) {
            List<Integer> nlist = new ArrayList<>();
            nlist.add(first);
            visited[first-d1-1] = true;
            nlist.add(first-d1);
            if (!succ) {
                succ = dfs(nlist);
            }
            visited[first-d1-1] = false;

            nlist = new ArrayList<>();
            nlist.add(first);
            visited[first+d1-1] = true;
            nlist.add(first+d1);
            if (!succ) {
                succ = dfs(nlist);
            }
            visited[first+d1-1] = false;
        }
        else {
            List<Integer> nlist = new ArrayList<>();
            nlist.add(first);
            visited[first-d2-1] = true;
            nlist.add(first-d2);
            if (!succ)
                succ = dfs(nlist);
            visited[first-d2-1] = false;
            nlist = new ArrayList<>();
            nlist.add(first);
            visited[first-d1-1] = true;
            nlist.add(first-d1);
            if (!succ)
                succ = dfs(nlist);

            visited[first-d1-1] = false;
        }

        return res;
    }

    public static boolean dfs(List<Integer> list) {
        if (list.size() == num) {
            //         System.out.println(k + " " +list);
            k = k.subtract(BigInteger.ONE);
            if (k.equals(BigInteger.ZERO)) {
                res = new int[list.size()];
                for (int i = 0; i< list.size(); i++)
                    res[i] = list.get(i);
                return true;
            }
            return false;
        }
        if (list.size() < num-1) {
            if (visited[0] == true && visited[num-1] == true && visited[num/2] == false)
                return false;
            if (visited[num - 2] == true && visited[num - 1] == true && visited[num/2 - 1] == false)
                return false;
            if (visited[0] == true && visited[1] == true && visited[num/2 + 1] == false)
                return false;
        }
        int last = list.get(list.size() - 1);
        boolean succ = false;

        for(int i = 1; i<= last-num/2; i++) {
            if (!visited[i-1]) {
                visited[i -1] = true;
                List<Integer> nlist = new ArrayList<>(list);
                nlist.add(i);
                if (!succ)
                    succ = dfs(nlist);
                visited[i -1] = false;
            }
        }

        for(int i = last + num/2; i<= num; i++) {
            if (!visited[i-1]) {
                visited[i -1] = true;
                List<Integer> nlist = new ArrayList<>(list);
                nlist.add(i);
                if (!succ)
                    succ = dfs(nlist);
                visited[i -1] = false;
            }
        }

        return succ;
    }

    public static int getFirst(int n) {
        if (n == 1) {
            return 1;
        }
        int a[] = new int[n];
        // total : 2^(n-1)(n+5)
        int nn = (n-1)/2;
        int total = (1<<(nn-1))*(nn+5);
        int result = 0;
        // build array
        int hsum = total/2;
        for (int i = 0; i <n/2; i++) {
            if (i == 0)
                a[i] = 2;
            else if (i == 1)
                a[i] = 3;
            else
                a[i] = (i + 5)* (1<<(i-2));
            hsum -= a[i];
        }
        a[n/2] = hsum*2;
        for (int i = 0; i <n/2; i++) {
            if (i == 0)
                a[n-1-i] = 2;
            else if (i == 1)
                a[n-1-i] = 3;
            else
                a[n-1-i] = (i + 5)* (1<<(i-2));
        }
     //  System.out.println(Arrays.toString(a));

        //find position.
        for (int i = 0; i<n; i++) {
            k = k.subtract(BigInteger.valueOf(a[i]));
            if (k.compareTo(BigInteger.ZERO) <= 0) {
                k = k.add(BigInteger.valueOf(a[i]));
                return i+1;
            }
        }
        k = k.add(BigInteger.valueOf(a[n-1]));
        return n;
    }

    public static void main(String[] args) {
        /*
        DFSMath.k = BigInteger.valueOf(11);
        System.out.println(getFirst(19));
        System.out.println(k);
        */
        //23: [2, 3, 7, 16, 36, 80, 176, 384, 832, 1792, 3840, 2048, 3840, 1792, 832, 384, 176, 80, 36, 16, 7, 3, 2]
        Scanner scanner = new Scanner(System.in);
        /*
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("./testcase/perm19.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        */
        int q = scanner.nextInt();
        for (int i = 0; i<q; i++) {
            int n = scanner.nextInt();
            String k = scanner.next();

            long start = System.currentTimeMillis();
            int res[] = getPermutation(n, new BigInteger(k));
            long end = System.currentTimeMillis();
            System.out.println("Time: " + (double)(end-start)/1000.0);
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
