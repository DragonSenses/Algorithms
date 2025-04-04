class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val?: number, next?: ListNode | null) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

/**
 * Removes duplicate nodes from a sorted linked list.
 * @param head - The head node of the sorted linked list.
 * @returns The modified linked list with duplicates removed.
 */
function deleteDuplicates(head: ListNode | null): ListNode | null {
  // Handle edge case: Empty list
  if (head === null) {
    return null; // No duplicates to remove in an empty list
  }

  let current = head;

  // Traverse the list using a while loop
  while (current !== null && current.next !== null) {
    // Check if the current node's value matches the next node's value
    if (current.val === current.next.val) {
      // Skip the next node by updating the pointer
      current.next = current.next.next;
    } else {
      // Move to the next node
      current = current.next;
    }
  }

  // Return the modified list with duplicates removed
  return head;
};