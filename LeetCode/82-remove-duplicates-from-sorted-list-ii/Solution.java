class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode sentinel = new ListNode(0, head);
    ListNode prevNode = sentinel;  // Tracks last distinct node before duplicates

    return sentinel.next;
  }
}