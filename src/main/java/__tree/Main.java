package __tree;

import java.util.List;

/**
 * Created by Dawei on 10/12/2016.
 */
public class Main {

    /**
     *             3
     *           7    2
     *        9   5    4
     *     6
     *
     * @return
     */
    public static Node build() {
        int a[] = {3, 7, 2, 9, 6, 5, 4};
        Node node[] = new Node[7];
        for (int i = 0; i< 7; i++)
            node[i] = new Node(a[i]);

        node[0].left = node[1];
        node[0].right = node[2];
        node[1].left = node[3];
        node[1].right = node[5];
        node[3].left = node[4];
        node[2].right = node[6];
        return node[0];
    }

    /**
     *             3
     *           7    2
     *        9   5    4
     *     6
     * level: 4
     * @return
     */
    public static Node3p build3p() {
        int a[] = {3, 7, 2, 9, 6, 5, 4};
        Node3p node[] = new Node3p[7];
        for (int i = 0; i< 7; i++)
            node[i] = new Node3p(a[i]);

        node[0].left = node[1];
        node[0].right = node[2];
        node[1].parent = node[0];
        node[2].parent = node[0];
        node[1].left = node[3];
        node[1].right = node[5];
        node[3].parent = node[1];
        node[5].parent = node[1];
        node[3].left = node[4];
        node[4].parent = node[3];
        node[2].right = node[6];
        node[6].parent = node[2];

        return node[0];
    }

    public static void testTree3p() {
        Node3p root = build3p();
        Tree3p.inOrder(root);
        System.out.println();
        Tree3p.preOrder(root);
        System.out.println();
        Tree3p.postOrder(root);
        System.out.println();
    }

    public static void testBFS() {
        Node root = build();
        System.out.println(BFS.bfsLevel(root));
        System.out.println();
        List<Node> set = BFS.bfslevelAt(root, 1);
        System.out.println("Level 1:");
        for (Node n : set)
            System.out.print(n.data + " ");
        System.out.println();
        set = BFS.bfslevelAt(root, 2);
        System.out.println("Level 2:");
        for (Node n : set)
            System.out.print(n.data + " ");
        System.out.println();
        set = BFS.bfslevelAt(root, 3);
        System.out.println("Level 3:");
        for (Node n : set)
            System.out.print(n.data + " ");
        System.out.println();
        set = BFS.bfslevelAt(root, 4);
        System.out.println("Level 4:");
        for (Node n : set)
            System.out.print(n.data + " ");
        System.out.println();
        set = BFS.bfslevelAt(root, 5);
        System.out.println("Level 5:");
        for (Node n : set)
            System.out.print(n.data + " ");
        System.out.println();

    }


    public static void main(String[] args) {

    //    testTree3p();
        testBFS();
    }
}
