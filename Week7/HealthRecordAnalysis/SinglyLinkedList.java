public class SinglyLinkedList {
    Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Print list values from head to null (traversal)
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Convenience helper for quickly building lists (useful for Main + tests)
    public static SinglyLinkedList fromArray(int[] values) {
        SinglyLinkedList list = new SinglyLinkedList();

        if (values == null) {
            return list;
        }

        for (int v : values) {
            list.append(v);
        }
        return list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SinglyLinkedList[");
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        sb.append(']');
        return sb.toString();
    }
}