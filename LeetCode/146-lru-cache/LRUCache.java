import java.util.HashMap;

class LRUCache {

  public class Node {
    int key; // Key for the cache entry
    int val; // Value for the cache entry
    Node next; // Pointer to the next node in the linked list
    Node prev; // Pointer to the previous node in the linked list

    public Node(int key, int val) {
      this.key = key;
      this.val = val;
      this.next = null;
      this.prev = null;
    }
  }

  private int capacity;
  private HashMap<Integer, Node> map;
  private Node head;
  private Node tail;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.map = new HashMap<>();
    this.head = new Node(0, 0);
    this.tail = new Node(0, 0);
    head.next = tail;
    tail.prev = head;
  }

  public void add(Node node) {
    Node previousEnd = tail.prev;
    previousEnd.next = node;
    node.prev = previousEnd;
    node.next = tail;
    tail.prev = node;
  }

  public void remove(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  public int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    }

    Node node = map.get(key);
    remove(node);
    add(node);
    return node.val;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      Node oldNode = map.get(key);
      remove(oldNode);
    }

    Node node = new Node(key, value);
    map.put(key, node);
    add(node);

    if (map.size() > capacity) {
      Node nodeToDelete = head.next;
      remove(nodeToDelete);
      map.remove(nodeToDelete.key);
    }
  }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
