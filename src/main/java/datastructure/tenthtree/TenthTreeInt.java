package datastructure.tenthtree;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Dawei on 10/15/2016.
 */
public class TenthTreeInt {

    public static void segment(int left, int right) {
        int level = -1;
        int steps = 0;
        int base = 1;
        int lastLevel = -1;
        int curr = left;
        while (curr <= right) {
            lastLevel = level;
            level = 0;
            base = 1;
            steps = 0;

            while ((curr-1) % nextBase(base) == 0 && (curr-1 + nextBase(base)) <= right) {
                level ++;
                base = nextBase(base);
            }
            while (curr-1 + base <=right &&
                    ((curr-1)%nextBase(base)!=0 && lastLevel < level || lastLevel > level)) {
                steps++;
                curr = curr + base;
            }
            System.out.println(level + " " + steps);
        }
    }
    public static int nextBase(int base) {
        if (base == 1)
            return 10;
        return base*base;
    }

    public static void main(String[] args) {
    //    Scanner scanner = new Scanner(System.in);
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("./testcase/tenthtree2.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String l = scanner.next();
        String r = scanner.next();
   //     segment(l, r);

        segment(42, 1024);

    }
}
