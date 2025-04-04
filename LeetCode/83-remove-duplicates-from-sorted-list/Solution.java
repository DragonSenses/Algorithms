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

    ListNode current = head;

    // Traverse the list starting from the head
    while (current != null && current.next != null) {
      if (current.val == current.next.val) {
        current.next = current.next.next; // Skip duplicate
      } else {
        current = current.next; // Move to the next node
      }
    }

    // Return the modified list with duplicates removed
    return head;
  }
}