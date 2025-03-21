class SinglyLinkedList {
    class Node {
        int value;
        Node next;
        
        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public void addAtHead(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public void addAtTail(int value) {
        Node node = new Node(value);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public String addAtIndex(int index, int value) {
        if (index < 0 || index > size) {
            return "invalid index";
        }
        if (index == size) {
            addAtTail(value);
            return null;
        }
        if (index == 0) {
            addAtHead(value);
            return null;
        }
        Node node = new Node(value);
        Node prev = getNodeAtIndex(index - 1);
        Node temp = prev.next;
        prev.next = node;
        node.next = temp;
        size++;
        return null;
    }

    public String deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return "invalid index";
        }
        if (index == 0) {
            Node temp = head;
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
            return String.valueOf(temp.value);
        }
        if (index == size - 1) {
            Node oldTail = tail;
            Node newTail = getNodeAtIndex(index - 1);
            tail = newTail;
            newTail.next = null;
            size--;
            return String.valueOf(oldTail.value);
        }
        Node prev = getNodeAtIndex(index - 1);
        Node deletedNode = prev.next;
        prev.next = deletedNode.next;
        size--;
        return String.valueOf(deletedNode.value);
    }

    private Node getNodeAtIndex(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}
