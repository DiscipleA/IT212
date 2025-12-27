import java.util.Queue;
//import java.util.TreeSet;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Waiting List Manager!");
        Set<String> waitingList = new HashSet<>();

        waitingList.add("Alfonso");
        waitingList.add("Beatrice");
        waitingList.add("Brenda");
        waitingList.add("Carlos");
        waitingList.add("Diana");
        waitingList.add("Eva");
        waitingList.add("Frank");
        System.out.println("Current Waiting List: " + waitingList);
        if (waitingList.contains("Diana")) {
            waitingList.remove("Diana");
        } // Duplicate entry to test uniqueness

        Queue<String> queue = new LinkedList<>();
        for (String id : waitingList) {
            queue.add(id);
            if (id.equals("Carlos")) {
                waitingList.add("George"); // Duplicate entry to test queue behavior
            }
        }
        queue.remove("Eva");
        System.out.println("Current Waiting List: " + waitingList);
        

       
        System.out.println("Processing patients in the order they were added:");
        while (!queue.isEmpty()) {
            System.out.println("Processing Patient ID: " + queue.poll());

        }
        // You can add code here to create an instance of WaitingListManager and use its methods.
    }
}