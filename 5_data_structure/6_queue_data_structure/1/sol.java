public class QueueLinkedList {

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public QueueLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public void enqueue(int value) {
        Node node = new Node(value);
        if (first == null) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public Integer dequeue() {
        if (first == null) {
            return null;
        }
        Node temp = first;
        first = first.next;
        size--;
        if (size == 0) {
            last = null;
        }
        return temp.value;
    }
}
