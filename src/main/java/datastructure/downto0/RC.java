package datastructure.downto0;

import java.util.Scanner;

/**
 * Created by Dawei on 10/19/2016.
 */
public class RC {
    public static int rc(int m) {
        if (m == 1)
            return 1;
        if (m == 2)
            return 2;
        int result = rc(m-1)+1;
        for (int k = m-1; k>= Math.sqrt(m); k--) {
            if (m%k == 0) {
                result = Math.min(result, 1+rc(k));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("./testcase/truck1.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        */
        int n = scanner.nextInt();
        int a[] = new int[n];
        for (int i = 0; i<n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i<n; i++)
            System.out.println(rc(a[i]));
    }
}
