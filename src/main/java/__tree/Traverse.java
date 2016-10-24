package __tree;

import java.util.Stack;

/**
 * Created by Dawei on 10/12/2016.
 */
public class Traverse {


    public static void visit(Node n) {
        System.out.print(n.data + " ");
    }

    public static void preOrder(Node root) {
        if (root == null)
            return;
        visit(root);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void preOrderNR(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            visit(curr);
            if (curr.right != null)
                stack.push(curr.right);
            if (curr.left != null)
                stack.push(curr.left);
        }
    }

    public static void inOrder(Node root) {
        if (root == null)
            return;
        inOrder(root.left);
        visit(root);
        inOrder(root.right);
    }

    public static void inOrderNR(Node root) {
        Stack<Node> stack = new Stack();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while(!stack.isEmpty()) {
            Node curr = stack.pop();
            visit(curr);
            if (curr.right != null) {
                curr = curr.right;
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
            }
        }
    }

    public static void postOrderNR(Node root) {
        Stack<Node> stack = new Stack<>();
        Stack<Node> aux = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            aux.push(curr);
            if (curr.right != null)
                stack.push(curr.right);
            if (curr.left != null)
                stack.push(curr.left);
        }
        while (!aux.isEmpty()) {
            visit(aux.pop());
        }
    }

    public static void postOrder(Node root) {
        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        visit(root);
    }



}
