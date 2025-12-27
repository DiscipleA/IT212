import java.util.ArrayList;

public class Library_P3 <T> {
    // instance variables
    private ArrayList <T> items = new ArrayList<>();   // instantiated directly here
    private T item;
    // Default constructor
    public Library_P3(T item) {
        setItems(item);       
    }

    // setter for items
    public void setItems(T item) {
        if (item == null)
            throw new IllegalArgumentException("Items cannot be null"); 
        this.item = item;
    }

    // Accessor for current item name
    
    //public String getItemName(T item) {
    //    return item == null ? null : item.toString();
    //}
    // Method to add an item to the library

    public void addItem(T item) {
        setItems(item);
        items.add(item);
    }

    // Method to remove an item from the library
    //public void removeItem(T item) {
    //   items.remove(item);
    //}

    // Method to find an item by name
    public T findItemByName(String item) {
        if (item == null || item.isEmpty())
            throw new IllegalArgumentException("Name cannot be null"); 
        
        for (T it : items) {
            if (it.toString().equals(item)) {
                return it;
            }
        }
        return null;
    }

    public void removeItem(T itemName) {
        T itemToRemove = findItemByName(itemName.toString());
        if (itemToRemove != null) {
            items.remove(itemToRemove);
        } else {
            System.out.println("Item not found for removal: " + itemName);
        }
    }

    // toString method to list all items
    public String toString() {
        String books = "";
        for (T it : items) {
            books += it + "\n"; 
        }
        return books;
    }    
}