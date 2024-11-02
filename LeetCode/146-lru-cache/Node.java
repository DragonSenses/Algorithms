public class Node {
  int key;
  int val;
  Node next;
  Node prev;

  public Node(int key, int val) {
    this.key = key;
    this.val = val;
    this.next = null;
    this.prev = null;
  }
}