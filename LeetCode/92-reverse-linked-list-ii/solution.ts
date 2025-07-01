class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val?: number, next?: ListNode | null) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

function reverseBetween(head: ListNode | null, left: number, right: number): ListNode | null {
  if (head === null) return null;

  const sentinel = new ListNode(0, head);
  let beforeLeft: ListNode = sentinel;

  // Move beforeLeft to node before `left`
  for (let i = 1; i < left; i++) {
    beforeLeft = beforeLeft.next!;
  }

  const tail = beforeLeft.next!;
  let prev: ListNode | null = null;
  let curr: ListNode | null = tail;

}