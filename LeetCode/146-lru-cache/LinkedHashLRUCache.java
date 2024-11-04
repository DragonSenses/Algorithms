import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Implements an LRU (Least Recently Used) Cache using
 * Java's built-in LinkedHashMap.
 */
public class LinkedHashLRUCache extends LinkedHashMap<Integer, Integer> {
  private int capacity;

  /**
   * Constructs an LRUCache with the specified capacity.
   * 
   * @param capacity The maximum number of items the cache can hold.
   */
  public LinkedHashLRUCache(int capacity) {
    super(capacity, 0.75f, true);
    this.capacity = capacity;
  }

  /**
   * Removes the eldest entry when the size of the cache exceeds the capacity.
   * 
   * @param eldest The eldest entry in the map.
   * @return true if the eldest entry should be removed, false otherwise.
   */
  @Override
  protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
    return size() > capacity;
  }

  /**
   * Retrieves the value associated with the specified key.
   * 
   * @param key The key whose associated value is to be returned.
   * @return The value associated with the specified key, or -1 if the key does
   *         not exist.
   */
  public int get(int key) {
    return super.getOrDefault(key, -1);
  }

  /**
   * Adds a key-value pair to the cache.
   * 
   * @param key   The key with which the specified value is to be associated.
   * @param value The value to be associated with the specified key.
   */
  public void put(int key, int value) {
    super.put(key, value);
  }
}
