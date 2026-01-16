/**
 * Part 1
 * A generic Pair class that stores two related values:
 * - K: the "key" type
 * - V: the "value" type
 *
 * @author Dmitriy Chernichenko
 * @version IT212 Generics 2 - Pair Class
 */
public class Pair<K, V> {
    
    // Instance variables holding the key and value
    private K key;
    private V value;

    // Constructor to initialize the Pair with a key and a value
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    // Returns the key (type K)
    public K getKey() {
        return key;
    }

    // Sets/replaces the key (type K)
    public void setKey(K key) {
        this.key = key;
    }

    // Returns the value (type V)
    public V getValue() {
        return value;
    }

    // Sets/replaces the value (type V)
    public void setValue(V value) {
        this.value = value;
    }

    // Returns a readable string version of the Pair
    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}
