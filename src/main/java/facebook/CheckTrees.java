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
public class CheckTrees {
    static class Node {
        char val;
        Node left;
        Node right;
        public Node(char v) {
            val = v;
        }
    }

    public static void findMismatch(Node root1, Node root2) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        Node r1 = root1;
        Node r2 = root2;

        while(root1 != null) {
            stack1.push(root1);
            root1 = root1.left;
        }

        while(root2 != null) {
            stack2.push(root2);
            root2 = root2.left;
        }


        while(!stack1.isEmpty() && !stack2.isEmpty()) {
            Node curr1 = stack1.pop();
            Node curr2 = stack2.pop();

            if (curr1.val != curr2.val && (curr1.right == null && curr1.left == null) && (curr2.right == null && curr2.left == null)) {
                System.out.println("(" + curr1.val + ", " + curr2.val + ")");
                return;
            }

            if (curr1.right != null) {
                curr1 = curr1.right;
                while (curr1 != null) {
                    stack1.push(curr1);
                    curr1 = curr1.left;
                }
            }

            if (curr2.right != null) {
                curr2 = curr2.right;
                while (curr2 != null) {
                    stack2.push(curr2);
                    curr2 = curr2.left;
                }
            }
        }
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
