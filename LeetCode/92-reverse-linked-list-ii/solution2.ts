/**
 * Represents a node in a singly linked list.
 */
class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val?: number, next?: ListNode | null) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

/**
 * Reverses a sublist of a singly linked list from position `left` to `right` (1-indexed).
 * The reversal is performed in-place using recursion.
 *
 * @param head - The head of the input linked list.
 * @param left - The starting position of the sublist to reverse.
 * @param right - The ending position of the sublist to reverse.
 * @returns The head of the modified linked list.
 */
function reverseBetween(
  head: ListNode | null,
  left: number,
  right: number
): ListNode | null {
  let leftPointer = head;
  let stop = false;

  /**
   * Recursively reverses a portion of the list between two boundaries.
   *
   * @param rightNode - The current node on the right side of the reversal.
   * @param m - Steps remaining to reach the left boundary.
   * @param n - Steps remaining to reach the right boundary.
   */
  function recurseAndReverse(
    rightNode: ListNode | null,
    m: number,
    n: number
  ): void {
    // Base case: stop at right-th node or end of list
    if (n === 1 || rightNode === null) return;

    // Walk right pointer one step forward until it reaches (n == 1) (right boundary)
    rightNode = rightNode.next;

    // Keep moving left pointer to the right until we reach the proper node to start reversal
    if (m > 1) {
      leftPointer = leftPointer!.next;
    }

    // Recursive call with m and n reduced
    recurseAndReverse(rightNode, m - 1, n - 1);

    // Stop condition: pointers have met or crossed
    if (
      leftPointer === rightNode ||
      (rightNode !== null && leftPointer?.next === rightNode)
    ) {
      stop = true;
    }

    // Swap values unless pointers have crossed
    if (!stop && rightNode !== null) {
      const temp = leftPointer!.val;
      leftPointer!.val = rightNode.val;
      rightNode.val = temp;

      // Advance leftPointer forward
      leftPointer = leftPointer!.next;
    }
  }

  // Start recursive backtracking from head
  recurseAndReverse(head, left, right);

  // Return the modified list in-place
  return head;
}