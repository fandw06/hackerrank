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
public class CheckTrees2 {
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

        pushLeft(root1, stack1);
        pushLeft(root2, stack2);

        while(!stack1.isEmpty() && !stack2.isEmpty()) {
            Node curr1 = stack1.pop();
            Node curr2 = stack2.pop();

            if (curr1.val != curr2.val && (curr1.right == null && curr1.left == null) && (curr2.right == null && curr2.left == null)) {
                System.out.println("(" + curr1.val + ", " + curr2.val + ")");
                return;
            }
            processRight(curr1, stack1);
            processRight(curr2, stack2);
        }
    }

    private static void pushLeft(Node root, Stack<Node> stack) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    private static void processRight(Node curr, Stack<Node> stack) {
        if (curr.right != null) {
            curr = curr.right;
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
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
