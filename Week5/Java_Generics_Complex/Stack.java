import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Part 1
 * A generic Stack<T> class that implements a stack data structure.
 *
 * This stack supports:
 *  - push(T item): add an item
 *  - pop(): remove and return the last pushed item
 *  - isEmpty(): check if the stack has no elements
 *
 * @author Dmitriy Chernichenko
 * @version IT212 Generics 2 - Stack Class
 */

public class Stack<T> {

    // internal storage for stack elements
    private ArrayList<T> items;

    // creates an empty stack
    public Stack() {
        items = new ArrayList<>();
    }

    // pushes an item onto the top of the stack.
    public void push(T item) {
        items.add(item);
    }

    // checks whether the stack is empty
    public boolean isEmpty() {
        return items.isEmpty();
    }

    /**
     * Pops (removes and returns) the top element of the stack.
     * 
     * @return the most recently pushed item
     * @throws EmptyStackException if the stack is empty
     */

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return items.remove(items.size() - 1);
    }

    @Override
    public String toString() {
        return items.toString();
    }    
}