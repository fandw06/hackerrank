package datastructure.poison;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Dawei on 10/15/2016.
 */
public class Loop {
    public static int days(int a[]) {
        List<Integer> list = new ArrayList();
        for (int i : a)
            list.add(i);
        int days = 0;
        boolean die = true;
        do {
            die = false;
            for (int i = list.size() -1; i>=1; i--) {
                if (list.get(i) > list.get(i-1)) {
                    die = true;
                    list.remove(i);
                }
            }
            if (die)
                days++;
        } while(die);

        return days;



    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = new int[n];
        for (int i = 0; i< n; i++) {
            a[i] = scanner.nextInt();

        }
        System.out.println(days(a));

    }
}
