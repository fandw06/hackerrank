package __tree;

import java.util.*;

/**
 * Created by Dawei on 10/12/2016.
 */
public class BFS {

    public static void visit(Node n) {
        System.out.print(n.data + " ");
    }

    public static void bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(queue.isEmpty()) {
            Node curr = queue.remove();
            visit(curr);
            if (curr.left != null)
                queue.add(curr.left);
            if (curr.right != null)
                queue.add(curr.right);
        }
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

    /**
     * Level index starts from 1.
     * Return type could be list or set, but list is better since it could
     * contain the order information, usually from left to right.
     *
     * @param root
     * @param l
     * @return a list of level l nodes from left to right. Return an empty list if l parameter is not valid.
     */
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

}
