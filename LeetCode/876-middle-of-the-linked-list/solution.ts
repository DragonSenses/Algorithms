/**
 * Represents a node in a singly linked list.
 */
class ListNode {
  val: number;
  next: ListNode | null;

  /**
   * Constructs a new ListNode.
   * @param val - The integer value stored in the node. Defaults to 0.
   * @param next - Reference to the next node in the list. Defaults to null.
   */
  constructor(val?: number, next?: ListNode | null) {
    this.val = val ?? 0;
    this.next = next ?? null;
  }
}

/**
 * Returns the middle node of a singly linked list using the two-pointer approach.
 *
 * This function uses two traversal pointers:
 * - `slow` advances one node per iteration.
 * - `fast` advances two nodes per iteration.
 *
 * When `fast` reaches the end of the list, `slow` will be at the middle.
 * If the list has an even number of nodes, the second middle node is returned.
 *
 * @param head - The head of the singly linked list.
 * @returns The middle node of the list, or null if the input is null.
 */
function middleNode(head: ListNode | null): ListNode | null {
  let slow: ListNode | null = head;
  let fast: ListNode | null = head;

  while (fast != null && fast.next != null) {
    slow = slow!.next;
    fast = fast.next.next;
  }

  return slow;
};