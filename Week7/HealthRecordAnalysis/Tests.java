// import static org.junit.jupiter.api.Assertions.*;
// import org.junit.jupiter.api.Test;

// public class Tests {

//     // --------------------
//     // Normal cases (3)
//     // --------------------

//     @Test
//     void normal_oddLengthPalindrome_returnsTrue() {
//         SinglyLinkedList list = SinglyLinkedList.fromArray(new int[]{80, 90, 100, 90, 80});
//         assertTrue(HealthRecordAnalyzer.isHealthRecordSymmetric(list.head));
//     }

//     @Test
//     void normal_evenLengthPalindrome_returnsTrue() {
//         SinglyLinkedList list = SinglyLinkedList.fromArray(new int[]{70, 85, 85, 70});
//         assertTrue(HealthRecordAnalyzer.isHealthRecordSymmetric(list.head));
//     }

//     @Test
//     void normal_notPalindrome_returnsFalse() {
//         SinglyLinkedList list = SinglyLinkedList.fromArray(new int[]{80, 90, 100, 95, 80});
//         assertFalse(HealthRecordAnalyzer.isHealthRecordSymmetric(list.head));
//     }

//     // --------------------
//     // Edge cases (3)
//     // --------------------

//     @Test
//     void edge_emptyList_returnsTrue() {
//         SinglyLinkedList list = new SinglyLinkedList(); // head is null
//         assertTrue(HealthRecordAnalyzer.isHealthRecordSymmetric(list.head));
//     }

//     @Test
//     void edge_singleNode_returnsTrue() {
//         SinglyLinkedList list = SinglyLinkedList.fromArray(new int[]{123});
//         assertTrue(HealthRecordAnalyzer.isHealthRecordSymmetric(list.head));
//     }

//     @Test
//     void edge_twoDifferentNodes_returnsFalse() {
//         SinglyLinkedList list = SinglyLinkedList.fromArray(new int[]{10, 20});
//         assertFalse(HealthRecordAnalyzer.isHealthRecordSymmetric(list.head));
//     }
// }

public class Tests {

    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) {
        // --------------------
        // Normal cases (3)
        // --------------------
        runTest("Normal: Odd-length palindrome",
                new int[]{80, 90, 100, 90, 80}, true);

        runTest("Normal: Even-length palindrome",
                new int[]{70, 85, 85, 70}, true);

        runTest("Normal: Non-palindrome",
                new int[]{80, 90, 100, 95, 80}, false);

        // --------------------
        // Edge cases (3)
        // --------------------
        runTest("Edge: Empty list",
                new int[]{}, true);

        runTest("Edge: Single node",
                new int[]{123}, true);

        runTest("Edge: Two nodes non-palindrome",
                new int[]{10, 20}, false);

        // Summary
        System.out.println("\n====================");
        System.out.println("Tests passed: " + passed);
        System.out.println("Tests failed: " + failed);
        System.out.println("====================");
    }

    private static void runTest(String testName, int[] values, boolean expected) {
        SinglyLinkedList list = SinglyLinkedList.fromArray(values);
        boolean actual = HealthRecordAnalyzer.isHealthRecordSymmetric(list.head);

        if (actual == expected) {
            System.out.println("[PASS] " + testName);
            passed++;
        } else {
            System.out.println("[FAIL] " + testName + " | expected=" + expected + ", actual=" + actual);
            failed++;
        }
    }
}