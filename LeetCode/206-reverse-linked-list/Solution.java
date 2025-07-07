class Solution {
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;

    while (curr != null) {
      ListNode nextTemp = curr.next; // store next node
      curr.next = prev; // reverse current node's pointer
      prev = curr; // advance prev
      curr = nextTemp; // advance curr
    }

  }
}
