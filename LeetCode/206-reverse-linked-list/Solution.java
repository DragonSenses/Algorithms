/**
 * Provides an iterative solution to reverse a singly linked list.
 */
class Solution {

  /**
   * Reverses a singly linked list in-place using an iterative approach.
   *
   * @param head the head of the original linked list
   * @return the new head of the reversed linked list
   *
   * This method maintains three pointers to traverse the list and
   * reverse the direction of links:
   * - prev: points to the previous node in the reversed portion
   * - curr: current node being processed
   * - nextTemp: temporarily holds the next node to preserve traversal
   *
   * The algorithm runs in linear time and uses constant space.
   */
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;

    while (curr != null) {
      // Store the next node before breaking the link
      ListNode nextTemp = curr.next;

      // Reverse the current node's pointer
      curr.next = prev;

      // Advance prev to the current node
      prev = curr;

      // Advance curr to the next node in the original list
      curr = nextTemp;
    }

    // Return the new head of the reversed list
    return prev;
  }
}