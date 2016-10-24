package CrackingInterview;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Dawei on 10/6/2016.
 */
public class TwoStack {

    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();
        T head;
        public void enqueue(T value) { // Push onto newest stack
            if (stackNewestOnTop.isEmpty() && stackOldestOnTop.isEmpty()) {
                head = value;
            }
            stackNewestOnTop.push(value);
        }

        public T peek() {
            return head;
        }

        public T dequeue() {

            if (!stackNewestOnTop.isEmpty() && stackOldestOnTop.isEmpty()) {
                while (!stackNewestOnTop.isEmpty()) {
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }
            T result = stackOldestOnTop.pop();
            if (!stackOldestOnTop.isEmpty())
                head = stackOldestOnTop.peek();
            else{
                if (stackNewestOnTop.isEmpty())
                    head = null;
                else {
                    while (!stackNewestOnTop.isEmpty()) {
                        stackOldestOnTop.push(stackNewestOnTop.pop());
                    }
                    head = stackOldestOnTop.peek();
                }
            }
            return result;
        }
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("twostack2.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int q = scanner.nextInt();
        MyQueue<Integer> queue = new MyQueue();
        for (int i = 0; i<q; i++) {
            int cmd = scanner.nextInt();
            if (cmd == 1) {
                queue.enqueue(scanner.nextInt());
            }
            else if (cmd == 2) {
                queue.dequeue();
            }
            else if (cmd == 3)
                System.out.println(queue.peek());
        }
    }
}
