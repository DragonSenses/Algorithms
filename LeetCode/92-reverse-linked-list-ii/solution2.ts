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

let successor: ListNode | null = null; // Tracks node after the reversed segment

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
  if (left === 1) {
    // Reverse first 'right' nodes
    return reverseN(head, right);
  }

  // Recurse closer to the left boundary
  head!.next = reverseBetween(head!.next, left - 1, right - 1);
  return head;

  /**
   * Helper function to reverse first `n` nodes in the list.
   * Returns the new head of the reversed segment.
   */
  function reverseN(head: ListNode | null, n: number): ListNode | null {
    if (n === 1 || head === null) {
      // This node becomes the tail after reversal; remember the successor
      successor = head?.next ?? null;
      return head;
    }

    const newHead = reverseN(head.next, n - 1);

    head.next!.next = head; // Reverse pointer
    head.next = successor; // Link to the rest of the list
    return newHead;
  }
}
