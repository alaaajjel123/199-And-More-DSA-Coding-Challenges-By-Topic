public class StackLinkedList {
    class Node {
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

    public StackLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public StackLinkedList addAtBeginning(int value) {
        Node node = new Node(value);
        if (first == null) {
            first = node;
            last = node;
        } else {
            Node temp = first;
            first = node;
            first.next = temp;
        }
        size++;
        return this;
    }

    public Integer removeFromBeginning() {
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
