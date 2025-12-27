import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class WaitingListManager {

    // Unique membership check
    private final Set<String> waitingList = new HashSet<>();
    // Arrival/serve order
    private final Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WaitingListManager tempManager = new WaitingListManager();

        System.out.print("Would you like to use Waiting List Manager? (yes/no): ");
        String response = scanner.nextLine().trim();
        if (response.equalsIgnoreCase("no")) {
            System.out.println("Exiting Waiting List Manager. Goodbye!");
            scanner.close();
            return;
        }

        int choice;
        do {
            System.out.println("\n===== Waiting List Manager =====");
            System.out.println("1. Add Person to Waiting List");
            System.out.println("2. Serve Person from Waiting List");
            System.out.println("3. Check if Person is in Waiting List");
            System.out.println("4. Display Waiting List Size");
            System.out.println("5. Display Waiting List (Queue order)");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a number (1-6): ");
                scanner.next(); // discard bad token
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the name to add: ");
                    String nameToAdd = scanner.nextLine().trim();
                    try {
                        boolean added = tempManager.addPerson(nameToAdd);
                        if (added) {
                            System.out.println(nameToAdd + " was added.");
                        } else {
                            System.out.println(nameToAdd + " is already in the waiting list (not added again).");
                        }
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                }
                case 2 -> {
                    String served = tempManager.servePerson();
                    if (served == null) {
                        System.out.println("No one to serve. The queue is empty.");
                    } else {
                        System.out.println("Serving customer: " + served);
                    }
                }
                case 3 -> {
                    System.out.print("Enter the name to check: ");
                    String nameToCheck = scanner.nextLine().trim();
                    boolean present = tempManager.isPersonInList(nameToCheck);
                    System.out.println(present
                            ? nameToCheck + " is in the waiting list."
                            : nameToCheck + " is not in the waiting list.");
                }
                case 4 -> {
                    System.out.println("Unique people in waiting list (Set size): " + tempManager.getWaitingListSize());
                    System.out.println("People waiting to be served (Queue size): " + tempManager.getQueueSize());
                }
                case 5 -> tempManager.displayWaitingListInOrder();
                case 6 -> System.out.println("Exiting Waiting List Manager. Goodbye!");
                default -> System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }

    /**
     * Adds a person if not already present.
     * - HashSet ensures uniqueness
     * - Queue preserves serve order (only enqueued on first add)
     * @return true if newly added; false if already present
     */
    public boolean addPerson(String name) {
        if (name == null || name.isEmpty()) {
            // per your class-creation rules: validate String emptiness
            throw new IllegalArgumentException("Name must not be empty");
        }
        // Add to Set first; only enqueue if it was not already present
        if (waitingList.add(name)) {
            queue.add(name);
            return true;
        }
        return false;
    }

    /**
     * Serves the next person in FIFO order.
     * Removes from both Queue and Set to keep structures consistent.
     * @return served name, or null if none
     */
    public String servePerson() {
        String person = queue.poll();
        if (person != null) {
            waitingList.remove(person);
        }
        return person;
    }

    public boolean isPersonInList(String name) {
        return waitingList.contains(name);
    }

    public int getWaitingListSize() {
        return waitingList.size();
    }

    public int getQueueSize() {
        return queue.size();
    }

    /**
     * Displays the list in the actual serving order (queue),
     * which is usually what a user expects to see.
     */
    public void displayWaitingListInOrder() {
        if (queue.isEmpty()) {
            System.out.println("The waiting list is currently empty.");
            return;
        }
        System.out.println("Waiting List (serve order): " + queue);
    }
}

