import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public Node getHead() { return head; }
    public Node getTail() { return tail; }
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void insertAtEnd(PatientRecord data) {
        if (data == null) {
            throw new IllegalArgumentException("PatientRecord cannot be null");
        }

        Node new_node = new Node(data);

        if (tail == null) {
            head = new_node;
            tail = new_node;
            size++;
            return;
        }

        new_node.prev = tail;
        tail.next = new_node;
        tail = new_node;
        size++;
    }

    public List<PatientRecord> traverseForward() {
        List<PatientRecord> out = new ArrayList<>();
        Node current = head;

        while (current != null) {
            out.add(current.data);
            current = current.next;
        }

        return out;
    }

    public List<PatientRecord> traverseBackward() {
        List<PatientRecord> out = new ArrayList<>();
        Node current = tail;

        while (current != null) {
            out.add(current.data);
            current = current.prev;
        }

        return out;
    }

    public boolean searchBySsn(String targetSsn) {
        Node current = head;

        while (current != null) {
            if (current.data.getSsn().equals(targetSsn)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public boolean updateFirstBySsn(String targetSsn, int newAge, String newFullName) {
        Node current = head;

        while (current != null) {
            if (current.data.getSsn().equals(targetSsn)) {
                current.data.setAge(newAge);
                current.data.setFullName(newFullName);
                return true;
            }
            current = current.next;
        }

        return false;
    }

    // -------- Assignment core: merge two sorted DLLs by SSN (keeps duplicates) --------
    // Time: O(n+m), Extra space: O(1) (reuses nodes, just rewires pointers)
    public static DoublyLinkedList mergeSorted(DoublyLinkedList listA, DoublyLinkedList listB) {
        if (listA == null || listA.head == null) {
            return (listB == null) ? new DoublyLinkedList() : listB;
        }
        if (listB == null || listB.head == null) {
            return listA;
        }

        Node a = listA.head;
        Node b = listB.head;

        DoublyLinkedList merged = new DoublyLinkedList();
        Node mergedHead = null;
        Node mergedTail = null;

        while (a != null && b != null) {
            if (a.data.compareTo(b.data) <= 0) {
                Node nextA = a.next;
                a.prev = null;
                a.next = null;

                if (mergedHead == null) {
                    mergedHead = a;
                    mergedTail = a;
                } else {
                    a.prev = mergedTail;
                    mergedTail.next = a;
                    mergedTail = a;
                }

                a = nextA;
            } else {
                Node nextB = b.next;
                b.prev = null;
                b.next = null;

                if (mergedHead == null) {
                    mergedHead = b;
                    mergedTail = b;
                } else {
                    b.prev = mergedTail;
                    mergedTail.next = b;
                    mergedTail = b;
                }

                b = nextB;
            }
        }

        while (a != null) {
            Node nextA = a.next;
            a.prev = null;
            a.next = null;

            if (mergedHead == null) {
                mergedHead = a;
                mergedTail = a;
            } else {
                a.prev = mergedTail;
                mergedTail.next = a;
                mergedTail = a;
            }

            a = nextA;
        }

        while (b != null) {
            Node nextB = b.next;
            b.prev = null;
            b.next = null;

            if (mergedHead == null) {
                mergedHead = b;
                mergedTail = b;
            } else {
                b.prev = mergedTail;
                mergedTail.next = b;
                mergedTail = b;
            }

            b = nextB;
        }

        merged.head = mergedHead;
        merged.tail = mergedTail;

        if (merged.head != null) merged.head.prev = null;
        if (merged.tail != null) merged.tail.next = null;

        merged.size = listA.size + listB.size;

        // optional safety: clear original lists (prevents accidental reuse)
        listA.head = null; listA.tail = null; listA.size = 0;
        listB.head = null; listB.tail = null; listB.size = 0;

        return merged;
    }

    // Helpers (useful for debugging + tests)
    public boolean isSortedBySsn() {
        Node current = head;
        while (current != null && current.next != null) {
            if (current.data.compareTo(current.next.data) > 0) return false;
            current = current.next;
        }
        return true;
    }

    public boolean hasValidBidirectionalLinks() {
        Node current = head;
        Node prevSeen = null;

        while (current != null) {
            if (current.prev != prevSeen) return false;
            prevSeen = current;
            current = current.next;
        }

        if (prevSeen != tail) return false;

        current = tail;
        Node nextSeen = null;

        while (current != null) {
            if (current.next != nextSeen) return false;
            nextSeen = current;
            current = current.prev;
        }

        return nextSeen == head;
    }
}