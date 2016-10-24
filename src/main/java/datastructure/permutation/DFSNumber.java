package datastructure.permutation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Dawei on 10/20/2016.
 */
/*
    prune the second number.
    second = first +n/2, or first+n/2+1

    添加新的判断：n个数字，如果前n-2个中有1和n，但是没有n/2，那么直接false，因为n/2不能安放。
    一共有三个点只有两条边，因此检测三次。
    测试(21 100) OP3: 64, OP4: 17, OP5: 4

    改变数据结构，不需要使用list，一个循环即可。但是时间变化不大。

    测试n不同时，不同首位数字的可能性。
 */
public class DFSNumber {

    public static BigInteger k;
    public static int[] res;
    public static boolean[] visited;
    public static int num;
    public static int[] times;

    public static int[] getPermutation(int n, BigInteger k) {
        times = new int[n];
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

        DFSNumber.k = k;
        DFSNumber.num = n;
        //DFS
        DFSNumber.visited = new boolean[n];

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
                if (!succ)
                    succ = dfs(nlist);
                visited[i-d2-1] = false;

                nlist = new ArrayList<>();
                nlist.add(i);
                visited[i-d1-1] = true;
                nlist.add(i-d1);
                if (!succ)
                    succ = dfs(nlist);

                visited[i-d1-1] = false;
            }
            visited[i-1] = false;
        }
        System.out.println("Times: " + Arrays.toString(times));
        return res;
    }

    public static boolean dfs(List<Integer> list) {
        if (list.size() == num) {
   //         System.out.println(k + " " +list);
            times[list.get(0)-1]++;
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

    public static void main(String[] args) {

        int n[] = {3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25};
        String k[] = new String[n.length];
        for (int i = 0; i<n.length; i++)
            k[i] = String.valueOf((1<<((n[i]-1)/2-1))*(5+((n[i]-1)/2)));
        System.out.println(Arrays.toString(k));
        for (int i = 0; i<n.length; i++) {
            int res[] = getPermutation(n[i], new BigInteger(k[i]));
        }
    }
}
