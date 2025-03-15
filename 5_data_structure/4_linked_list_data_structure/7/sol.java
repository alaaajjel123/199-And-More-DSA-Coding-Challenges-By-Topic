class DoublyLinkedList {
    class Node {
        int val;
        Node next;
        Node prev;

        Node(int value) {
            this.val = value;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void linkNodes(Node node1, Node node2) {
        node1.next = node2;
        node2.prev = node1;
    }

    public void remove(Node node) {
        if (head == node) {
            head = node.next;
        }
        if (tail == node) {
            tail = node.prev;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }

        node.next = null;
        node.prev = null;
    }
}
