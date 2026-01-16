import java.util.HashMap;
import java.util.Map;

/**
 * Part 3
 *
 * A generic Cache<T> class that implements key-value cache.
 *
 * Core operations:
 *  - add(key, value): store an item
 *  - get(key): retrieve an item (or null if missing)
 *  - clear(): remove everything
 *
 * Complex generic scenario:
 *  - addAll(...) using bounded wildcards to copy items between compatible caches
 * 
 * @author Dmitriy Chernichenko
 * @version IT212 Generics 2 - Cache Class
 */

public class Cache<T> {

    // Internal storage: key --> value
    private Map<String, T> map;

    // Constructor to initialize the cache
    public Cache() {
        this.map = new HashMap<>();
    }
    
    /**
     * Adds/Replaces a value in the cache)
     * 
     * @param key unique identifier for the value
     * @param value the value to store
     */
    public void add(String key, T value) {
            map.put(key, value);
        }
    
    /**
     * Retrieves a value by key)
     * 
     * @param key the key to look up
     * @return the stored value, or null if not present
     */
    public T get(String key) {
        return map.get(key);
    }
    
    /**
     * Clears all entries from the cache
     */
    public void clear() {
        map.clear();
    }

    /**
     * Returns the number of items stored in the cache)
     */
    public int size() {
        return map.size();
    }

    /**
     * Adds all entries from another cache into this cache.
     * 
     * The bounded wildcard "? extends T" means:
     * - the other cache can hold items of type T or any subtype of T
     * - ensuring type safety when copying items
     * 
     * @param source the other cache to copy items from
     */
    public void addAll(Cache<? extends T> source) {
        // Copy every entry from source to this cache
        for (Map.Entry<String, ? extends T> entry : source.map.entrySet()) {
            this.map.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public String toString() {
        return map.toString();
    }

}