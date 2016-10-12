package CrackingInterview.icecream;

import java.util.*;

import static java.util.Arrays.sort;

/**
 * Created by Dawei on 10/7/2016.
 */
public class Icecream {

    public static class Pair{
        public int index;
        public int price;

        public Pair(int index, int price){
            this.index = index;
            this.price = price;
        }
    }
    public static int[] twoSum(int a[], int m) {
        Pair ar[] = new Pair[a.length];
        for (int i = 0; i< a.length; i++)
            ar[i] = new Pair(i + 1, a[i]);
        List<Pair> list = Arrays.asList(ar);
        Collections.sort(list, (p1, p2) -> p1.price - p2.price);
        for (int i = 0; i< a.length-1; i++) {
            int j = Collections.binarySearch(list.subList(i+1, list.size()), new Pair(-1, m-list.get(i).price), (p1, p2) -> p1.price - p2.price);
            if (j >= 0 ) {
                return new int[]{Math.min(list.get(i).index, list.get(j+i+1).index), Math.max(list.get(i).index, list.get(j+i+1).index)};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int a[] = {3, 2, 5, 7, 12};
        int m = 8;
        System.out.println(Arrays.toString(twoSum(a, m)));
    }

}
