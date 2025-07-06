public class Solution2 {
  /**
   * Reverses a singly linked list using recursion.
   *
   * @param head The head of the original singly linked list.
   * @return The new head of the reversed linked list.
   *
   * This method uses a post-order recursive strategy. It traverses
   * to the tail node, then reassigns pointers during the unwind phase,
   * effectively reversing the list in-place.
   */
  public ListNode reverseList(ListNode head) {
    // Base case: empty list or single node — already reversed
    if (head == null || head.next == null) {
      return head;
    }

    // Recurse on the rest of the list
    ListNode reversedHead = reverseList(head.next);

    // Make the following node point back to current head
    head.next.next = head;

    // Disconnect current head from the rest of the list
    head.next = null;

    // Return new head found at the tail of the original list
    return reversedHead;
  }
}
