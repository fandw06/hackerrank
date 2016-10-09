package CrackingInterview;

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
}
