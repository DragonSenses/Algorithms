/**
 * Detects whether a singly linked list contains a cycle.
 *
 * This implementation uses Floyd's cycle finding algorithm.
 * Two pointers traverse the list at different speeds. If the
 * list contains a cycle, the fast pointer will eventually meet
 * the slow pointer inside the cycle.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class Solution2 {

  /**
   * Returns true if the linked list has a cycle, false otherwise.
   *
   * @param head the head of the linked list
   * @return whether a cycle exists
   */
  public boolean hasCycle(ListNode head) {
    // Early exit for empty or single-node lists
    if (head == null || head.next == null) {
      return false;
    }

    // Slow moves one step, fast moves two steps
    ListNode slow = head;
    ListNode fast = head;

    // Traverse while fast pointer can advance
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      // Pointers meet only if a cycle exists
      if (slow == fast) {
        return true;
      }
    }

    // Fast reached null, so no cycle exists
    return false;
  }
}
