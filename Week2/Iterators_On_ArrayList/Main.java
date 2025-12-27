// Import necessary Java classes
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

// Main class for the program
public class Main {
    // Main method to start the program
    public static void main (String[] args) {
        
        // Initialize an ArrayList to store integers
        List<Integer> spin = new ArrayList<>();
        // Create a Scanner object for user input
        Scanner input = new Scanner(System.in);

        // Simulate adding random integers to the list
        for (int i = 0; i <= 9; i++) {
            int r = (int)(Math.random()*10);
            spin.add(r);
        }

        // Display the contents of the ArrayList
        System.out.println(spin);
        // Calculate and display the sum of elements in the ArrayList
        calculateSum(spin);
        
        removeElementIterator(spin, input);

        // Display the modified ArrayList after iteration
        System.out.println(spin);
        // Recalculate and print sum after modifications
        calculateSum(spin);


        removeElementArrayList(spin, input);
        
        // Display the list after removal of marked elements
        System.out.println(spin);
         // Recalculate and display the sum after additions
        calculateSum(spin);

        changeElementIteratorArrayList(spin, input);

        // Display the updated list after addition of marked elements
        System.out.println(spin);
        calculateSum(spin);
        input.close();
    
    }
    // Method to calculate the sum of elements in the given List
    public static void calculateSum(List<Integer> spin) {
        // Obtain an Iterator to iterate over the elements in the List
        Iterator<Integer> repeat = spin.iterator();
        // Initialize the sum variable to zero
        int sum = 0;

        // Iterate over the elements and calculate the sum
        while (repeat.hasNext()) {
            int s = repeat.next();
            System.out.println(s);
            sum = sum + s;
        }

        // Display the calculated sum of elements
        System.out.println("Sum of elements: " + sum);
    }
    
    public static void removeElementIterator(List<Integer> spin, Scanner input) {
        // Output section header for editing ArrayList using Iterator
        System.out.println("################################");
        System.out.println("Editing ArrayList using Iterator");
        System.out.println("################################");

        // Iterate over the ArrayList using an Iterator
        Iterator<Integer> repeat = spin.iterator();
        int sum = 0;

        System.out.print("Enter integer from 1 to 10 to be removed from ArrayList: ");
        int scan = input.nextInt();

        // Loop through the list for modifications based on user input
        while (repeat.hasNext()) {
            int s = repeat.next();
            sum = sum + s;

            // Check if the scanned number matches the element
            if (s == scan) {
                repeat.remove();
                // System.out.println("Please enter NUMBER you want instead: ");
                // int change = input.nextInt();
                // spin.add(change);
            }
        }
    }

    public static void removeElementArrayList(List<Integer> spin, Scanner input) {
            
        System.out.println("##########################################");
        System.out.println("Editing ArrayList using Add/Remove Methods");
        System.out.println("##########################################");

        System.out.print("Would you like to Add or Remove integers A/R: ");
        String answer = input.next();

        // Create a new ArrayList to store elements for add/remove method
        List<Integer> toSpin = new ArrayList<>();
        int sum = 0;

        System.out.print("Enter integer from 1 to 10 to be removed from ArrayList: ");
        int scan = input.nextInt();

        // Loop through the list to mark elements for modification
        for (int change : spin) {
            sum = sum + change;

            // Check for elements that match user input
            if (change == scan) {
                // Mark the element for addition/removal
                toSpin.add(change);    
            }
        }

        if (answer.equalsIgnoreCase("A")) {
            // Add all marked elements from the original list
            spin.addAll(toSpin);
        } else if (answer.equalsIgnoreCase("R")) {
            // Remove all marked elements from the original list
            spin.removeAll(toSpin);
        } else {
            System.out.println("Invalid Entry.");
            //removeElementArrayList(spin, input);
        }
    }
    
    public static void changeElementIteratorArrayList(List<Integer> spin, Scanner input) {
        // Output section header for editing ArrayList using ListIterator
        System.out.println("####################################");
        System.out.println("Editing ArrayList using ListIterator");
        System.out.println("####################################");    

        // ListIterator for iterating and modifying the ArrayList
        ListIterator<Integer> modify = spin.listIterator();
        int sum = 0;

        System.out.print("Enter integer from 1 to 10 to be removed from ArrayList: ");
        int scan = input.nextInt();

        System.out.println("Please enter NUMBER you want instead: ");
        int change = input.nextInt();

        // Loop through the list using ListIterator for modifications
        while (modify.hasNext()) {
            int s = modify.next();

            // Calculate the sum of elements
            sum = sum + s;

            // Check for elements that match user input
            if (s == scan) {
                modify.remove();
                modify.add(change);
            }
        }
    }    
}
