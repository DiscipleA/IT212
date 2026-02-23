public class Main {
    public static void main(String[] args) {
        // Example 1: symmetric (palindrome)
        SinglyLinkedList record1 = SinglyLinkedList.fromArray(new int[] {80, 90, 100, 90, 80});
        System.out.println("Record 1:");
        record1.printList();
        System.out.println("Symmetric? " + HealthRecordAnalyzer.isHealthRecordSymmetric(record1.head));
        System.out.println();

        // Example 2: not symmetric
        SinglyLinkedList record2 = SinglyLinkedList.fromArray(new int[] {80, 90, 100, 95, 80});
        System.out.println("Record 2:");
        record2.printList();
        System.out.println("Symmetric? " + HealthRecordAnalyzer.isHealthRecordSymmetric(record2.head));

        // Example 3: not symmetric
        SinglyLinkedList record3 = SinglyLinkedList.fromArray(new int[] {80, 90, 100, 90, 80, 90, 100, 90, 80});
        System.out.println("Record 3:");
        record3.printList();
        System.out.println("Symmetric? " + HealthRecordAnalyzer.isHealthRecordSymmetric(record3.head));

        // Example 4: symmetric or not?
        SinglyLinkedList record4 = SinglyLinkedList.fromArray(new int[] {80, 90, 100, 80, 90, 100});
        System.out.println("Record 4:");
        record4.printList();
        System.out.println("Symmetric? " + HealthRecordAnalyzer.isHealthRecordSymmetric(record4.head));
    }
}