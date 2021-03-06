package __heap;

import java.util.ArrayList;
import java.util.Comparator;
/**
 * Min heap
 */
public class Heap {

    ArrayList<Integer> array;
    Comparator<Long> comparator;

    public Heap(Comparator<Long> comparator) {
        array = new ArrayList<>();
        this.comparator = comparator;
    }

    public void insert(int num) {
        array.add(num);
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
