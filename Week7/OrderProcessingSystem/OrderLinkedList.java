public class OrderLinkedList {
    // The entry point to the list (first node)
    private Node head;
    private Node tail;

    // Constructor initializes an empty list
    public OrderLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // append(order): Add a new order to the end of the list
    public void append(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("order cannot be null");
        }
        // Create a new node for this order
        Node newNode = new Node(order);

        // If list is empty, newNode becomes the head
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    // display(): Print the list from head to null
    public void display() {
        System.out.println(toDisplayString());
    }

    // Helper method to return the list as a string (useful for testing)
    public String toDisplayString() {
        String result = "";
        Node current = head;

        while (current != null) {
            result = result + current.data.toString() + "\n";
            current = current.next;
        }

        result = result + "null";
        return result;
    }

    // reverse(): Reverse the list in-place (O(N) time, O(1) space)
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node oldHead = head; // Keep track of old head to update tail later

        // Walk through the list and flip links one by one
        while (current != null) {
            Node nextTemp = current.next; // store next
            current.next = prev;          // reverse pointer
            prev = current;               // move prev forward
            current = nextTemp;           // move current forward
        }

        // After loop, prev is the new head
        head = prev;
        tail = oldHead; // old head is now the tail
    }
}