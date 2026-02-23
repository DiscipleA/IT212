public class HealthRecordAnalyzer {

    // Required function name
    public static boolean isHealthRecordSymmetric(Node head) {
        // Empty list or single node list is always symmetric
        if (head == null || head.next == null) {
            return true;
        }

        // 1) Find the middle using slow/fast pointers
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;         // move 1 step
            fast = fast.next.next;    // move 2 steps
        }

        // If fast is not null, length is odd -> skip the exact middle node
        if (fast != null) {
            slow = slow.next;
        }

        // 2) Reverse the second half of the list
        Node secondHalfHead = reverseList(slow);

        // 3) Compare first half with reversed second half
        Node p1 = head;
        Node p2 = secondHalfHead;
        boolean isPalindrome = true;

        while (p2 != null) { // compare only as far as the second half goes
            if (p1.data != p2.data) {
                isPalindrome = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 4) Restore the list (optional, but good practice)
        reverseList(secondHalfHead);

        return isPalindrome;
    }

    // Reverse a singly linked list in-place and return new head
    private static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node nextTemp = current.next; // store next
            current.next = prev;          // reverse pointer
            prev = current;               // move prev forward
            current = nextTemp;           // move current forward
        }

        return prev;
    }
}