/**
 * Removes all duplicate occurrences from a sorted linked list,
 * ensuring only distinct values remain.
 *
 * This approach uses a sentinel node to simplify edge case handling,
 * and a tracking pointer (`prevUnique`) to manage deletions efficiently.
 *
 * @param head The head of the sorted linked list.
 * @return The modified list with all duplicate elements removed.
 */
class Solution {
  /**
   * Deletes all nodes containing duplicate values from a sorted linked list.
   *
   * @param head The head of the linked list.
   * @return The head of the modified list with only distinct values.
   */
  public ListNode deleteDuplicates(ListNode head) {
    // Edge case: If the list is empty, return null immediately.
    if (head == null) {
      return null;
    }

    // Sentinel node simplifies edge cases where the head may be removed.
    ListNode sentinel = new ListNode(0, head);
    
    // Tracks the last distinct node before duplicate sequences.
    ListNode prevUnique = sentinel; 

    // Traverse the list.
    while (head != null) {
      // If a duplicate sequence is detected:
      if (head.next != null && head.val == head.next.val) {
        // Move to the last occurrence within the duplicate sequence.
        while (head.next != null && head.val == head.next.val) {
          head = head.next;
        }
        // Remove all occurrences of the duplicate value.
        prevUnique.next = head.next;
      } else {
        // Move prevUnique forward only when a unique value is found.
        prevUnique = prevUnique.next;
      }

      // Advance the head pointer to the next node.
      head = head.next;
    }

    // Return the modified list, skipping the sentinel node.
    return sentinel.next;
  }
}