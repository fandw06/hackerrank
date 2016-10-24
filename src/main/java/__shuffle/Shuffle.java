package __shuffle;

import java.util.Arrays;

/**
 * Created by Dawei on 10/5/2016.
 */
public class Shuffle {

    public static void shuffle(int value[]) {
        for (int i = value.length-1; i > 0; i--) {
            int temp = value[i];
            int r = (int) Math.random() * (i+1);
            value[i] = value[r];
            value[r] = temp;
        }
    }
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7};
        shuffle(nums);
        System.out.println(Arrays.toString(nums));
    }
}
