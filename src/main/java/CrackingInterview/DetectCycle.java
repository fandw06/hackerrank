package CrackingInterview;

/**
 * Created by Dawei on 10/6/2016.
 */
public class DetectCycle {
    class Node {
        public int data;
        public Node next;
        Node(int data) {
            this.data = data;
        }
    }

    public static boolean hasCycle(Node head) {
        if (head.next == null)
            return false;
        Node first = head, second = head;
        while (first != null && second != null) {
            first = first.next;
            second = second.next;
            if (second == null)
                return false;
            else
                second = second.next;
            if (first == second)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
