package informatica;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dawei on 10/6/2016.
 */
public class TreeBuild {
    static class Node{
        public char val;
        public Node left = null;
        public Node right = null;
        public Node parent = null;
        public Node(char val) {
            this.val = val;
        }
    }

    static String SExpression(String nodes) {
        Map<Character, Node> nodeMap = new HashMap<>();
        String sp[] = nodes.split(" ");
        for (String ss : sp) {
            char parent = ss.charAt(1);
            char son = ss.charAt(3);
            Node nParent = null;
            Node nSon = null;
            if (!nodeMap.containsKey(parent)) {
                nParent = new Node(parent);
                nodeMap.put(parent, nParent);
            }
            else
                nParent = nodeMap.get(parent);
            if (!nodeMap.containsKey(son)) {
                nSon = new Node(son);
                nodeMap.put(son, nSon);
            }
            else
                nSon = nodeMap.get(son);

            if (nParent.left != null && nParent.right != null) {
                if (nParent.left.val != nSon.val && nParent.right.val != nSon.val)
                    return "E1";
                else
                    return "E2";
            }
            if (nSon.parent != null)
                return "E3";
            if (nParent.left == null) {
                nParent.left = nSon;
                nSon.parent = nParent;
            }
            else{
                nParent.right = nSon;
                nSon.parent = nParent;
            }
        }

        // Find root
        Node root = null;
        for (Map.Entry<Character, Node> me : nodeMap.entrySet()) {
            if (me.getValue().parent == null) {
                if (root != null)
                    return "E4";
                root = me.getValue();
            }
        }
        return DFS(root);
    }

    public static String DFS(Node root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        sb.append("(" + root.val);
        if (root.left != null)
            sb.append(DFS(root.left));
        if (root.right != null)
            sb.append(DFS(root.right));
        sb.append(")");
        return sb.toString();
    }

    public static void main(String[] args) {
        //E3
        String s1 = "(A,B) (A,C) (B,D) (D,C)";
        //Correct
        String s2 = "(E,G) (C,F) (A,B) (A,C) (B,D) (D,E)";
        String s3 = "(A,B) (A,C)";
        String s4 = "(A,B) (A,C) (B,D) (D,C)";
        System.out.println(SExpression(s3));

    }
}
