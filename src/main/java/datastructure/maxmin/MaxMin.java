package datastructure.maxmin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Dawei on 10/18/2016.
 */

/**
 * 这里的问题是Heap的删除并不是logd，而是d+logd，因为首先进行了搜索。
 */
public class MaxMin {
    static class Heap {

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
            if (index < array.size())
                filter(index);
        }

        public int size() {
            return array.size();
        }
    }

    public static int minMax(int a[], int d) {
        int min = Integer.MAX_VALUE;
        Heap heap = new Heap((e1, e2)->e2-e1);
        for (int i = 0; i<d && i<a.length; i++) {
            heap.insert(a[i]);
        }
        min = Math.min(min, heap.peek());
        for (int i = d; i <a.length; i++) {
            heap.removeValue(a[i-d]);
            heap.insert(a[i]);
            min = Math.min(min, heap.peek());
        }
        return min;
    }

    public static void main(String[] args) {
     //   Scanner scanner = new Scanner(System.in);

        Scanner scanner = null;
        Scanner scanner2 = null;
        try {
            scanner = new Scanner(new File("./testcase/maxmin2.txt"));
            scanner2 = new Scanner(new File("./testcase/maxmin2o.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int a[] = new int[n];
        for (int i = 0; i< n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i<q; i++) {
            int res = minMax(a, scanner.nextInt());
        //    if (res != scanner2.nextInt())
                System.out.println("Index: " + i + " " + res);
        }
    }
}
