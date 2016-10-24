package datastructure.downto0;

import java.util.*;

/**
 * Created by Dawei on 10/19/2016.
 */
public class Setq {
    public static int bfs(int m) {
        if (m == 1)
            return 1;
        if (m == 2)
            return 2;

        int step = 0;
        Set<Integer> prev = new HashSet<>();
        Set<Integer> visited = new HashSet();
        prev.add(m);
        Set<Integer> curr;
        while (true) {
            step++;
            curr = new HashSet<>();
            for (int i : prev) {
                if (i == 1)
                    return step;
                if (i == 2)
                    return 1+ step;
                for (int k = i-1; k>= Math.sqrt(i); k--) {
                    if (i%k == 0 && !visited.contains(k)) {
                        curr.add(k);
                        visited.add(k);
                    }
                }
                if (!visited.contains(i-1)) {
                    curr.add(i - 1);
                    visited.add(i-1);
                }
            }
        //    System.out.println(curr);
            prev = curr;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("./testcase/truck1.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        */
        int n = scanner.nextInt();
        int a[] = new int[n];
        for (int i = 0; i<n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i<n; i++)
            System.out.println(bfs(a[i]));
    }
}
