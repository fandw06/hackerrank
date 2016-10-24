package datastructure;

/**
 * Created by Dawei on 10/13/2016.
 */
public class Huffman {
    class Node {
        public  int frequency; // the frequency of this tree
        public  char data;
        public  Node left, right;
    }

    public static void decode(String s, Node root) {
        char chars[] = s.toCharArray();
        Node curr = root;
        for (int i = 0; i< s.length(); ) {
            while (curr.left != null || curr.right != null) {
                if (chars[i] == '1') {
                    curr = curr.right;
                }
                else {
                    curr = curr.left;
                }
                i++;
            }
            System.out.print(curr.data);
            curr = root;
        }
    }
}
