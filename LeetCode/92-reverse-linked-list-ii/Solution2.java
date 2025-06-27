/**
 * Class containing a recursive solution to reverse a sublist within a singly linked list
 * between the given left and right positions (1-indexed).
 */
class Solution2 {
  /**
   * Global pointer used to track the left-side node during recursion.
   * Needs to persist across recursive calls since Java is pass-by-value for objects.
   */
  private ListNode leftPointer;

  /** Flag to prevent over-swapping once left and right pointers cross. */
  private boolean stop;

  /**
   * Reverses a sublist of a singly linked list from position left to right.
   * Uses recursive backtracking and in-place value swapping.
   *
   * @param head The head of the input linked list
   * @param left The starting position (1-indexed) of the sublist to reverse
   * @param right The ending position (1-indexed) of the sublist to reverse
   * @return The head of the modified list with the sublist reversed
   */
  public ListNode reverseBetween(ListNode head, int left, int right) {
    leftPointer = head;
    stop = false;

    // Start recursive backtracking from head
    recurseAndReverse(head, left, right);

    return head;
  }

  /**
   * Recursively traverses the list and swaps values between mirrored nodes within the sublist.
   * The recursion unwinds once it reaches the node at position right, and swaps
   * values between {@code leftPointer} and right on backtrack.
   *
   * @param right The current right-side node in the recursion
   * @param m The remaining steps until reaching the left boundary
   * @param n The remaining steps until reaching the right boundary
   */
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
