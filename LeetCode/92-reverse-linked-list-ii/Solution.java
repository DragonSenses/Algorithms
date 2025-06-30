class Solution {
  public ListNode reverseBetween(ListNode head, int left, int right) {
    // Handle empty list case
    if (head == null) {
      return null;
    }

    // Create a sentinel node to simplify edge cases (e.g. reversal from head)
    ListNode sentinel = new ListNode(0);
    sentinel.next = head;

  }
}
