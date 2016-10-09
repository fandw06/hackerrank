package CrackingInterview;

/**
 * Created by Dawei on 10/8/2016.
 */
public class Region {

    public static int region(int m[][]) {
        int l = m[0].length;
        int h = m.length;
        int max = 0;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j< h; j++) {
                max = Math.max(max, dfs(m, j, i));
            }
        }
        return max;
    }

    public static int dfs(int m[][], int s0, int s1) {
        if (s0 < 0 || s0 >=m.length || s1 < 0 || s1 >= m[0].length || m[s0][s1] == 0 || m[s0][s1] > 1)
            return 0;
        m[s0][s1] += 2;
        int max = 0;
        max = Math.max(max, dfs(m, s0-1, s1-1));
        max = Math.max(max, dfs(m, s0-1, s1));
        max = Math.max(max, dfs(m, s0-1, s1+1));
        max = Math.max(max, dfs(m, s0, s1-1));
        max = Math.max(max, dfs(m, s0, s1+1));
        max = Math.max(max, dfs(m, s0+1, s1-1));
        max = Math.max(max, dfs(m, s0+1, s1));
        max = Math.max(max, dfs(m, s0+1, s1+1));
        m[s0][s1] -=2;
        return max + 1;
    }

    public static void main(String[] args) {
        int m[][] = {
                {1, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 0}
        };
        int num = region(m);
        System.out.println(num);
    }
}
