package datastructure.downto0;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Dawei on 10/19/2016.
 */
public class DP {

    public static int[] buildArray(int m) {
        int res[] = new int[m+1];
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i<=m; i++) {
            res[i] = res[i-1] + 1;
            for (int k = i-1; k>= Math.sqrt(i); k--) {
                if (i%k == 0) {
                    res[i] = Math.min(res[i], 1+res[k]);
                }
            }
        }
        return res;
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
        int max = 0;
        for (int i = 0; i<n; i++) {
            a[i] = scanner.nextInt();
            if (a[i] > max)
                max = a[i];
        }
        int res[] = buildArray(max);
        /*
        for (int i = 0; i<res.length; i++) {
            if (res[i] == 6)
                System.out.print(i + ", ");
        }*/


        try {
            FileWriter fw = new FileWriter(new File("dzc.txt"));
            fw.append("{");
            for (int i = 0; i<res.length; i++)
                fw.append(i + ", ");
            fw.append("}");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
 //       System.out.println(Arrays.toString(res));

        /*
        for (int i = 0; i<n; i++)
            System.out.println(res[a[i]]);
            */
    }
}
