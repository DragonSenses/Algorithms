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
 * Reverses a portion of a singly linked list from position `left` to `right` (1-indexed).
 * The reversal is performed in-place by manipulating node references.
 *
 * @param head - The head node of the original linked list.
 * @param left - The 1-based start position of the sublist to reverse.
 * @param right - The 1-based end position of the sublist to reverse.
 * @returns The head of the modified linked list after the reversal.
 */
function reverseBetween(
  head: ListNode | null,
  left: number,
  right: number
): ListNode | null {
  if (head === null) return null;

  const sentinel = new ListNode(0, head);
  let beforeLeft: ListNode = sentinel;

  // Move beforeLeft to the node immediately before position `left`
  for (let i = 1; i < left; i++) {
    beforeLeft = beforeLeft.next!;
  }

  const tail = beforeLeft.next!;
  let prev: ListNode | null = null;
  let curr: ListNode | null = tail;

  // Reverse the sublist from left to right
  for (let i = 0; i <= right - left; i++) {
    const next: ListNode | null = curr!.next;
    curr!.next = prev;
    prev = curr;
    curr = next;
  }

  // Reconnect reversed sublist back into the list
  beforeLeft.next = prev;
  tail.next = curr;

  // Return the modified list, skipping the sentinel
  return sentinel.next;
}