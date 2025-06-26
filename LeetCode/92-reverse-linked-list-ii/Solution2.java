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

  private void recurse(ListNode rightPointer, int depth) {
    // Base case: stop at right-th node or end of list
    if (depth == 1 || rightPointer == null) {
      return;
    }

    // Walk rightPointer forward until depth reaches 1 (right boundary)
    recurse(rightPointer.next, depth - 1);
  }
}
