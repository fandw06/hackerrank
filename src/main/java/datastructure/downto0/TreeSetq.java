package datastructure.downto0;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Dawei on 10/19/2016.
 */
public class TreeSetq {
    public static int bfs(int m) {
        if (m == 1)
            return 1;
        if (m == 2)
            return 2;

        int step = 0;
        TreeSet<Integer> prev = new TreeSet<>();
        Set<Integer> visited = new HashSet<>();
        prev.add(m);
        TreeSet<Integer> curr;
        while (true) {
            step++;
            curr = new TreeSet<>();
            for (int i : prev) {
                for (int k = i-1; k>= Math.sqrt(i); k--) {

                    if (i%k == 0 && !visited.contains(k)) {
                        if (k == 2)
                            return 1+ step;
                        curr.add(k);
                        visited.add(k);
                    }
                }
                if (!visited.contains(i-1)) {
                    if (i == 3)
                        return 1+ step;
                    curr.add(i - 1);
                    visited.add(i-1);
                }
            }
     //       System.out.println(curr);
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
