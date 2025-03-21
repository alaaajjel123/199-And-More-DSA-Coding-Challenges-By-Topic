class LinkedList {
    class Node {
        Object val;
        Node next;
        
        Node(Object value) {
            this.val = value;
            this.next = null;
        }
    }

    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void removeDupes() {
        Node curr = head;
        while (curr != null) {
            Node nextDistinctVal = curr.next;
            while (nextDistinctVal != null && curr.val.equals(nextDistinctVal.val)) {
                nextDistinctVal = nextDistinctVal.next;
            }
            curr.next = nextDistinctVal;
            curr = nextDistinctVal;
        }
    }

    public void createList() {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node("a");
        head.next.next.next.next.next = new Node("a");
    }

    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.createList();
        list.removeDupes();
        list.printList();
    }
}
