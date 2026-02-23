public class Tests {

    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) {
        // Normal cases (3)
        testAppendAndDisplayOrder();
        testReverseFlipsOrder();
        testReverseTwiceReturnsOriginal();

        // Edge cases (3)
        testReverseEmptyList();
        testReverseSingleNodeList();
        testAppendNullOrder();

        System.out.println("\n==============================");
        System.out.println("TEST RESULTS: Passed=" + passed + ", Failed=" + failed);
        System.out.println("==============================");
    }

    // ---------- Minimal assertion helpers ----------
    private static void assertEquals(String testName, String expected, String actual) {
        if (expected.equals(actual)) {
            passed++;
            System.out.println("[PASS] " + testName);
        } else {
            failed++;
            System.out.println("[FAIL] " + testName);
            System.out.println("  Expected: " + expected);
            System.out.println("  Actual:   " + actual);
        }
    }

    private static void assertThrows(String testName, Runnable action) {
        try {
            action.run();
            failed++;
            System.out.println("[FAIL] " + testName);
            System.out.println("  Expected an exception, but none was thrown.");
        } catch (Exception e) {
            passed++;
            System.out.println("[PASS] " + testName + " (threw " + e.getClass().getSimpleName() + ")");
        }
    }

    // ---------- Normal tests ----------
    private static void testAppendAndDisplayOrder() {
        OrderLinkedList list = new OrderLinkedList();
        list.append(new Order("ORD-1", "Alice", "Item A"));
        list.append(new Order("ORD-2", "Bob", "Item B"));
        list.append(new Order("ORD-3", "Cara", "Item C"));

        String expected =
                "\nID: ORD-1\nCustomer: Alice\nDetails: Item A\n" +
                "\nID: ORD-2\nCustomer: Bob\nDetails: Item B\n" +
                "\nID: ORD-3\nCustomer: Cara\nDetails: Item C\nnull";

        assertEquals("Normal 1: append + display keeps insertion order", expected, list.toDisplayString());
    }

    private static void testReverseFlipsOrder() {
        OrderLinkedList list = new OrderLinkedList();
        list.append(new Order("ORD-1", "Alice", "Item A"));
        list.append(new Order("ORD-2", "Bob", "Item B"));
        list.append(new Order("ORD-3", "Cara", "Item C"));

        list.reverse();

        String expected =
                "\nID: ORD-3\nCustomer: Cara\nDetails: Item C\n" +
                "\nID: ORD-2\nCustomer: Bob\nDetails: Item B\n" +
                "\nID: ORD-1\nCustomer: Alice\nDetails: Item A\nnull";

        assertEquals("Normal 2: reverse flips to most-recent-first", expected, list.toDisplayString());
    }

    private static void testReverseTwiceReturnsOriginal() {
        OrderLinkedList list = new OrderLinkedList();
        list.append(new Order("ORD-1", "Alice", "Item A"));
        list.append(new Order("ORD-2", "Bob", "Item B"));

        String original =
                "\nID: ORD-1\nCustomer: Alice\nDetails: Item A\n" +
                "\nID: ORD-2\nCustomer: Bob\nDetails: Item B\nnull";

        list.reverse();
        list.reverse();

        assertEquals("Normal 3: reverse twice returns original", original, list.toDisplayString());
    }

    // ---------- Edge tests ----------
    private static void testReverseEmptyList() {
        OrderLinkedList list = new OrderLinkedList();
        list.reverse();
        assertEquals("Edge 1: reverse on empty list stays empty", "null", list.toDisplayString());
    }

    private static void testReverseSingleNodeList() {
        OrderLinkedList list = new OrderLinkedList();
        list.append(new Order("ORD-1", "Alice", "Item A"));
        String expected = "\nID: ORD-1\nCustomer: Alice\nDetails: Item A\nnull";

        list.reverse();
        assertEquals("Edge 2: reverse on single node unchanged", expected, list.toDisplayString());
    }

    private static void testAppendNullOrder() {
        OrderLinkedList list = new OrderLinkedList();

        // This will cause a NullPointerException when toString is called later OR you can enforce your own check.
        // We will force an exception by trying to append null and then display.
        assertThrows("Edge 3: append null should throw during usage", () -> {
            list.append(null);
            list.display(); // triggers null usage
        });
    }
}

// import org.junit.jupiter.api.Test;

// import static org.junit.jupiter.api.Assertions.*;

// public class Tests {

//     // -------------------------
//     // Normal cases (3)
//     // -------------------------

//     @Test
//     void normal_appendAndDisplay_keepsInsertionOrder() {
//         OrderLinkedList list = new OrderLinkedList();
//         list.append(new Order("ORD-1", "Alice", "Item A"));
//         list.append(new Order("ORD-2", "Bob", "Item B"));
//         list.append(new Order("ORD-3", "Cara", "Item C"));

//         String expected =
//                 "\nID: ORD-1\nCustomer: Alice\nDetails: Item A\n" +
//                 "\nID: ORD-2\nCustomer: Bob\nDetails: Item B\n" +
//                 "\nID: ORD-3\nCustomer: Cara\nDetails: Item C\nnull";

//         assertEquals(expected, list.toDisplayString());
//     }

//     @Test
//     void normal_reverse_flipsToMostRecentFirst() {
//         OrderLinkedList list = new OrderLinkedList();
//         list.append(new Order("ORD-1", "Alice", "Item A"));
//         list.append(new Order("ORD-2", "Bob", "Item B"));
//         list.append(new Order("ORD-3", "Cara", "Item C"));

//         list.reverse();

//         String expected =
//                 "\nID: ORD-3\nCustomer: Cara\nDetails: Item C\n" +
//                 "\nID: ORD-2\nCustomer: Bob\nDetails: Item B\n" +
//                 "\nID: ORD-1\nCustomer: Alice\nDetails: Item A\nnull";

//         assertEquals(expected, list.toDisplayString());
//     }

//     @Test
//     void normal_reverseTwice_returnsOriginal() {
//         OrderLinkedList list = new OrderLinkedList();
//         list.append(new Order("ORD-1", "Alice", "Item A"));
//         list.append(new Order("ORD-2", "Bob", "Item B"));

//         String original =
//                 "\nID: ORD-1\nCustomer: Alice\nDetails: Item A\n" +
//                 "\nID: ORD-2\nCustomer: Bob\nDetails: Item B\nnull";

//         list.reverse();
//         list.reverse();

//         assertEquals(original, list.toDisplayString());
//     }

//     // -------------------------
//     // Edge cases (3)
//     // -------------------------

//     @Test
//     void edge_reverseEmptyList_staysEmpty() {
//         OrderLinkedList list = new OrderLinkedList();
//         list.reverse();
//         assertEquals("null", list.toDisplayString());
//     }

//     @Test
//     void edge_reverseSingleNode_unchanged() {
//         OrderLinkedList list = new OrderLinkedList();
//         list.append(new Order("ORD-1", "Alice", "Item A"));

//         String expected = "\nID: ORD-1\nCustomer: Alice\nDetails: Item A\nnull";

//         list.reverse();
//         assertEquals(expected, list.toDisplayString());
//     }

//     @Test
//     void edge_appendNull_throwsIllegalArgumentException() {
//         OrderLinkedList list = new OrderLinkedList();
//         assertThrows(IllegalArgumentException.class, () -> list.append(null));
//     }
// }