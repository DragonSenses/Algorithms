class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val?: number, next?: ListNode | null) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

function deleteDuplicates(head: ListNode | null): ListNode | null {
  if (!head) {
    return null;
  }

  // Sentinel node simplifies edge cases
  let sentinel: ListNode = new ListNode(0, head);
  let prevNode: ListNode = sentinel; // Tracks last unique node before duplicates
};