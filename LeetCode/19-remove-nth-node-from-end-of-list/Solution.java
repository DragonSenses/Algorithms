class Solution {
  /**
   * Removes the n-th node from the end of the list and returns the head of the modified list.
   *
   * @param head The head of the singly-linked list.
   * @param n The position from the end of the list of the node to be removed.
   * @return The head of the modified list.
   */
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode sentinel = new ListNode(0);
    sentinel.next = head;

    ListNode first = sentinel;
    ListNode second = sentinel;

    // Advance the first pointer n + 1 steps ahead (n nodes apart from second)
    for (int i = 1; i <= n + 1; i++) {
      first = first.next;
    }

    // Move both pointers together until the first pointer reaches past the last node
    while (first != null) {
      first = first.next;
      second = second.next;
    }

    // Remove the nth node from the end
    second.next = second.next.next;

    return sentinel.next;
  }
}
