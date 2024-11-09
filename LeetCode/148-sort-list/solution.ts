class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val?: number, next?: ListNode | null) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

function sortList(head: ListNode | null): ListNode | null {
  if (!head || !head.next) {
    return head; // Base case: if the list is empty or has only one node, it's already sorted.
  }

  // Split the list into two halves
  const middle = getMiddle(head);
  const nextToMiddle = middle.next;
  middle.next = null;

  // Recursively sort each half
  const left = sortList(head);
  const right = sortList(nextToMiddle);

  // Merge the sorted halves
  return merge(left, right);
};

// Helper function to find the middle of the linked list using the fast and slow pointer approach
function getMiddle(head: ListNode): ListNode {
  if (!head) {
    return head;
  }
  let slow: ListNode = head;
  let fast: ListNode = head;

  while (fast.next && fast.next.next) {
    slow = slow.next;
    fast = fast.next.next;
  }
  return slow;
}

// Helper function to merge two sorted linked lists
function merge(left: ListNode | null, right: ListNode | null): ListNode | null {
  const sentinel = new ListNode(0);
  let current = sentinel;

  while (left !== null && right !== null) {
    if (left.val <= right.val) {
      current.next = left;
      left = left.next;
    } else {
      current.next = right;
      right = right.next;
    }
    current = current.next;
  }

  // Append any remaining nodes
  if (left !== null) {
    current.next = left;
  } else {
    current.next = right;
  }

  return sentinel.next;
}