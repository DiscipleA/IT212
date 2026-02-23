public class Node {
    // Data stored in the node
    public Order data;

    // Pointer to the next node in the list
    public Node next;

    // Constructor to create a new Node
    public Node(Order data) {
        this.data = data;
        this.next = null; // Equivalent to None in Python
    }
}