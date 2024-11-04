public class Node {
  int key;   // Key for the cache entry
  int val;   // Value for the cache entry
  Node next; // Pointer to the next node in the linked list
  Node prev; // Pointer to the previous node in the linked list

  public Node(int key, int val) {
    this.key = key;
    this.val = val;
    this.next = null;
    this.prev = null;
  }
}
