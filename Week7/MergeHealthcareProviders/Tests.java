import java.util.List;

public class Tests {

    // Counters for the final summary
    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) {
        // Run all tests through a single runner so output is consistent
        runTest("Normal 1: interleaving merge keeps sorted order + size",
                Tests::testNormalInterleaving);

        runTest("Normal 2: duplicates preserved (same SSN appears twice)",
                Tests::testNormalDuplicatesPreserved);

        runTest("Normal 3: all-from-A-then-all-from-B stays sorted",
                Tests::testNormalAllAThenB);

        runTest("Edge 1: merge when first list empty returns second",
                Tests::testEdgeFirstEmpty);

        runTest("Edge 2: merge when both lists empty returns empty",
                Tests::testEdgeBothEmpty);

        runTest("Edge 3: append null should throw during usage (threw IllegalArgumentException)",
                Tests::testEdgeAppendNullThrows);

        printSummaryAndExit();
    }

    // -------------------- Test Runner (refactor core) --------------------

    // A tiny functional interface so we can pass tests as methods
    @FunctionalInterface
    private interface TestCase {
        void run() throws Exception;
    }

    // Runs one test and prints a standardized PASS/FAIL line
    private static void runTest(String label, TestCase test) {
        try {
            test.run();
            passed++;
            System.out.println("[PASS] " + label);
        } catch (Throwable t) {
            failed++;
            System.out.println("[FAIL] " + label);
            System.out.println("       Reason: " + t.getClass().getSimpleName() + " - " + t.getMessage());
        }
    }

    // Prints the totals in a nice box (like your sample output)
    private static void printSummaryAndExit() {
        System.out.println();
        System.out.println("==============================");
        System.out.println("TEST RESULTS: Passed=" + passed + ", Failed=" + failed);
        System.out.println("==============================");

        // Optional: if you want the program to return a "failure exit code" for CI-like behavior
        if (failed > 0) {
            System.exit(1);
        }
    }

    // -------------------- Assert Helpers --------------------

    private static void assertTrue(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    private static void assertEquals(int expected, int actual, String message) {
        if (expected != actual) {
            throw new AssertionError(message + " | expected=" + expected + ", actual=" + actual);
        }
    }

    private static void assertEquals(String expected, String actual, String message) {
        if (expected == null && actual == null) return;
        if (expected != null && expected.equals(actual)) return;
        throw new AssertionError(message + " | expected=" + expected + ", actual=" + actual);
    }

    // Builds a list quickly (same idea as before)
    private static DoublyLinkedList build(PatientRecord... records) {
        DoublyLinkedList list = new DoublyLinkedList();
        for (PatientRecord r : records) {
            list.insertAtEnd(r);
        }
        return list;
    }

    // -------------------- Normal Test Cases (3) --------------------

    private static void testNormalInterleaving() {
        DoublyLinkedList a = build(
                new PatientRecord("111-11-1111", 40, "A"),
                new PatientRecord("333-33-3333", 29, "C"),
                new PatientRecord("555-55-5555", 52, "E")
        );
        DoublyLinkedList b = build(
                new PatientRecord("222-22-2222", 36, "B"),
                new PatientRecord("444-44-4444", 31, "D"),
                new PatientRecord("666-66-6666", 60, "F")
        );

        DoublyLinkedList merged = DoublyLinkedList.mergeSorted(a, b);

        assertEquals(6, merged.size(), "Merged size should be 6");
        assertTrue(merged.isSortedBySsn(), "Merged list should be sorted by SSN");
        assertTrue(merged.hasValidBidirectionalLinks(), "Merged list should have valid next/prev links");

        List<PatientRecord> forward = merged.traverseForward();
        assertEquals("111-11-1111", forward.get(0).getSsn(), "First SSN should be smallest");
        assertEquals("666-66-6666", forward.get(forward.size() - 1).getSsn(), "Last SSN should be largest");
    }

    private static void testNormalDuplicatesPreserved() {
        DoublyLinkedList a = build(
                new PatientRecord("111-11-1111", 40, "Alice"),
                new PatientRecord("333-33-3333", 29, "Charlie A")
        );
        DoublyLinkedList b = build(
                new PatientRecord("222-22-2222", 36, "Bob"),
                new PatientRecord("333-33-3333", 31, "Charlie B")
        );

        DoublyLinkedList merged = DoublyLinkedList.mergeSorted(a, b);

        assertEquals(4, merged.size(), "Merged size should be 4");
        assertTrue(merged.isSortedBySsn(), "Merged list should remain sorted");
        assertTrue(merged.hasValidBidirectionalLinks(), "Merged list links must remain valid");

        long count333 = merged.traverseForward().stream()
                .filter(r -> r.getSsn().equals("333-33-3333"))
                .count();

        assertEquals(2, (int) count333, "Duplicate SSN should appear twice in merged list");
    }

    private static void testNormalAllAThenB() {
        DoublyLinkedList a = build(
                new PatientRecord("111-11-1111", 40, "A"),
                new PatientRecord("222-22-2222", 41, "B")
        );
        DoublyLinkedList b = build(
                new PatientRecord("900-00-0000", 50, "X"),
                new PatientRecord("999-99-9999", 51, "Y")
        );

        DoublyLinkedList merged = DoublyLinkedList.mergeSorted(a, b);

        assertEquals(4, merged.size(), "Merged size should be 4");
        assertTrue(merged.isSortedBySsn(), "Merged list should remain sorted");
        assertTrue(merged.hasValidBidirectionalLinks(), "Merged list links must remain valid");
    }

    // -------------------- Edge Test Cases (3) --------------------

    private static void testEdgeFirstEmpty() {
        DoublyLinkedList a = new DoublyLinkedList();
        DoublyLinkedList b = build(
                new PatientRecord("222-22-2222", 36, "Bob")
        );

        DoublyLinkedList merged = DoublyLinkedList.mergeSorted(a, b);

        assertEquals(1, merged.size(), "Merged size should be 1");
        assertTrue(merged.isSortedBySsn(), "Merged list should be sorted");
        assertTrue(merged.hasValidBidirectionalLinks(), "Merged list links must be valid");
        assertEquals("222-22-2222", merged.traverseForward().get(0).getSsn(), "Only record should match");
    }

    private static void testEdgeBothEmpty() {
        DoublyLinkedList a = new DoublyLinkedList();
        DoublyLinkedList b = new DoublyLinkedList();

        DoublyLinkedList merged = DoublyLinkedList.mergeSorted(a, b);

        assertEquals(0, merged.size(), "Merged size should be 0");
        assertTrue(merged.traverseForward().isEmpty(), "Merged traversal should be empty");
        assertTrue(merged.hasValidBidirectionalLinks(), "Empty list should still be link-valid");
    }

    // This edge test requires DoublyLinkedList.insertAtEnd to reject null.
    // If your current insertAtEnd doesn't throw, I’ll show the 2-line change below.
    private static void testEdgeAppendNullThrows() {
        DoublyLinkedList list = new DoublyLinkedList();
        try {
            list.insertAtEnd(null);
            throw new AssertionError("Expected IllegalArgumentException when inserting null PatientRecord");
        } catch (IllegalArgumentException e) {
            // pass: this is the expected outcome
            assertTrue(true, "IllegalArgumentException thrown as expected");
        }
    }
}