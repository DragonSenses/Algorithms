class Solution {
  public ListNode deleteDuplicates(ListNode head) {

    // Edge case: Empty list
    if (head == null) {
      return null;
    }

    for (ListNode current = head; (current != null && current.next != null); current =
        current.next) {
      // Duplicate values, modify pointers
      if (current.val == current.next.val) {
        current.next = current.next.next;
      }
    }

    return head;
  }
}
