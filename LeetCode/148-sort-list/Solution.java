class Solution {

  /**
   * Sorts a singly linked list using the bottom-up merge sort approach.
   * 
   * @param head The head of the singly linked list.
   * @return The head of the sorted singly linked list.
   */
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head; // Base case: if the list is empty or has only one node, it's already sorted.
    }

    ListNode sentinel = new ListNode(0); // Sentinel node for ease of manipulation
    sentinel.next = head;
    int sublistSize = 1;

    while (true) {
      ListNode current = sentinel.next; // Start of the current sublist to be processed
      ListNode prevTail = sentinel;
      boolean listMerged = false; // Flag to check if any merging happened in this pass

      while (current != null) {
        ListNode left = current; // Left sublist starts from current node
        ListNode right = split(left, sublistSize); // Split the list into two parts of given size
        current = split(right, sublistSize); // Update current to the next sublist to be processed

        prevTail.next = merge(left, right); // Merge the two sublists

        // Update prevTail to the end of the merged list
        while (prevTail.next != null) {
          prevTail = prevTail.next;
        }
        listMerged = true;
      }

      if (!listMerged) {
        break; // If no merging happened, the list is sorted
      }
      sublistSize *= 2; // Double the sublist size for the next iteration
    }

    return sentinel.next; // Return the sorted list, skipping the sentinel node
  }

  /**
   * Splits the list into two parts of the given size.
   * 
   * @param start The start node of the list to be split.
   * @param size  The size of the first part.
   * @return The start node of the second part.
   */
  private ListNode split(ListNode start, int size) {
    if (start == null) {
      return null;
    }
    for (int i = 1; i < size && start.next != null; i++) {
      start = start.next;
    }
    ListNode nextSubList = start.next;
    start.next = null; // Split the list
    return nextSubList;
  }

  /**
   * Merges two sorted linked lists into one sorted list.
   * 
   * @param left  The head of the first sorted linked list.
   * @param right The head of the second sorted linked list.
   * @return The head of the merged sorted linked list.
   */
  private ListNode merge(ListNode left, ListNode right) {
    ListNode sentinel = new ListNode(0); // Sentinel node to simplify merging
    ListNode current = sentinel;

    while (left != null && right != null) {
      if (left.val <= right.val) {
        current.next = left;
        left = left.next;
      } else {
        current.next = right;
        right = right.next;
      }
      current = current.next;
    }

    // Append any remaining nodes
    if (left != null) {
      current.next = left;
    } else {
      current.next = right;
    }

    return sentinel.next; // Return the merged list, skipping the sentinel node
  }
}
