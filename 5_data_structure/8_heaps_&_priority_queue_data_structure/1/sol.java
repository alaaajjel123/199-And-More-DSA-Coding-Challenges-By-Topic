import java.util.ArrayList;
import java.util.List;

public class MaxBinaryHeap {

    private List<Integer> heap;

    public MaxBinaryHeap() {
        heap = new ArrayList<>();
    }

    public MaxBinaryHeap buildHeap(List<Integer> array) {
        int length = array.size();
        int lastParentIndex = length / 2 - 1;
        for (int i = lastParentIndex; i >= 0; i--) {
            bubbleDown(array, i);
        }
        heap = array;
        return this;
    }

    private void bubbleDown(List<Integer> array, int idx) {
        int length = array.size();
        int current = array.get(idx);
        while (true) {
            int leftChildIdx = 2 * idx + 1;
            int rightChildIdx = 2 * idx + 2;
            Integer largest = null;

            if (leftChildIdx < length) {
                int leftChild = array.get(leftChildIdx);
                if (leftChild > current) {
                    largest = leftChildIdx;
                }
            }

            if (rightChildIdx < length) {
                int rightChild = array.get(rightChildIdx);
                if (largest == null && rightChild > current || largest != null && rightChild > array.get(largest)) {
                    largest = rightChildIdx;
                }
            }

            if (largest == null) {
                break;
            } else {
                int temp = array.get(idx);
                array.set(idx, array.get(largest));
                array.set(largest, temp);
                idx = largest;
            }
        }
    }

    public int extractMax() {
        int maxValue = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (heap.size() > 0) {
            heap.set(0, last);
            bubbleDown(heap, 0);
        }
        return maxValue;
    }

    public MaxBinaryHeap insert(int value) {
        heap.add(value);
        bubbleUp();
        return this;
    }

    private void bubbleUp() {
        int idx = heap.size() - 1;
        int value = heap.get(idx);
        while (idx > 0) {
            int parentIdx = (idx - 1) / 2;
            int parentValue = heap.get(parentIdx);
            if (value <= parentValue) {
                break;
            }
            heap.set(parentIdx, value);
            heap.set(idx, parentValue);
            idx = parentIdx;
        }
    }

    public int peek() {
        return heap.get(0);
    }

    public static void main(String[] args) {
        MaxBinaryHeap heap = new MaxBinaryHeap();
        List<Integer> array = List.of(4, 7, 3, 0, 9, 3, 2, 6);
        heap.buildHeap(array);
    }
}
