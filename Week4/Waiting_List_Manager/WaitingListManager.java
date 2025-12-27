import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class WaitingListManager {

    // Initialize waitingList as a HashSet and queue as a LinkedList
    private Set<String> waitingList = new HashSet<>();
    private Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WaitingListManager tempManager = new WaitingListManager();

        // Ask user if they want to use the Waiting List Manager
        System.out.println("Would you like to use Waiting List Manager? (yes/no)");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("no")) {
            System.out.println("Exiting Waiting List Manager. Goodbye!");
            scanner.close();
            return;
        }
        System.out.println("\nWelcome to the Waiting List Manager!");
        int choice;
        do {
            // Display menu options
            System.out.println("\nPlease choose from the following options:");
            System.out.println("    1. Add Person to Waiting List");
            System.out.println("    2. Serve Person from Waiting List");
            System.out.println("    3. Check if Person is in Waiting List");
            System.out.println("    4. Display Waiting List Size");
            System.out.println("    5. Display Waiting List");
            System.out.println("    6. Exit");
            System.out.print("Enter your choice (1-6): ");

            // Validate user input
            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a number (1-6): ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            // Switch based on user choice
            switch (choice) {
                case 1:
                    // Add a person to the waiting list
                    System.out.print("Enter the name of the person to add: ");
                    String nameToAdd = scanner.nextLine();
                    tempManager.addPerson(nameToAdd);
                    break;
                case 2:
                    // Serve the next person in the waiting list
                    System.out.println("Serving the next person in the waiting list:");
                    String servedPerson = tempManager.servePerson();
                    System.out.println("\nServing Customer: " + servedPerson);
                    break;
                case 3:
                    // Check if a person is in the waiting list
                    System.out.print("Enter the name of the person to check: ");
                    String nameToCheck = scanner.nextLine();
                    boolean isInList = tempManager.isPersonInList(nameToCheck);
                    System.out.println(isInList
                            ? "\n" + nameToCheck + " is in the waiting list."
                            : "\n" + nameToCheck + " is not in the waiting list.");
                    break;
                case 4:
                    // Display the current waiting list size
                    System.out.println("\nCurrent Waiting List Size: " + tempManager.getWaitingListSize());
                    break;
                case 5:
                    // Display the waiting list
                    tempManager.displayWaitingList();
                    break;
                case 6:
                    // Exit the program
                    System.out.println("Exiting Waiting List Manager. Goodbye!");
                    break;
                default:
                    // Handle invalid input
                    System.out.println("\nInvalid option. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }

    // Add a person to the waiting list
    public void addPerson(String name){
        if (waitingList.contains(name)) {
            // Person is already in the waiting list
            System.out.println("\n" + name + " is already in the waiting list (not added again).");
            return;
        }
        waitingList.add(name);
        queue.add(name);
        System.out.println("\n" + name + " was added to the waiting list.");
    }

    // Serve the next person in the waiting list
    public String servePerson() {
        String person = queue.poll();
        if (person != null) {
            waitingList.remove(person);
        }
        return person;
    }

    // Check if a person is in the waiting list
    public boolean isPersonInList(String name) {
        return waitingList.contains(name);
    }

    // Get the current waiting list size
    public Integer getWaitingListSize() {
        return waitingList.size();
    }

    // Display the waiting list
    public void displayWaitingList() {
        if (queue.isEmpty()) {
            // Waiting list is empty
            System.out.println("The waiting list is currently empty.");
            return;
        } else {
            // Display the current waiting list
            System.out.println("\nCurrent Waiting List: " + queue);
        }   
    }
}
