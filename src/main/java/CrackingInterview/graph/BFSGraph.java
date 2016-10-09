package CrackingInterview.graph;

import java.util.*;

/**
 * Created by Dawei on 10/8/2016.
 */
public class BFSGraph {

    public static int[] bfs(Map<Integer, List<Integer>> al, int s) {
        int n = al.size();
        int dist[] = new int[n-1];
        Set<Integer> visited = new HashSet();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(-1);
        queue.add(s);
        visited.add(s);
        int level = 0;
        while (queue.size() > 1) {
            int curr = queue.remove();
            if (curr == -1) {
                queue.add(-1);
                level ++;
                continue;
            }
            List<Integer> children = al.get(curr);
            for (int i : children) {
                if (!visited.contains(i)) {
                    if (i < s)
                        dist[i-1] = 6 * level;
                    else
                        dist[i-2] = 6 * level;
                    queue.add(i);
                    visited.add(i);
                }
            }
        }
        for (int i = 0; i< dist.length; i++) {
            if (dist[i] == 0)
                dist[i] = -1;
        }
        return dist;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int times = s.nextInt();
        for (int i = 0; i< times; i++) {
            int n = s.nextInt();
            int e = s.nextInt();
            Map<Integer, List<Integer>> al = new HashMap();
            for (int j = 0; j < n; j++) {
                al.put(j + 1, new ArrayList<>());
            }
            for (int j = 0; j < e; j++) {
                int p1 = s.nextInt();
                int p2 = s.nextInt();
                al.get(p1).add(p2);
                al.get(p2).add(p1);
            }
            int st = s.nextInt();

            int dist[] = bfs(al, st);
            for (int dd : dist) {
                System.out.print(dd + " ");
            }
            System.out.println();
        }
    }
}
