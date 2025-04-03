class Solution {

  /**
   * Removes duplicate nodes from a sorted linked list.
   * 
   * @param head The head node of the sorted linked list.
   * @return The head of the modified linked list with duplicates removed.
   */
  public ListNode deleteDuplicates(ListNode head) {

    // Handle the edge case of an empty list (head is null)
    if (head == null) {
      return null; // No duplicates to remove in an empty list
    }

    // Traverse the list starting from the head
    for (ListNode current = head; (current != null && current.next != null); current = current.next) {
      // Check if the current node's value matches the next node's value
      if (current.val == current.next.val) {
        // Skip the next node by updating the pointer to the node after the next
        current.next = current.next.next;
      }
    }

    // Return the modified list with duplicates removed
    return head;
  }
}