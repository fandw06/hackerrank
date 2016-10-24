package datastructure.castle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Dawei on 10/20/2016.
 */
public class BFS {

    public static int bfs(char[][] m, int br, int bc, int er, int ec) {
        int l = m.length;
        int[][] step = new int[l][l];
        for (int i = 0; i< l; i++) {
            step[i] = new int[l];
            Arrays.fill(step[i], -1);
        }
        //r*l+c
        Queue<Integer> queue = new LinkedList<>();
        step[er][ec] = 0;
        queue.add(er*l + ec);
        while(!queue.isEmpty()) {
            int curr = queue.remove();
            int crow = curr/l;
            int ccol = curr%l;
            int tcr = crow - 1;
            while (tcr >= 0 && tcr <l && m[tcr][ccol]!='X') {
                if (step[tcr][ccol] == -1) {
                    queue.add(tcr * l + ccol);
                    step[tcr][ccol] = step[crow][ccol] + 1;
                    if (tcr == br && ccol == bc)
                        return step[tcr][ccol];
                }
                tcr--;
            }
            tcr = crow + 1;
            while (tcr >= 0 && tcr <l && m[tcr][ccol]!='X') {
                if (step[tcr][ccol] == -1) {
                    queue.add(tcr * l + ccol);
                    step[tcr][ccol] = step[crow][ccol] + 1;
                    if (tcr == br && ccol == bc)
                        return step[tcr][ccol];
                }
                tcr++;
            }
            int tcc = ccol -1;
            while (tcc >= 0 && tcc <l && m[crow][tcc]!='X') {
                if (step[crow][tcc] == -1) {
                    queue.add(crow * l + tcc);
                    step[crow][tcc] = step[crow][ccol] + 1;
                    if (crow == br && tcc == bc)
                        return step[crow][tcc];
                }
                tcc--;
            }
            tcc = ccol +1;
            while (tcc >= 0 && tcc <l && m[crow][tcc]!='X') {
                if (step[crow][tcc] == -1) {
                    queue.add(crow * l + tcc);
                    step[crow][tcc] = step[crow][ccol] + 1;
                    if (crow == br && tcc == bc)
                        return step[crow][tcc];
                }
                tcc++;
            }
        }

        //print table
        for (int i = 0; i<l; i++)
            System.out.println(Arrays.toString(step[i]));
        return step[br][bc];
    }


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        //    Scanner scanner = new Scanner(System.in);
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("./testcase/castle2.txt"));
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
        System.out.println(bfs(matrix, br, bc, er, ec));
    }
}
