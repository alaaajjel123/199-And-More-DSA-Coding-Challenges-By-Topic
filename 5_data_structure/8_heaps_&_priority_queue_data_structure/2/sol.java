import java.util.ArrayList;
import java.util.List;

class Node {
    String value;
    int priority;

    public Node(String value, int priority) {
        this.value = value;
        this.priority = priority;
    }
}

public class PriorityQueue {
    private List<Node> data;

    public PriorityQueue() {
        data = new ArrayList<>();
    }

    public PriorityQueue enqueue(String value, int priority) {
        Node node = new Node(value, priority);
        data.add(node);
        bubbleUp();
        return this;
    }

    private void bubbleUp() {
        int idx = data.size() - 1;
        Node element = data.get(idx);
        while (idx > 0) {
            int parentIdx = (idx - 1) / 2;
            Node parent = data.get(parentIdx);
            if (element.priority >= parent.priority) {
                break;
            }
            data.set(idx, parent);
            data.set(parentIdx, element);
            idx = parentIdx;
        }
    }

    public Node dequeue() {
        if (data.isEmpty()) return null;
        Node minElement = data.get(0);
        Node last = data.remove(data.size() - 1);
        if (!data.isEmpty()) {
            data.set(0, last);
            bubbleDown();
        }
        return minElement;
    }

    private void bubbleDown() {
        int idx = 0;
        int length = data.size();
        Node element = data.get(0);
        while (true) {
            int leftChildIdx = 2 * idx + 1;
            int rightChildIdx = 2 * idx + 2;
            Node leftChild = null, rightChild = null;
            Integer smallest = null;
            if (leftChildIdx < length) {
                leftChild = data.get(leftChildIdx);
                if (leftChild.priority < element.priority) {
                    smallest = leftChildIdx;
                }
            }
            if (rightChildIdx < length) {
                rightChild = data.get(rightChildIdx);
                if ((smallest == null && rightChild.priority < element.priority) || 
                    (smallest != null && rightChild.priority < leftChild.priority)) {
                    smallest = rightChildIdx;
                }
            }
            if (smallest == null) {
                break;
            }
            data.set(idx, data.get(smallest));
            data.set(smallest, element);
            idx = smallest;
        }
    }
}
