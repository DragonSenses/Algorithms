// Definition for singly-linked list.
class ListNode {
  val: number;
  next: ListNode | null;

  constructor(val: number = 0, next: ListNode | null = null) {
    this.val = val;
    this.next = next;
  }
}

function addTwoNumbers(l1: ListNode | null, l2: ListNode | null): ListNode | null {
  const sentinel = new ListNode(0);
  let current = sentinel;
  let carry = 0;

  while (l1 || l2 || carry) {
    const sum = (l1?.val || 0) + (l2?.val || 0) + carry;
    const digit = sum % 10;
    carry = Math.floor(sum / 10);

    current.next = new ListNode(digit);

    if (l1) l1 = l1.next;
    if (l2) l2 = l2.next;

    current = current.next;
  }

  if (carry > 0) {
    current.next = new ListNode(carry);
  }

  return sentinel.next;
};
