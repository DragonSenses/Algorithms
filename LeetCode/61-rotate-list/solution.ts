/**
 * Class representing a singly-linked list node.
 */
class ListNode {
  val: number;
  next: ListNode | null;

  /**
   * Creates a ListNode.
   * @param val - The value of the node.
   * @param next - The reference to the next node.
   */
  constructor(val?: number, next?: ListNode | null) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

function rotateRight(head: ListNode | null, k: number): ListNode | null {
  // Handle edge cases where no rotation is needed:
  // - Empty list
  // - Single-node list
  // - Zero rotations requested
  if (!head || !head.next || k === 0) {
    return head;
  }

  // Step 1: Calculate the length of the list and close it into a circular list
  let oldTail: ListNode = head;
  let length: number = 1;

  while (oldTail.next) {
    oldTail = oldTail.next;
    length++;
  }
  oldTail.next = head; // Form a circular list

  // Step 2: Compute the effective rotations
  k = k % length; // Avoid unnecessary rotations

  // Step 3: Find the new tail and head
  const stepsToNewTail: number = length - k - 1;
  let newTail: ListNode = head;

  for (let i = 0; i < stepsToNewTail; i++) {
    newTail = newTail.next as ListNode;
  }

  const newHead: ListNode | null = newTail.next;

  // Step 4: Break the circular list
  newTail.next = null;

  return newHead;
}
