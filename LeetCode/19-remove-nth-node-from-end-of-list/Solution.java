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

    ListNode curr = head;
    int len = 0;

    // First pass to find the length of the list
    for (; curr != null; curr = curr.next) {
      len++;
    }

    // Calculate the position to remove
    len-=n;

    // Reinitialize curr to the sentinel node
    curr = sentinel;

    // Move to the (len)th node
    for (; len > 0; len--) {
      curr = curr.next;
    }

    // Remove the nth node from the end
    curr.next = curr.next.next;

    return sentinel.next;
  }
}
