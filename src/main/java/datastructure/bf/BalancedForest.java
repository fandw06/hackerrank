package datastructure.bf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Dawei on 10/13/2016.
 */

/**
 * 基本思想：将以每个node为root的tree的sum保存到root中，每次切割，直接减去新root的值即可。
 *  考虑切两刀，三个值必须为aab形式，且a>b，那么a-b即所求。
 * 注意的问题：
 * 1，由于是先连接再切，因此可以只切一刀，成为aa的形式，那么a为所求。
 * 2，edge不一定是按照parent-child的顺序，因此要判断谁是parent，目前build时候使用BFS，balance时候使用sum判断。
 * 3，目前算法是O(n^3)，每次任选两刀或者一刀，C_n_2.另外，判断两次切口是否是ancestor关系使用dfs最坏为O(n)
 *
 * 目前只能通过3个tests
 */
public class BalancedForest {
    static class Node {
        int index;
        int coins;
        int sum;
        Map<Integer, Node> children;

        Node(){
            children = new HashMap<>();
        }
        Node(int i, int c){
            children = new HashMap<>();
            this.index = i;
            this.coins = c;
        }
    }

    public static int split(Node nodes[], List<int[]> edges) {
        assignSum(nodes[0]);
        for (int i = 0; i< nodes.length; i++)
            System.out.print(nodes[i].sum + " ");
        System.out.println();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i< edges.size(); i++) {
            if (nodes[0].sum == 2* nodes[getChild(nodes, edges.get(i))].sum) {
                if (nodes[0].sum/2 < min) {
                    min = nodes[0].sum/2;
                }
            }

            for (int j = i + 1; j< edges.size(); j++) {
                // cut edges i and j.
                int a, b, c;
                Node c1 = nodes[getChild(nodes, edges.get(i))];
                Node c2 = nodes[getChild(nodes, edges.get(j))];
                if (contains(c1, c2)) {
                    a = nodes[0].sum - c1.sum;
                    b = c1.sum - c2.sum;
                    c = c2.sum;
                }
                else if (contains(c2, c1)) {
                    a = nodes[0].sum - c2.sum;
                    b = c2.sum - c1.sum;
                    c = c1.sum;
                }
                else {
                    a = nodes[0].sum - c1.sum - c2.sum;
                    b = c1.sum;
                    c = c2.sum;
                }

                if (a == b && a>c) {
                    if (a-c < min)
                        min = a-c;
                }
                else if (a == c && a>b) {
                    if (a-b < min)
                        min = a-b;
                }
                else if (b == c && b>a) {
                    if (b-a < min)
                        min = b-a;
                }

            }
        }

        return min == Integer.MAX_VALUE? -1 : min;
    }


    public static int getChild(Node nodes[], int[] pos) {
        if (nodes[pos[0]-1].sum < nodes[pos[1]-1].sum)
            return pos[0] - 1;
        return pos[1] -1;
    }

    public static boolean contains(Node p, Node s) {
        if (p == null)
            return false;
        if (p.index == s.index)
            return true;
        for (Map.Entry<Integer, Node> e : p.children.entrySet()) {
            if (contains(e.getValue(), s))
                return true;
        }
        return false;
    }

    public static void buildTree(Node nodes[], List<int[]> edges) {
        List<int[]> e = new ArrayList(edges);
        Queue<Node> queue = new LinkedList<>();
        queue.add(nodes[0]);
        while (!queue.isEmpty()) {
            Node curr = queue.remove();
            int index = curr.index;
            for (int i = 0; i< e.size(); i++) {
                int x = e.get(i)[0];
                int y = e.get(i)[1];
                if ( x == index || y == index) {
                    curr.children.put((x+y-index), nodes[(x+y-index)-1]);
                    queue.add(nodes[(x+y-index)-1]);
                    e.remove(i);
                    i--;
                }
            }
        }
    }

    public static void assignSum(Node root) {
        if (root.children.size() == 0) {
            root.sum = root.coins;
            return;
        }
        int sum = root.coins;
        for (Map.Entry<Integer, Node> e : root.children.entrySet()) {
            if (e.getValue().sum == 0)
                assignSum(e.getValue());
            sum += e.getValue().sum;
        }
        root.sum = sum;
        return;
    }


    public static void main(String args[]) {

    //    Scanner scanner = new Scanner(System.in);
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("balancedForest2.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int n = scanner.nextInt();
        for (int i = 0; i< n; i++) {
            int num = scanner.nextInt();
            int coins[] = new int[num];
            Node nodes[] = new Node[num];
            for (int j = 0; j < num; j++) {
                coins[j] = scanner.nextInt();
            }
            for (int j = 0; j< num; j++) {
                nodes[j] = new Node(j+1, coins[j]);
            }

            // The edge is not necessarily in a parent-child order.
            List<int[]> edges = new ArrayList<>();
            for (int j = 0; j< num-1; j++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                edges.add(new int[]{x, y});
            }
            buildTree(nodes, edges);
            int min = split(nodes, edges);
            System.out.println(min);
        }
    }

}
