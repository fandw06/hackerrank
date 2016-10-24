package datastructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Dawei on 10/14/2016.
 */
public class HeapQ {
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

    public static void main(String[] args) {
        HeapQ heap = new HeapQ((e1, e2) -> e1-e2);
  //      Scanner scanner = new Scanner(System.in);
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("heapq2.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int q = scanner.nextInt();
        for (int i = 0; i<q; i++) {
            int cmd = scanner.nextInt();
            if (cmd == 1) {
                heap.insert(scanner.nextInt());
         //       System.out.println(heap.array);
            }
            else if (cmd == 2) {
                heap.removeValue(scanner.nextInt());
          //      System.out.println(heap.array);
            }
            else if (cmd == 3) {
                System.out.println(heap.peek());
            }
        }
    }
}
