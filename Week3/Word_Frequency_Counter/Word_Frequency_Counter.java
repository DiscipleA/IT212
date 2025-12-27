import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Word_Frequency_Counter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Loop to continuously accept user input
        while (true) {
            System.out.print("Enter a paragraph/text or (exit): ");
            String paragraph = input.nextLine().toLowerCase();
            
            // Exit condition
            if (paragraph.equals("exit")) {
                System.out.println("Exiting the program.");
                input.close();
                break;
            }
            // Split the paragraph into words using regex to handle punctuation
            String[] words = paragraph.split("[\\s\\p{Punct}]+");
            
            // Map to store word counts
            Map<String, Integer> wordCount = new HashMap<>();

            // Count the frequency of each word
            for (String word : words) {
                if (wordCount.containsKey(word)) {
                    wordCount.put(word, wordCount.get(word) + 1);
                } else {
                    wordCount.put(word, 1);
                }
            }
            
            // Sort the word count map by keys (words in alphabetical order)
            Map<String, Integer> sortedWordCount = new TreeMap<>(wordCount);

            // Word frequency output in alphabetical order
            System.out.println("Word Frequencies:");
            for (Map.Entry<String, Integer> entry : sortedWordCount.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());

            // Word frequency output
            // System.out.println("Word Frequencies:");
            // for (String word : wordCount.keySet()) {
            //     System.out.println(word + ": " + wordCount.get(word));
            // }
            }

        }
        input.close();
    }
}
