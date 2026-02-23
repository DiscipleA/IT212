public class Main {
    public static void main(String[] args) {
        DoublyLinkedList healthMerge = new DoublyLinkedList();
        healthMerge.insertAtEnd(new PatientRecord("111-11-1111", 40, "Alice Adams"));
        healthMerge.insertAtEnd(new PatientRecord("333-33-3333", 29, "Charlie Chen"));
        healthMerge.insertAtEnd(new PatientRecord("555-55-5555", 52, "Eve Evans"));

        DoublyLinkedList carePlus = new DoublyLinkedList();
        carePlus.insertAtEnd(new PatientRecord("222-22-2222", 36, "Bob Brown"));
        carePlus.insertAtEnd(new PatientRecord("333-33-3333", 31, "Charlie Chen (duplicate)"));
        carePlus.insertAtEnd(new PatientRecord("777-77-7777", 60, "Grace Green"));

        DoublyLinkedList merged = DoublyLinkedList.mergeSorted(healthMerge, carePlus);

        System.out.println("Merged patient records (sorted by SSN):");
        for (PatientRecord record : merged.traverseForward()) {
            System.out.println(record);
        }

        System.out.println("\nSorted? " + merged.isSortedBySsn());
        System.out.println("Links valid? " + merged.hasValidBidirectionalLinks());
        System.out.println("Total records: " + merged.size());
    }
}