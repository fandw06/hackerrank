package datastructure.downto0;

import java.util.*;

/**
 * Created by Dawei on 10/19/2016.
 */
public class BFS {
    public static int bfs(int m) {
        if (m == 1)
            return 1;
        if (m == 2)
            return 2;
        // store small numbers to prune bfs
        Map<Integer, HashSet<Integer>> known = new HashMap<>();
        HashSet<Integer> set2 = new HashSet<>();
        set2.add(2);
        HashSet<Integer> set3 = new HashSet<>();
        set3.add(3);
        set3.add(4);
        HashSet<Integer> set4 = new HashSet<>();
        set4.add(5);
        set4.add(6);
        set4.add(8);
        set4.add(9);
        set4.add(12);
        set4.add(16);

        known.put(2, set2);
        known.put(3, set3);
        known.put(4, set4);
        Queue<Integer> queue = new LinkedList<>();
        int step = 0;
        queue.add(m);
        queue.add(-1);
        while (queue.size() > 1) {
            int curr = queue.remove();
            if (curr == -1) {
                step++;
                queue.add(-1);
                continue;
            }
            if (known.get(2).contains(curr))
                return step + 2;
            if (known.get(3).contains(curr))
                return step + 3;
            if (known.get(4).contains(curr))
                return step + 4;


        //    for (int k = curr-1; k>= Math.sqrt(curr); k--) {
            for (int k = (int)Math.ceil(Math.sqrt(curr)); k < curr; k++) {
                if (curr%k == 0) {
                    queue.add(k);
                }
            }
            queue.add(curr-1);
        }
        return -1;
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
