public class Main {
    public static void main(String[] args) {
        OrderLinkedList orders = new OrderLinkedList();

        // Add orders in the order they were received
        orders.append(new Order("ORD-1001", "Alice", "2x USB-C cables"));
        orders.append(new Order("ORD-1002", "Bob", "Gaming mouse"));
        orders.append(new Order("ORD-1003", "Charlie", "Laptop stand"));

        System.out.println("Orders in received order:");
        orders.display();

        // Reverse the list (most recent order first)
        orders.reverse();

        System.out.println("\nOrders after reversal (most recent first):");
        orders.display();
    }
}