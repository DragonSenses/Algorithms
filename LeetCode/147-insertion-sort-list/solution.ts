class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val?: number, next?: ListNode | null) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

/**
 * Sorts a singly linked list using the insertion sort algorithm.
 * @param {ListNode | null} head - The head of the singly linked list.
 * @returns {ListNode | null} The head of the sorted singly linked list.
 */
function insertionSortList(head: ListNode | null): ListNode | null {
  // Sentinel node acts as a placeholder for the sorted list's head.
  let sentinel = new ListNode();
  let curr = head; // Current node to be sorted.

  // Iterate through each node in the input list.
  while (curr !== null) {
    let prev = sentinel; // Pointer to traverse the sorted part of the list.

    // Find the correct position in the sorted list to insert the current node.
    while (prev.next !== null && prev.next.val <= curr.val) {
      prev = prev.next;
    }

    // Save the next node to be processed.
    let next = curr.next;
    // Insert the current node into the sorted part.
    curr.next = prev.next;
    prev.next = curr;

    // Move to the next node in the input list.
    curr = next;
  }

  // Return the head of the sorted list, which is the next node after sentinel.
  return sentinel.next;
};
