class ListNode {
  val: number;
  next: ListNode | null;

  constructor(val?: number, next?: ListNode | null) {
    this.val = val ?? 0;
    this.next = next ?? null;
  }
}

/**
 * Removes all duplicate occurrences from a sorted linked list,
 * ensuring only distinct values remain.
 *
 * This function uses a sentinel node to handle edge cases
 * and a tracking pointer (`prevNode`) to manage deletions efficiently.
 *
 * @param {ListNode | null} head - The head of the sorted linked list.
 * @returns {ListNode | null} - The modified list with duplicates removed.
 */
function deleteDuplicates(head: ListNode | null): ListNode | null {
  if (!head) {
    return null;
  }

  // Create a sentinel node to act as a pseudo-head for easier deletion handling.
  let sentinel: ListNode = new ListNode(-1, head); // Using -1 as a placeholder value
  let prevNode: ListNode = sentinel; // Tracks last unique node before a duplicate sequence

  while (head) {
    if (head.next && head.val === head.next.val) {
      // Move to the last occurrence within the duplicate sequence
      while (head.next && head.val === head.next.val) {
        head = head.next;
      }
      // Skip all occurrences of the duplicate value
      prevNode.next = head.next;
    } else {
      // Move prevNode forward only when a unique value is found
      prevNode = prevNode.next!;
    }

    head = head.next;
  }

  return sentinel.next; // Return the modified list, excluding the sentinel node.
}
