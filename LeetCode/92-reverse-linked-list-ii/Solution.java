class Solution {
  public ListNode reverseBetween(ListNode head, int left, int right) {
    // Handle empty list case
    if (head == null) {
      return null;
    }

    // Create a sentinel node to simplify edge cases (e.g. reversal from head)
    ListNode sentinel = new ListNode(0);
    sentinel.next = head;

    // Traverse to node before reversal starts
    ListNode beforeLeft = sentinel;
    for (int i = 1; i < left; i++) {
      beforeLeft = beforeLeft.next;
    }

    // Initialize pointers for reversal logic
    ListNode tail = beforeLeft.next; // First node of sublist to reverse
    ListNode prev = null; // Previous node in reversed portion
    ListNode curr = tail; // Current node being processed

    // Reverse sublist using iterative pointer manipulation
    for (int i = 0; i <= right - left; i++) {
      ListNode next = curr.next; // Preserve next node
      curr.next = prev; // Reverse link
      prev = curr; // Advance prev
      curr = next; // Advance curr
    }

  }
}
