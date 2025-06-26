class Solution2 {
  // Global pointers for recursion
  private ListNode leftPointer;
  private boolean stop;

  public ListNode reverseBetween(ListNode head, int left, int right) {
    leftPointer = head;
    stop = false;

    // Move leftPointer to the left-th node
    for (int i = 1; i < left; i++) {
      leftPointer = leftPointer.next;
    }

    return head;
  }
}
