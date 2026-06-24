import java.util.HashSet;
import java.util.Set;

/**
 * Detects whether a singly linked list contains a cycle.
 *
 * A cycle exists if any node can be reached more than once by
 * following next pointers. This implementation uses a hash set
 * to record visited nodes and checks for repeats.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class Solution {

  /**
   * Returns true if the linked list has a cycle, false otherwise.
   *
   * @param head the head of the linked list
   * @return whether a cycle exists
   */
  public boolean hasCycle(ListNode head) {
    // Tracks nodes that have already been visited
    Set<ListNode> visited = new HashSet<>();

    // Cursor used to traverse the list
    ListNode current = head;

    // Traverse until reaching null or detecting a repeat
    while (current != null) {
      // If current node was seen before, a cycle exists
      if (visited.contains(current)) {
        return true;
      }

      // Mark node as visited
      visited.add(current);

      // Advance to next node
      current = current.next;
    }

    // Reached end of list without repeats
    return false;
  }
}
