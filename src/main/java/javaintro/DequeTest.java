package javaintro;

import java.util.*;

/**
 * Created by Dawei on 10/12/2016.
 */
public class DequeTest {
    /*
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        int max = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.addLast(num);
            if (deque.size() > m)
                deque.removeFirst();
            int curr = new HashSet<>(deque).size();
            if (max < curr) max = curr;
        }
        System.out.println(max);
    }
    */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        int max = 0;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.addLast(num);
            if (map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }
            else
                map.put(num, 1);
            if (deque.size() > m) {
                int rm = deque.removeFirst();
                int times = map.get(rm);
                if (times == 1)
                    map.remove(rm);
                else
                    map.put(rm, map.get(rm)-1);
            }
            int curr = map.size();
            if (max < curr) max = curr;
        }
        System.out.println(max);
    }
}
