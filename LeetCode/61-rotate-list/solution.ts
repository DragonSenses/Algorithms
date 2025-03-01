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
    
};