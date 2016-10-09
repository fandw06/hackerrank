package CrackingInterview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dawei on 10/6/2016.
 */
public class BST {
    class Node {
        int data;
        Node left;
        Node right;
    }

    boolean checkBST(Node root) {
        List<Integer> nodes = new ArrayList<>();
        inOrder(root, nodes);
        for (int i = 1; i< nodes.size(); i++) {
            if (nodes.get(i) <= nodes.get(i-1))
                return false;
        }
        return true;
    }

    public void inOrder(Node root, List<Integer> nodes) {
        if (root == null)
            return;
        inOrder(root.left, nodes);
        nodes.add(root.data);
        inOrder(root.right, nodes);
    }



    public static void main(String[] args) {

    }
}
