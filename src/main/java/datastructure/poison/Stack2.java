package datastructure.poison;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Dawei on 10/16/2016.
 */
public class Stack2 {
    public static int days(int a[]) {
        Stack<Integer> stack = new Stack<>();
        int days[] = new int[a.length];
        int maxDay = 0;
        int min = 0;
        for (int i = 1; i < a.length-1; i++) {
            if (a[i] > a[i-1])
                days[i] = 1;
            min = Math.min(min, a[i]);
            while (stack.isEmpty() && stack.peek() >= a[i]) {
                if (a[i] > min)
                    days[i] = Math.max(days[i], days[stack.peek()]+1);
                stack.pop();
            }
            maxDay = Math.max(maxDay, days[i]);
            stack.push(i);
        }
        return maxDay;
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
