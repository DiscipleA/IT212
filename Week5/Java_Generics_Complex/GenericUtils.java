import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/**
* Part 2 
* Generic Sort Utility class with bounded type parameter.
*
* 1. Sorts an ArrayList<T> where T must implement Comparable<T>.
*    - e.g., sort(ArrayList<T> list) where T extends Comparable<T>
*
* 2. Wildcard Usage in Methods where Accepts ANY Collection of ANY type.
*    - e.g., printCollection(Collection<?> coll)
*    - e.g., sumNumbers(Collection<? extends Number> numbers)
*
* @author Dmitriy Chernichenko
* @version IT212 Generics 2 - Generic Utils Class
*/

public class GenericUtils {

    /**
     * Sorts the given ArrayList<T> in ascending order.
     *
     * The bound "T extends Comparable<T>" means:
     * - T objects know how to compare themselves to other T objects
     * - so the method can safely call compareTo(...)
     * 
     * @param <T>   the type of elements in the list, must implement Comparable<T>
     * @param list  the ArrayList<T> to be sorted
     */
    public static <T extends Comparable<T>> void sort(ArrayList<T> list) {
        // Selection sort: repeatedly place the smallest element into position i
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;

            // Find index of smallest element from i to end
            for (int j = i + 1; j < list.size(); j++) {
                // compareTo returns:
                // < 0 if list[j] is less than list[minIndex]
                // = 0 if equal
                // > 0 if greater
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }

            // Swap list[i] with list[minIndex] if needed
            if (minIndex != i) {
                T temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }    
        }
    }

    /**
     * Prints all elements in the given collection.
     *
     * The wildcard "?" means:
     * - the method can accept a Collection of ANY type
     * 
     * @param collection  the collection to print
     */
    public static void printCollection(Collection<?> collection) {
        for (Object item : collection) {
            System.out.println(item);
        }
    }

    /**
     * Sums all Number elements in the given collection.
     *
     * The bounded wildcard "? extends Number" means:
     * - the method can accept a Collection of ANY type that is a subclass of Number
     * 
     * @param numbers  the collection of numbers to sum
     * @return the sum as a double
     */
    public static double sumNumbers(List<? extends Number> numbers) {
        double sum = 0.0;
        for (Number num : numbers) {
            sum += num.doubleValue(); // convert to double for summation
        }
        return sum;
    }
}