public class Order {
    // Unique identifier for the order
    private String orderId;

    // Simple customer detail (name or ID)
    private String customerName;

    // Description of the order (items purchased)
    private String orderDetails;

    // Constructor to create a new Order object
    public Order(String orderId, String customerName, String orderDetails) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDetails = orderDetails;
    }

    // Getter for orderId
    public String getOrderId() {
        return orderId;
    }

    // Getter for customerName
    public String getCustomerName() {
        return customerName;
    }

    // Getter for orderDetails
    public String getOrderDetails() {
        return orderDetails;
    }

    // Convert the Order into a readable string for display()
    @Override
    public String toString() {
        String result = "\nID: " + orderId + 
                        "\nCustomer: " + customerName + 
                        "\nDetails: " + orderDetails;
        return result;
    }
}