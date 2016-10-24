package datastructure.poison;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Dawei on 10/15/2016.
 */
public class StackP {
    public static int days(int a[]) {
        Stack<Integer> stack = new Stack<>();
        int days = 0;
        for (int i = a.length-1; i>= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(a[i]);
            }
            else {
                int d = 0;
                while (!stack.isEmpty() && a[i] < stack.peek()) {
                    stack.pop();
                    d++;
                }
                stack.push(a[i]);
                if (d > days)
                    days = d;
            }

        }
        System.out.println(stack);
        return days;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        /*
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("./testcase/poison1.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        */
        int n = scanner.nextInt();
        int a[] = new int[n];
        for (int i = 0; i< n; i++) {
            a[i] = scanner.nextInt();

        }
        System.out.println(days(a));

    }
}
