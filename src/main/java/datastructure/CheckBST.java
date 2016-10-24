package datastructure;

import java.util.Stack;

/**
 * Created by Dawei on 10/13/2016.
 */
public class CheckBST {
    class Node {
        int data;
        Node left;
        Node right;
    }
    boolean checkBST(Node root) {
        int last = Integer.MIN_VALUE;
        Stack<Node> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            if (curr.data <= last)
                return false;
            last = curr.data;
            if (curr.right != null) {
                curr = curr.right;
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
            }
        }
        return true;
    }
}
