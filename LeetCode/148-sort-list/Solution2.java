class Solution2 {

  /**
   * Sorts a singly linked list using the top-down merge sort approach.
   * 
   * @param head The head of the singly linked list.
   * @return The head of the sorted singly linked list.
   */
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head; // Base case: if the list is empty or has only one node, it's already sorted.
    }

    // Split the list into two halves
    ListNode middle = getMiddle(head);
    ListNode nextToMiddle = middle.next;
    middle.next = null;

    // Recursively sort each half
    ListNode left = sortList(head);
    ListNode right = sortList(nextToMiddle);

    // Merge the sorted halves
    return merge(left, right);
  }

  /**
   * Finds the middle of the linked list using the fast and slow pointer approach.
   * 
   * @param head The head of the linked list.
   * @return The middle node of the linked list.
   */
  private ListNode getMiddle(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode slow = head;
    ListNode fast = head;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  /**
   * Merges two sorted linked lists into a single sorted linked list.
   * 
   * @param left  The head of the first sorted linked list.
   * @param right The head of the second sorted linked list.
   * @return The head of the merged sorted linked list.
   */
  private ListNode merge(ListNode left, ListNode right) {
    ListNode sentinel = new ListNode(0);
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

    return sentinel.next;
  }
}
