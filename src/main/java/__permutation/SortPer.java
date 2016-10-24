package __permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dawei on 10/24/2016.
 */
public class SortPer {

    public static List<int[]> getAll(int n) {
        List<int[]> list = new ArrayList<>();
        int last[] = new int[n];
        for (int i = 0; i<n; i++) {
            last[i] = i+1;
        }
        list.add(last);
        while (true) {
            int curr[] = Arrays.copyOf(last, last.length);
            int first = 0;
            int second = -1;
            for (int i = n-2; i>=0; i--) {
                if (curr[i] < curr[i+1]) {
                    first = i;
                    break;
                }
            }
            int min = Integer.MAX_VALUE;
            for (int i = first + 1; i<n; i++) {
                if (curr[i] > curr[first] && curr[i] < min) {
                    second = i;
                    min = curr[i];
                }
            }
            if (second == -1)
                break;

            int temp = curr[first];
            curr[first] = curr[second];
            curr[second] = temp;
            Arrays.sort(curr, first+1, curr.length);
            list.add(curr);
            last = curr;
        }
        return list;
    }

    public static int[] getNext(int[] curr) {
        int n = curr.length;
        int first = -1;
        for (int i = n-2; i>=0; i--) {
            if (curr[i] < curr[i+1]) {
                first = i;
                break;
            }
        }
        int second = first + 1;
        int min = Integer.MAX_VALUE;
        for (int i = first + 1; i<n; i++) {
            if (curr[i] > curr[first] && curr[i] <min) {
                min = curr[i];
                second = i;
            }
        }
        int temp = curr[first];
        curr[first] = curr[second];
        curr[second] = temp;
        Arrays.sort(curr, first + 1, n);
        return curr;
    }

    public static void main(String[] args) {
        List<int[]> list = getAll(5);
        for (int[] l : list) {
            System.out.println(Arrays.toString(l));
        }
        int curr[] = {1, 2, 5, 4, 3};
        //[1, 3, 2, 4, 5]
        System.out.println(Arrays.toString(getNext(curr)));
    }
}
