package datastructure.castle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Dawei on 10/13/2016.
 */

/**
 * 这种递归是DFS，不能解决最短路径问题。
 */
public class DFS {

    public static boolean dfs(char[][] m, int br, int bc, int er, int ec, List<int[]> trace) {
        if (br == er && bc == ec) {
            trace.add(new int[]{er, ec});
            System.out.println("Steps: " + countSteps(trace));
            for (int i = 0; i< trace.size(); i++) {
                System.out.print(Arrays.toString(trace.get(i)) + " ");
            }
            System.out.println();
            return true;
        }
        if (br < 0 || br >= m.length || bc <0 || bc >=m.length || m[br][bc] == 'X' || ((byte)m[br][bc] & 0x80) != 0)
            return false;
        m[br][bc] |= 0x80;
        trace.add(new int[] {br, bc});
        boolean is = false;
        is |= dfs(m, br+1, bc, er, ec, new ArrayList(trace));
        is |= dfs(m, br-1, bc, er, ec, new ArrayList(trace));
        is |= dfs(m, br, bc+1, er, ec, new ArrayList(trace));
        is |= dfs(m, br, bc-1, er, ec, new ArrayList(trace));
        m[br][bc] &= 0x7f;
        return is;
    }

    public static int countSteps(List<int[]> trace) {
        if (trace.size() <=1)
            return trace.size();
        int steps = 1;
        for (int i = 2; i< trace.size(); i++) {
            if ((trace.get(i)[0] != trace.get(i-2)[0])&&(trace.get(i)[1] != trace.get(i-2)[1]))
                steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    //    Scanner scanner = new Scanner(System.in);
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("castle3.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int n = scanner.nextInt();
        char matrix[][] = new char[n][n];
        for (int i = 0; i< n; i++) {
            matrix[i] = scanner.next().toCharArray();
        }
        int br = scanner.nextInt();
        int bc = scanner.nextInt();
        int er = scanner.nextInt();
        int ec = scanner.nextInt();
        System.out.println(dfs(matrix, br, bc, er, ec, new ArrayList<int[]>()));
    }
}
