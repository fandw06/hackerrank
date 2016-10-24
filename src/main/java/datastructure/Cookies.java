package datastructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Dawei on 10/14/2016.
 */

/**
 * heap两次remove出现问题，第一次remove之后，序号已经变了。可以考虑写个函数一次删除两个，也可以删除数值。
 */
public class Cookies {
    static class HeapQ {
        ArrayList<Integer> array;
        Comparator<Integer> comparator;

        public HeapQ(Comparator<Integer> comparator) {
            array = new ArrayList<>();
            this.comparator = comparator;
        }

        public void insert(int num) {
            array.add(num);
            filterUp(array.size() - 1);
        }

        private void filter(int pos) {
            if (pos > 0 && comparator.compare(array.get(pos), array.get((pos-1)/2)) < 0)
                filterUp(pos);
            else
                filterDown(pos);
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

        public void remove(int index) {
            if (index < 0 || index >= array.size())
                return;
            array.set(index, array.get(array.size() -1));
            array.remove(array.size() -1);
            if (index < array.size() -1)
                filter(index);
        }

        public void removeValue(int v) {
            int index = -1;
            for (int i = 0; i< array.size(); i++) {
                if (array.get(i) == v) {
                    index = i;
                    break;
                }
            }
            if (index >= 0 )
                remove(index);
        }

        public int size() {
            return array.size();
        }

    }

    public static int steps(int a[], int m) {
        HeapQ heap = new HeapQ((e1, e2) -> e1 - e2);
        for (int i = 0; i< a.length; i++)
            heap.insert(a[i]);
        int steps = 0;
        while (heap.peek() < m) {
            if (heap.size() == 1) {
                System.out.println(heap.peek());
                return -1;
            }
            else if (heap.size() == 2) {
                if (heap.array.get(0) + 2*heap.array.get(1) >= m)
                    return steps++;
                else
                    return -1;
            }
            if (heap.peek() == 0 && (heap.array.get(1) == 0||heap.array.get(2) == 0)){
                System.out.println(heap.array);
                System.out.println(heap.peek());
                return -1;
            }
            if (heap.array.get(1) < heap.array.get(2)) {
                int second = heap.array.get(1);
                int sweet = heap.peek() + 2* second;
                heap.remove(0);
                heap.removeValue(second);
                heap.insert(sweet);
                steps++;
            }
            else {
                int second = heap.array.get(2);
                int sweet = heap.peek() + 2* second;
                heap.remove(0);
                heap.removeValue(second);
                heap.insert(sweet);
                steps++;
            }

        }
        return steps;
    }

    public static void main(String[] args) {
        //      Scanner scanner = new Scanner(System.in);
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("cookie2.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a[] = new int[n];
        for (int i = 0; i<n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(steps(a, m));
    }
}
