class ListNode {
  val: number;
  next: ListNode | null;

  constructor(val?: number, next?: ListNode | null) {
    this.val = val ?? 0;
    this.next = next ?? null;
  }
}

function reverseList(head: ListNode | null): ListNode | null {
  let prev: ListNode | null = null;
  let curr: ListNode | null = head;

  while (curr !== null) {
    // Temporarily store the next node before modifying the link
    const nextTemp: ListNode | null = curr.next;

    // Reverse the current node's pointer to point to the previous node
    curr.next = prev;

    // Move prev forward to the current node
    prev = curr;

    // Move curr forward to the next node in the original list
    curr = nextTemp;
  }

  // Return the new head of the reversed list
  return prev;
}