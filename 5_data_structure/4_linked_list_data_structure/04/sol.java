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

    public LinkedList() {
        this.head = null;
    }

    public Node checkLoop(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node hare = head;
        Node tortoise = head;

        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;

            if (hare == tortoise) {
                break;
            }
        }

        if (hare != tortoise) {
            return null;
        }

        Node pointer = head;
        while (pointer != tortoise) {
            pointer = pointer.next;
            tortoise = tortoise.next;
        }

        return tortoise;
    }

    public void createList() {
        head = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);

        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;

        // Create a loop for testing
        six.next = three;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.createList();
        Node loopNode = list.checkLoop(list.head);
        if (loopNode != null) {
            System.out.println("Loop detected at node with value: " + loopNode.value);
        } else {
            System.out.println("No loop detected");
        }
    }
}
