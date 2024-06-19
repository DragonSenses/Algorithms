// Definition for singly-linked list.
class ListNode {
  val: number;
  next: ListNode | null;

  constructor(val: number = 0, next: ListNode | null = null) {
    this.val = val;
    this.next = next;
  }
}

/**
 * Adds two numbers represented by linked lists.
 * @param l1 The head of the first linked list.
 * @param l2 The head of the second linked list.
 * @returns The head of the resulting linked list representing the sum.
 */
function addTwoNumbers(l1: ListNode | null, l2: ListNode | null): ListNode | null {
   // Initialize a sentinel node for the output linked list
  const sentinel = new ListNode(0);
  let current = sentinel; // Pointer to the current node in the output list
  let carry = 0; // Initialize carry (used for addition)

  // While there are digits in either list or a carry
  while (l1 || l2 || carry) {
    // Calculate the sum of current digits and carry
    const sum = (l1?.val || 0) + (l2?.val || 0) + carry;
    const digit = sum % 10; // Extract the last digit
    carry = Math.floor(sum / 10); // Update carry for the next iteration

    // Create a new node with the digit and link it to the output list
    current.next = new ListNode(digit);

    // Advance pointers in both input lists
    if (l1) l1 = l1.next;
    if (l2) l2 = l2.next;

    // Move to the next node in the output list
    current = current.next;
  }

  // If there's a final carry, add an additional node
  if (carry > 0) {
    current.next = new ListNode(carry);
  }

  // Return the actual result (skip the sentinel node)
  return sentinel.next;
};
