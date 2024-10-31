class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val?: number, next?: ListNode | null) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }
}

/**
 * Partitions the linked list around a value x using the two-pointer approach.
 *
 * @param head The head of the linked list.
 * @param x The value around which the list is to be partitioned.
 * @return The head of the newly partitioned linked list.
 */
function partition(head: ListNode | null, x: number): ListNode | null {
  // Create sentinel nodes to start the lessThanX and greaterOrEqualX lists
  let lessThanXHead = new ListNode(0);
  let lessThanX = lessThanXHead;
  let greaterOrEqualXHead = new ListNode(0);
  let greaterOrEqualX = greaterOrEqualXHead;

  // Traverse the original linked list
  while (head !== null) {
    if (head.val < x) {
      // Add node to the lessThanX list
      lessThanX.next = head;
      lessThanX = lessThanX.next;
    } else {
      // Add node to the greaterOrEqualX list
      greaterOrEqualX.next = head;
      greaterOrEqualX = greaterOrEqualX.next;
    }
    head = head.next;
  }

  // Terminate the greaterOrEqualX list
  greaterOrEqualX.next = null;
  // Combine the lessThanX and greaterOrEqualX lists
  lessThanX.next = greaterOrEqualXHead.next;

  // Return the head of the new partitioned linked list
  return lessThanXHead.next;
};
