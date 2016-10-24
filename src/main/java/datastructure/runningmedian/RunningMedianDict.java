package datastructure.runningmedian;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Dawei on 10/6/2016.
 */
public class RunningMedianDict {
    static class Heap {

        ArrayList<Integer> array;
        Comparator<Long> comparator;
        Map<Integer, Set<Integer>> map;

        public Heap(Comparator<Long> comparator) {
            array = new ArrayList<>();
            map = new HashMap<>();
            this.comparator = comparator;
        }

        public void insert(int num) {
            array.add(num);
            if (map.containsKey(num)) {
                map.get(num).add(array.size() - 1);
            }
            else {
                Set<Integer> set = new HashSet<>();
                set.add(array.size()-1);
                map.put(num, set);
            }

            filterUp(array.size() - 1);
        }

        private void filter(int pos) {
            if (pos > 0 && comparator.compare((long)array.get(pos), (long)array.get((pos-1)/2)) < 0)
                filterUp(pos);
            else
                filterDown(pos);
        }

        private void filterUp(int son) {
            while (son > 0 && comparator.compare((long)array.get(son), (long)array.get((son-1)/2)) <0) {
                map.get(array.get(son)).add((son-1)/2);
                map.get(array.get(son)).remove(son);

                map.get(array.get((son-1)/2)).add(son);
                map.get(array.get((son-1)/2)).remove((son-1)/2);
                swap(son, (son-1)/2);
                son = (son-1)/2;
            }
        }

        private void filterDown(int parent) {
            int child;
            while (2*parent +1 < array.size()) {
                child = 2 * parent +1;
                if (child + 1 < array.size() && comparator.compare((long)array.get(child), (long)array.get(child + 1)) > 0)
                    child++;
                if (comparator.compare((long)array.get(child), (long)array.get(parent)) < 0) {
                    map.get(array.get(child)).add(parent);
                    map.get(array.get(child)).remove(child);
                    map.get(array.get(parent)).add(child);
                    map.get(array.get(parent)).remove(parent);
                    swap(child, parent);
                    parent = child;
                }
                else
                    break;
            }
        }

        private void swap(int i, int j) {
            int temp = array.get(i);
            array.set(i, array.get(j));
            array.set(j, temp);
        }

        public int peek() {
            return array.get(0);
        }

        public int pop() {
            int v = array.get(0);
            array.set(0, array.get(array.size()-1));
            map.get(array.get(0)).add(0);
            map.get(array.get(0)).remove(array.size()-1);
            array.remove(array.size() -1);
            map.get(v).remove(0);
            if (map.get(v).size() == 0)
                map.remove(v);
            filterDown(0);
            return v;
        }

        public void remove(int index) {
            if (index < 0 || index >= array.size())
                return;
            if (index == array.size() -1) {

                map.get(array.get(index)).remove(index);
                if (map.get(array.get(index)).size() == 0)
                    map.remove(array.get(index));
                array.remove(array.size() -1);
            }
            else {
                map.get(array.get(index)).remove(index);
                if (map.get(array.get(index)).size() == 0)
                    map.remove(array.get(index));
                array.set(index, array.get(array.size() -1));
                map.get(array.get(index)).add(index);
                map.get(array.get(index)).remove(array.size()-1);
                array.remove(array.size() -1);
                filter(index);
            }
         }

        public void removeValue(int v) {
            remove(map.get(v).iterator().next());
        }

        public int size() {
            return array.size();
        }

        public boolean contains(int v) {
            return map.containsKey(v);
        }
    }

    public static Heap max = new Heap(new Comparator<Long>() {
        @Override
        public int compare(Long o1, Long o2) {
            if (o2-o1>0)
                return 1;
            else if (o2 - o1 <0)
                return -1;
            else
             return 0;
        }
    });
    public static Heap min = new Heap(new Comparator<Long>() {
        @Override
        public int compare(Long o1, Long o2) {
            if (o1-o2>0)
                return 1;
            else if (o1 - o2 <0)
                return -1;
            else
                return 0;
        }
    });
    public static final double NONE = 0.02;
    public static double add(int v) {

        // Add it into max or min
        if (max.size() == min.size()) {
            if (min.size() == 0 || v < min.peek()) {
                max.insert(v);
                return max.peek();
            }
            else {
                min.insert(v);
                return min.peek();
            }
        }
        // Insert it into min heap
        else if (max.size() > min.size()) {
            if (v < max.peek()) {
                int top = max.pop();
                min.insert(top);
                max.insert(v);
            }
            else
                min.insert(v);
            return (double)((long)min.peek() + (long)max.peek())/2.0;
        }
        // Insert it into max heap
        else {
            if (v > min.peek()) {
                int top = min.pop();
                max.insert(top);
                min.insert(v);
            }
            else
                max.insert(v);
            return (double)((long)min.peek() + (long)max.peek())/2.0;
        }
    }

    public static double remove(int v) {
        if (!max.contains(v) && !min.contains(v))
            return NONE;
        else if (max.contains(v)) {
            max.removeValue(v);
            if (max.size() == min.size()-1) {
                return min.peek();
            }
            else if (max.size() == min.size()) {
                if (max.size() == 0)
                    return NONE;
                return ((long)max.peek() + (long)min.peek())/2.0;
            }
            else {
                max.insert(min.pop());
                return ((long)max.peek() + (long)min.peek())/2.0;
            }
        }
        else if (min.contains(v)) {
            min.removeValue(v);
            if (max.size() == min.size()+1) {
                return max.peek();
            }
            else if (max.size() == min.size()) {
                if (max.size() == 0)
                    return NONE;
                return ((long)max.peek() + (long)min.peek())/2.0;
            }
            else {
                min.insert(max.pop());
                return ((long)max.peek() + (long)min.peek())/2.0;
            }
        }
        return -1;
    }

    public static void printResult(double d) {
        if (d == NONE)
            System.out.println("Wrong!");
        else {
            String s = String.format("%.1f", d);
            if (s.charAt(s.length()-1) == '0')
                System.out.println(s.substring(0, s.length()-2));
            else
                System.out.println(s);
        }
    }

    public static void main(String[] args) {
        RunningMedianDict rm = new RunningMedianDict();
    //    Scanner scanner = new Scanner(System.in);
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("./testcase/rm1.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int q = scanner.nextInt();
        for (int i = 0; i<q; i++) {
            String s = scanner.next();
            int op = scanner.nextInt();
            if (s.equals("a")) {
                double res = add(op);
                printResult(res);
            }
            else if (s.equals("r")) {
                double res = remove(op);
                printResult(res);
            }
        }

    }
}
