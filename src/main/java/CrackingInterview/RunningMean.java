package CrackingInterview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Dawei on 10/6/2016.
 */
public class RunningMean {
    public static class Heap {

        ArrayList<Integer> array;
        Comparator<Integer> comparator;

        public Heap(Comparator<Integer> comparator) {
            array = new ArrayList<>();
            this.comparator = comparator;
        }

        public void insert(int num) {
            array.add(num);
            filterUp(array.size() - 1);
        }

        private void filterUp(int son) {
            while (son > 0 && comparator.compare(array.get(son), array.get((son-1)/2)) <0) {
                swap(son, (son-1)/2);
                son = (son-1)/2;
            }
        }

        private void filterDown(int parent) {
            int child;
            while (2*parent +1 < array.size()) {
                child = 2 * parent +1;
                if (child + 1 < array.size() && comparator.compare(array.get(child), array.get(child + 1)) > 0)
                    child++;
                if (comparator.compare(array.get(child), array.get(parent)) < 0) {
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
            array.remove(array.size() -1 );
            filterDown(0);
            return v;
        }

        public int size() {
            return array.size();
        }
    }

    public static Heap max = new Heap((e1, e2) -> e2 - e1);
    public static Heap min = new Heap((e1, e2) -> e1 - e2);

    public static double runningMean(int v) {

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
            return (double)(min.peek() + max.peek())/2.0;
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
            return (double)(min.peek() + max.peek())/2.0;
        }
    }

    public static void main(String[] args) {
        RunningMean rm = new RunningMean();
        double mean;
        mean = rm.runningMean(12);
        System.out.println(mean);
        mean = rm.runningMean(4);
        System.out.println(mean);
        mean = rm.runningMean(5);
        System.out.println(mean);
        mean = rm.runningMean(3);
        System.out.println(mean);
        mean = rm.runningMean(8);
        System.out.println(mean);
        mean = rm.runningMean(7);
        System.out.println(mean);
    }
}
