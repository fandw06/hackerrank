package datastructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Dawei on 10/18/2016.
 */
public class TruckTour {


    public static int tour(int p[], int d[]) {
        int min = 0;
        int index = 0;
        int remain = 0;
        for (int i = 1; i<= p.length; i++) {
            int curr = remain + p[i-1] - d[i-1];
            if (curr < min) {
                min = curr;
                index = i;
            }
            remain = curr;
        }
        return index;
    }

    public static void main(String[] args) {
    //    Scanner scanner = new Scanner(System.in);
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("./testcase/truck1.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int n = scanner.nextInt();
        int p[] = new int[n];
        int d[] = new int[n];
        for (int i = 0; i< n; i++) {
            p[i] = scanner.nextInt();
            d[i] = scanner.nextInt();
        }
        System.out.println(tour(p, d));
    }
}
