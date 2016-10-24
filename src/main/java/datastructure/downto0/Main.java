package datastructure.downto0;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Dawei on 10/20/2016.
 */
public class Main {


    public static void testTreeSetq2(int a[]) {
        long tb = System.currentTimeMillis();
        for (int i = 0; i<a.length; i++)
            TreeSetq2.bfs(a[i]);
        long te = System.currentTimeMillis();
        System.out.println(te-tb);
    }
    public static void testTreeSetq(int a[]) {
        long tb = System.currentTimeMillis();
        for (int i = 0; i<a.length; i++)
            TreeSetq.bfs(a[i]);
        long te = System.currentTimeMillis();
        System.out.println(te-tb);
    }
    public static void testSetq(int a[]) {
        long tb = System.currentTimeMillis();
        for (int i = 0; i<a.length; i++)
            Setq.bfs(a[i]);
        long te = System.currentTimeMillis();
        System.out.println(te-tb);
    }
    public static void testBFS(int a[]) {
        long tb = System.currentTimeMillis();
        for (int i = 0; i<a.length; i++)
            BFS.bfs(a[i]);
        long te = System.currentTimeMillis();
        System.out.println(te-tb);
    }

    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("./testcase/downzero1.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int n = scanner.nextInt();
        int a[] = new int[n];
        for (int i = 0; i<n; i++) {
            a[i] = scanner.nextInt();
        }
        //21913. 13715 with step 5
        testTreeSetq2(a);
        //44988
    //    testTreeSetq(a);
        //54372
    //    testSetq(a);
        //43201
    //    testBFS(a);

    }
}
