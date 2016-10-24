package __tree;

/**
 * Created by Dawei on 10/14/2016.
 */
public class Tree3p {

    public static void visit(Node3p n) {
        System.out.print(n.val + " ");
    }

    public static void inOrder(Node3p root) {
        if (root.left == null && root.right == null) {
            visit(root);
            return;
        }
        Node3p curr = root;
        // last operation: left: -1; parent: 0; right: 1
        int lastOp = -1;
        while (curr.left != null)
            curr = curr.left;
        while (true) {
            if (lastOp == -1) {
                visit(curr);
                curr = curr.parent;
                lastOp = 0;
            }
            else if (lastOp == 0) {
                visit(curr);
                if (curr.right != null) {
                    curr = curr.right;
                    lastOp = 1;
                }
                else if (curr.parent != null){
                    curr = curr.parent;
                    lastOp = 0;
                }
                else {
                    return;
                }
            }
            else {
                if (curr.left != null) {
                    while (curr.left != null)
                        curr = curr.left;
                    visit(curr);
                    curr = curr.parent;
                    lastOp = 0;
                }
                else if (curr.right != null){
                    visit(curr);
                    curr = curr.right;
                    lastOp = 1;
                }
                else {
                    visit(curr);
                    while (curr.parent != null && curr.parent.right == curr) {
                        curr = curr.parent;
                    }
                    if (curr.parent == null)
                        return;
                    curr = curr.parent;
                    lastOp = 0;
                }
            }
        }
    }

    public static void preOrder(Node3p root) {
        if (root.left == null && root.right == null) {
            visit(root);
            return;
        }
        Node3p curr = root;
        int lastOp;
        visit(curr);
        if (curr.left != null) {
            curr = curr.left;
            lastOp = -1;
        }
        else {
            curr = curr.right;
            lastOp = 1;
        }

        while (true) {
            visit(curr);
            if (lastOp == -1) {
                if (curr.left != null) {
                    curr = curr.left;
                    lastOp = -1;
                }
                else if (curr.right != null) {
                    curr = curr.right;
                    lastOp = 1;
                }
                else {
                    while (curr.parent != null && curr.parent.right == null) {
                        curr = curr.parent;
                    }
                    if (curr.parent == null)
                        return;
                    else {
                        curr = curr.parent.right;
                        lastOp = 1;
                    }
                }
            }
            else {
                if (curr.left != null) {
                    curr = curr.left;
                    lastOp = -1;
                }
                else if (curr.right != null) {
                    curr = curr.right;
                    lastOp = 1;
                }
                else {
                    while (curr.parent != null && curr.parent.right == curr) {
                        curr = curr.parent;
                    }
                    if (curr.parent == null)
                        return;
                    else {
                        while (curr.parent != null && curr.parent.right == null) {
                            curr = curr.parent;
                        }
                        if (curr.parent == null)
                            return;
                        else {
                            curr = curr.parent.right;
                            lastOp = 1;
                        }
                    }
                }
            }
        }
    }

    public static void postOrder(Node3p root) {
        if (root.left == null && root.right == null) {
            visit(root);
            return;
        }
        Node3p curr = root;
        // last operation: left: -1; parent: 0; right: 1
        while (curr.left != null)
            curr = curr.left;
        int lastOp = 0;
        visit(curr);
        if (curr.parent.right != null) {
            curr = curr.parent.right;
            lastOp = 1;
        }
        else {
            curr = curr.parent;
            lastOp = 0;
        }

        while (true) {
            if (lastOp == 0) {
                visit(curr);
                if (curr.parent == null)
                    return;
                else {
                    if (curr.parent.right != null && curr.parent.right != curr) {
                        curr = curr.parent.right;
                        lastOp = 1;
                    } else {
                        curr = curr.parent;
                        lastOp = 0;
                    }
                }
            }
            else {
                if (curr.left != null) {
                    while (curr.left != null)
                        curr = curr.left;
                    visit(curr);
                    curr = curr.parent;
                    lastOp = 0;
                }
                else if (curr.right != null){
                    curr = curr.right;
                    while (curr.left != null)
                        curr = curr.left;
                    visit(curr);
                    curr = curr.parent;
                    lastOp = 0;
                }
                else {
                    visit(curr);
                    curr = curr.parent;
                    lastOp = 0;
                }

            }
        }
    }
}
