class Solution2 {
  // Global pointers for recursion are object level variables
  // Need changes to persist across recursive calls since Java is Pass By Value
  private ListNode leftPointer;
  private boolean stop;

  public ListNode reverseBetween(ListNode head, int left, int right) {
    leftPointer = head;
    stop = false;

    // Start recursive backtracking from head
    recurseAndReverse(head, left, right);

    return head;
  }

  private void recurseAndReverse(ListNode right, int m, int n) {
    // Base case: stop at right-th node or end of list
    if (n == 1 || right == null) {
      return;
    }

    // Walk right pointer one step forward until it reaches (n == 1) (right boundary)
    right = right.next;

    // Keep moving left pointer to the right until we reach the proper node to start reversal
    if (m > 1) {
      this.leftPointer = this.leftPointer.next;
    }

    // Recursive call with m and n reduced
    this.recurseAndReverse(right, m - 1, n - 1);

    // Stop condition: pointers have met or crossed
    if (leftPointer == right || (right != null && leftPointer.next == right)) {
      stop = true;
    }

    // Swap values unless pointers have crossed
    if (!stop && right != null) {
      int temp = leftPointer.val;
      leftPointer.val = right.val;
      right.val = temp;

      // Advance leftPointer forward
      leftPointer = leftPointer.next;
    }

  }
}
