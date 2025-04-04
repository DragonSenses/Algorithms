class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val?: number, next?: ListNode | null) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

function deleteDuplicates(head: ListNode | null): ListNode | null {
  // Handle edge case: Empty list
  if (head === null) {
    return null; // No duplicates to remove in an empty list
  }

  let current = head;

  while (current !== null && current.next !== null) {

  }

  return null;
};