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
  let sentinel: ListNode = new ListNode(-1, head); // Using -1 to signal a unusuable data
  let prevNode: ListNode = sentinel; // Tracks last unique node before duplicates

  while (head) {
    if (head.next && head.val === head.next.val) {
      while (head.next && head.val === head.next.val) {
        head = head?.next;
      }
      prevNode.next = head.next;
    } else {
      // Advance prevNode only when a unique element is found
      prevNode = prevNode.next!;
    }

    head = head.next;
  }

  return sentinel.next;
};