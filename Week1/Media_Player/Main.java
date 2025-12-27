/**
* Main class with main method to demostrate program functionality
*
*@author Dmitriy Chernichenko
*@version IT212 HW_Week1
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] arg){
        
        // String Array to list choices for a menu
        String[] media = {"AudioPlayer", "VideoPlayer", "StreamingPlayer"};
        
        // Scanner instantiation for user input from menu
        Scanner input = new Scanner(System.in);

        // Message to ask user to make a choice from menu
        System.out.println("\nChoose what media player you want to test below?");

        // Menu output through loop using Array value
        for (int i = 1; (media.length + 1) > i; i++) {
            System.out.println("["+i+"] " +media[i-1]);
        }

        // variables necessary to validate user input
        int choice = 0;
        boolean validChoice = false;
        
        // while loop to as user for input until valid one is entered
        while (!validChoice) {
            System.out.println("Type your choice (1, 2, or 3): ");
            choice = input.nextInt();

            if (choice >= 1 && choice <= 3) {
                validChoice = true; // Valid input
            } else {
                System.out.println("Invalid choice! Please choose a number between 1 and 3.");
            }
        }


        //Instantiation of a MediaPlayer class to be defined upon user choice.
        MediaPlayer player = null;

        // Switch statement to choose the player type based on the user's input
        switch (choice) {
            case 1:
                // Instantiate AudioPlayer
                player = new AudioPlayer("Only God can judge me.");
                break;
            case 2:
                // Instantiate VideoPlayer
                player = new VideoPlayer("Mission Impossible");
                break;
            case 3:
                // Instantiate StreamingPlayer
                player = new StreamingPlayer("Netflix Series");
                break;
            default:
                input.close();
        }

        // Test the chosen media player
        if (player != null) {
            player.play();
            player.pause();
            player.stop();
        }
        
        input.close();
    }
}        