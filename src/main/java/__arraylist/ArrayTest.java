package __arraylist;

import java.util.ArrayList;

/**
 * Created by Dawei on 10/7/2016.
 */
public class ArrayTest {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(4);
        list.add(6);
        list.add(2);
        System.out.println(list);
        list.remove(Integer.valueOf(2));
        list.remove(2);
        System.out.println(list);
    }
}
