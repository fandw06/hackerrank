package datastructure.swap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Dawei on 10/16/2016.
 */
public class SwapQ {


    public static void printSum(int a[], int l, int r) {
        int sum = 0;
        for (int i = l-1; i <= r-1; i++)
            sum += a[i];
        System.out.println(sum);
    }

    public static void reorder(int a[], int l, int r) {
        for (int i = l-1; i<=r-1; i += 2) {
            swap(a, i);
        }
    }

    public static void swap(int a[], int l) {
        int temp = a[l];
        a[l] = a[l+1];
        a[l+1] = temp;
    }

    public static void main(String[] args) {
        //    Scanner scanner = new Scanner(System.in);
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("./testcase/swapnodes3.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int a[] = new int[n];
        for (int i = 0; i<n; i++)
            a[i] = scanner.nextInt();
        for (int i = 0; i< q; i++) {
            int cmd = scanner.nextInt();
            int op1 = scanner.nextInt();
            int op2 = scanner.nextInt();
            if (cmd == 1)
                reorder(a, op1, op2);
            else if (cmd == 2)
                printSum(a, op1, op2);
        }
    }
}
