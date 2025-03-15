class LinkedList {
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

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public LinkedList addAtTail(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
        return this;
    }

    public static LinkedList add2Numbers(Node l1, Node l2) {
        int carryForward = 0;
        LinkedList results = new LinkedList();
        while (l1 != null || l2 != null || carryForward != 0) {
            int l1Value = (l1 != null) ? l1.value : 0;
            int l2Value = (l2 != null) ? l2.value : 0;
            int sum = l1Value + l2Value + carryForward;
            int nodeValueInResult = sum % 10;
            results.addAtTail(nodeValueInResult);
            carryForward = sum / 10;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return results;
    }
}
