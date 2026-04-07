import java.util.ArrayList;
import java.util.Scanner;

public class MinHeap {

    private ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    // ================== INSERT ==================
    public void insert(int val) {
        heap.add(val);               // add at the end
        heapifyUp(heap.size() - 1);  // restore heap property
    }

    // ================== EXTRACT MIN ==================
    public int extractMin() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Heap is empty!");
        }

        int min = heap.get(0);                    // minimum element
        int last = heap.remove(heap.size() - 1);  // remove last element

        if (!heap.isEmpty()) {
            heap.set(0, last);                    // move last to root
            heapifyDown(0);                       // restore heap property
        }
        return min;
    }

    // ================== HEAPIFY UP ==================
    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;

            if (heap.get(index) < heap.get(parent)) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    // ================== HEAPIFY DOWN ==================
    private void heapifyDown(int index) {
        int size = heap.size();

        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            // Check left child
            if (left < size && heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }
            // Check right child
            if (right < size && heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // ================== HELPER METHODS ==================
    public int peek() {
        if (heap.isEmpty()) throw new RuntimeException("Heap is empty!");
        return heap.get(0);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // ================== MAIN (with Scanner) ==================
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MinHeap minHeap = new MinHeap();

        System.out.print("How many numbers do you want to insert: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            minHeap.insert(sc.nextInt());
        }

        System.out.println("\nSmallest element (peek): " + minHeap.peek());

        System.out.print("How many times do you want to extract min? ");
        int extracts = sc.nextInt();

        System.out.print("Extracted minimums: ");
        for (int i = 0; i < extracts; i++) {
            if (!minHeap.isEmpty()) {
                System.out.print(minHeap.extractMin() + " ");
            } else {
                System.out.print("(empty) ");
                break;
            }
        }
        System.out.println();

        sc.close();
    }
}