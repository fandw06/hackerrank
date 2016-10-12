package __heap;


/**
 * Created by Dawei on 10/7/2016.
 */
public class Main {

    public static void main(String[] args) {
        // (e1, e2) -> e1-e2 : minHeap;
        // (e1, e2) -> e2-e1 : maxHeap;
        Heap heap = new Heap((e1, e2) -> e2 - e1);
        heap.insert(5);
        System.out.println(heap.array);
        heap.insert(4);
        System.out.println(heap.array);
        heap.insert(6);
        System.out.println(heap.array);
        heap.insert(9);
        System.out.println(heap.array);
        heap.insert(1);
        System.out.println(heap.array);
        heap.insert(2);
        System.out.println(heap.array);
        heap.insert(3);
        System.out.println(heap.array);
        heap.pop();
        System.out.println(heap.array);
    }
}
