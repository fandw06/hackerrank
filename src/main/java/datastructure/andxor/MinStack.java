package datastructure.andxor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Dawei on 10/16/2016.
 */
public class MinStack {

    public static int xor(int a[]) {
        int max = a[0] ^ a[1];
        Stack<Integer> stack = new Stack<>();
        stack.push(a[0]);
        for (int i = 1; i<a.length; i++) {
            if (!stack.isEmpty()) {
                int top = stack.peek();
                max = Math.max(max, (a[i] ^ top));
                while (!stack.isEmpty() && a[i] < stack.peek()) {
                    max = Math.max(max, (a[i] ^ stack.peek()));
                    stack.pop();
                }
                if (!stack.isEmpty())
                    max = Math.max(max, (a[i] ^ stack.peek()));
            }
            stack.push(a[i]);
        }
        return max;
    }

    public static void main(String[] args) {
    //    Scanner scanner = new Scanner(System.in);
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("./testcase/andxor1.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int n = scanner.nextInt();
        int a[] = new int[n];
        for (int i = 0; i< n; i++) {
            a[i] = scanner.nextInt();

        }
        System.out.println(xor(a));
    }
}
