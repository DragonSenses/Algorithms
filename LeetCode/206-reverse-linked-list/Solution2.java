public class Solution2 {

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
