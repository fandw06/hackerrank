package facebook;

import java.util.Stack;

/**
 *       A                   A
 *    B      C           D       B
 * D    E
 *
 *   output: (E,B)
 *
 *    d b e a c
 *    d a b
 */
public class CheckTrees3 {
    static class Node {
        char val;
        Node left;
        Node right;
        Node parent;
        public Node(char v) {
            val = v;
        }
    }

    public static void findMismatch(Node root1, Node root2) {

    }

    public static void main(String[] args) {
        Node root1 = new Node('A');
        root1.left = new Node('B');
        root1.right = new Node('C');
        root1.left.left = new Node('D');
        root1.left.right = new Node('E');
        Node root2 = new Node('A');
        root2.left = new Node('D');
        root2.right = new Node('B');
        findMismatch(root1, root2);
    }

}
