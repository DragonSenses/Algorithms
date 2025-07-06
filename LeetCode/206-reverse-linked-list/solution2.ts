class ListNode {
  val: number;
  next: ListNode | null;

  constructor(val?: number, next?: ListNode | null) {
    this.val = val ?? 0;
    this.next = next ?? null;
  }
}

function reverseList(head: ListNode | null): ListNode | null {
  // Base case: empty list or single node — already reversed
  if (head === null || head.next === null) return head;

  // Recurse on the rest of the list
  const reversedHead = reverseList(head.next);

  // Return new head found at the tail of the original list
  return reversedHead;
}
