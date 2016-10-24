package datastructure;

import __tree.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Dawei on 10/15/2016.
 */
public class SwapNodes {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(){}
        Node(int data){
            this.data = data;
        }
    }

    public static void inOrderNR(Node root) {
        Stack<Node> stack = new Stack();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while(!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.print(curr.data + " ");
            if (curr.right != null) {
                curr = curr.right;
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
            }
        }
        System.out.println();
    }

    public static int bfsLevel(Node root) {
        int level = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(queue.size() > 1) {
            Node curr = queue.remove();
            if (curr == null) {
                level++;
                queue.add(null);
                continue;
            }
            //    visit(curr);
            if (curr.left != null)
                queue.add(curr.left);
            if (curr.right != null)
                queue.add(curr.right);
        }
        return level + 1;
    }

    public static List<Node> bfslevelAt(Node root, int l) {
        List<Node> ln = new ArrayList<>();
        if (root == null || l < 1)
            return ln;
        int level = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(queue.size() > 1) {
            Node curr = queue.remove();
            if (curr == null) {
                level++;
                if (level == l)
                    return ln;
                queue.add(null);
                continue;
            }
            if (level == l -1)
                ln.add(curr);
            if (curr.left != null)
                queue.add(curr.left);
            if (curr.right != null)
                queue.add(curr.right);
        }
        return ln;
    }

    public static void swap(Node root, int level) {
        int totalLevel = bfsLevel(root);
        for (int i = level; i<= totalLevel; i += level) {
            List<Node> list = bfslevelAt(root, i);
            for (Node n : list) {
                Node left = n.left;
                Node right = n.right;
                n.right = left;
                n.left = right;
            }
        }
    }

    public static void main(String[] args) {
    //    Scanner scanner = new Scanner(System.in);
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("./testcase/swapnodes3.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int num = scanner.nextInt();
        Node nodes[] = new Node[num + 1];
        for (int i = 1; i<= num; i++)
            nodes[i] = new Node();
        for (int i = 1; i<= num; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();

            nodes[i].data = i;
            if (l != -1)
                nodes[i].left = nodes[l];
            if (r != -1)
                nodes[i].right = nodes[r];
        }
        int q = scanner.nextInt();
        for (int i = 0; i< q; i++) {
            swap(nodes[1], scanner.nextInt());
            inOrderNR(nodes[1]);
        }
    }
}
