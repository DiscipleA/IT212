public class Node {
    public PatientRecord data;
    public Node next;
    public Node prev;

    public Node(PatientRecord data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}