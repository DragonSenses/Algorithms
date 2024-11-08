/**
 * Implementation of the insertion sort algorithm for a singly linked list.
 */
class Solution {

  /**
   * Sorts a singly linked list using the insertion sort algorithm.
   * 
   * @param head The head of the singly linked list.
   * @return The head of the sorted singly linked list.
   */
  public ListNode insertionSortList(ListNode head) {
    // Sentinel node acts as a placeholder for the sorted list's head.
    ListNode sentinel = new ListNode();
    ListNode curr = head; // Current node to be sorted.

    // Iterate through each node in the input list.
    while (curr != null) {
      ListNode prev = sentinel; // Pointer to traverse the sorted part of the list.

      // Find the correct position in the sorted list to insert the current node.
      while (prev.next != null && prev.next.val <= curr.val) {
        prev = prev.next;
      }

      // Save the next node to be processed.
      ListNode next = curr.next;
      // Insert the current node into the sorted part.
      curr.next = prev.next;
      prev.next = curr;

      // Move to the next node in the input list.
      curr = next;
    }

    // Return the head of the sorted list, which is the next node after sentinel.
    return sentinel.next;
  }
}
