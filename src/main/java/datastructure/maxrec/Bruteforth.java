package datastructure.maxrec;

/**
 * Created by Dawei on 10/13/2016.
 */
public class Bruteforth {
    public static int max(int a[], int b, int e) {
        int max = 0;
        for (int i = 0; i<a.length; i++) {
            int min = a[i];
            for (int j = i; j<a.length; j++) {
                if (a[j] < min)
                    min = a[j];
                int area = min * (j-i+1);
                if (area > max)
                    max = area;

            }
        }
        return max;
    }
}
