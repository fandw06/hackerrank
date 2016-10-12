package javaintro.jumpwin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Dawei on 10/11/2016.
 */
public class JumpGameNR {

    public static boolean win(int a[], int m) {
        int n = a.length;
        if (m >=n)
            return true;

        boolean re[] = new boolean[n];
        re[0] = true;
        for (int j = 1; j< n; j++) {
            if (a[j] != 0)
                continue;
            if (re[j-1]) {
                re[j] = true;
                if (j+m>=n || j+1>=n)
                    return true;
                continue;
            }
            int jj = j;
            while (jj < n && a[jj] == 0) {
                if (jj>=m && re[jj - m]){
                    re[j] = true;
                    break;
                }
                jj++;
            }
            if (re[j] && (j+m>=n || j+1>=n))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

        int a[] = {0, 1, 1, 0, 0, 1, 1, 0, 1};
        int m = 4;
        System.out.println(win(a, m));
        System.out.println(win(new int[]{0, 0, 0, 0, 0}, 0));

        /*
        Scanner scanner = null;
        Scanner reader = null;
        try {
            scanner = new Scanner(new File("jumpwin-input04.txt"));
            reader = new Scanner(new File("jumpwin-output04.txt"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int num = scanner.nextInt();
        for (int i = 0; i< num; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int a[] = new int[n];
            for (int j = 0; j< n; j++) {
                a[j] = scanner.nextInt();
            }

            String res = win(a, m)?"YES":"NO";
            String s = reader.next();
            if (!res.equals(s)) {
                System.out.println(i);
                System.out.println(Arrays.toString(a));
                System.out.println(m);
                System.out.println(s);
            }
        }
        */

    }
}
